/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.chinaoly.oss.SgsOSSClient;
import com.icinfo.ndrc.credit.dto.NdCreditAppealDto;
import com.icinfo.ndrc.credit.mapper.NdCreditAppealMapper;
import com.icinfo.ndrc.credit.model.NdCreditAppeal;
import com.icinfo.ndrc.credit.service.ICreditFileOptService;
import com.icinfo.ndrc.credit.service.INdCreditAppealService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.util.FileUtil;
import com.icinfo.ndrc.util.OssUtil;
import com.icinfo.ndrc.util.RequestUtil;
import com.icinfo.ndrc.util.UUIDUtils;
import com.icinfo.ndrc.util.ZipUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:    nd_credit_appeal 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
@Service
public class NdCreditAppealServiceImpl extends MyBatisServiceSupport implements INdCreditAppealService {

	@Value("${cloudModel}")
	private String cloudModel;//云模式
	
	@Value("${filePath}")
	private String filePath;
	
	@Value("${fileDownPath}")
	private String fileDownPath;
	
	@Autowired
	private SgsOSSClient ossClient;//oss client
	
	@Autowired
	NdCreditAppealMapper ndCreditAppealMapper;
	
	@Autowired
	ICreditFileOptService creditFileOptService;
	
	@Override
	/**
	 * 文件上传
	 * @author zjj
	 * @param filaName
	 * @return
	 * @throws Exception
	 */
	public String upload(MultipartFile files,String filaName) throws Exception{
		//云模式开启
		if(Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel))
			return OssUtil.uploadToOSS(ossClient,files,doGetFileName(filaName),filePath);
        return FileUtil.uploadToLoc(files, doGetFileName(filaName), filePath);			
	}
	/**
	 * 视频文件上传
	 * @author ylr
	 * @param filaName
	 * @return
	 * @throws Exception
	 */
	@Override
	public String uploadvideo(MultipartFile files, String filaName, HttpServletRequest request) throws Exception {
		//云模式开启
		if(Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel))
			return OssUtil.uploadToOSS(ossClient,files,doGetFileName(filaName),filePath);
		String path = request.getServletContext().getRealPath("/")+ File.separator+"WEB-INF"+File.separator+"views"+File.separator+"file";
		System.out.println("---------------"+path);
		return FileUtil.uploadToLoc(files, doGetFileName(filaName), path);
	}

	/**
	 * 处理文件名
	 * @param fileName
	 * @return
	 */
	public String doGetFileName(String fileName){
		fileName = fileName.replaceAll("\\\\", "/");
   		fileName =  "credit" + UUIDUtils.randomUUID()+ "-" + fileName;
   		return fileName;
	}
	/**
	 * 文件下载
	 * 
	 * @author zhuyong
	 * @param fileName
	 * @throws exception
	 */
	public ResponseEntity<byte[]> download(String fileName) throws Exception{
		//云模式开启
		if(Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel))
			return OssUtil.downFormOSS(ossClient, filePath+"/"+fileName, RequestUtil.getRequest());
		return FileUtil.downFromLoc(fileName,RequestUtil.getRequest(),filePath);
	}
	@Override
	public int insert(NdCreditAppealDto ndCreditAppealDto) throws Exception {
		return ndCreditAppealMapper.insert(ndCreditAppealDto);
	}
	
	@Override
	public List<NdCreditAppealDto> doGetList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return ndCreditAppealMapper.selectNdCreditAppealList(request.getParams());
	}
	@Override
	public List<NdCreditAppealDto> selectList(Map<String, Object> qryMap) throws Exception {
		return ndCreditAppealMapper.selectNdCreditAppealList(qryMap);
	}
	@Override
	public String downloadFile(String uid, String proveMaterial) throws Exception {
		
		String rootPath = createZipPath(uid);
		FileUtil.mkDir(rootPath);
		
		List<String> FileList = new ArrayList<String>();
		if(StringUtils.isNotBlank(proveMaterial)){//获取所有附件名称
			FileList.addAll(Arrays.asList(proveMaterial.split("\\|")));
		}
		for(String fileName : FileList){//将所有附件下载到文件夹中
			creditFileOptService.download(filePath+"/"+fileName, rootPath+"/"+fileName);
		}
		
		ZipUtil.zip(rootPath);
		return fileDownPath;
	}
	/**
	 * 创建zip路径
	 * @author zjj
	 */
	public String createZipPath(String uid) throws Exception{
		return fileDownPath + "/"+uid;
	}
	
	/**
	 * 更新
	 * @author fanzhen
	 * @date 20170614
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int UpdateNdCreditAppealDto(NdCreditAppeal dto) throws Exception {
		
		return ndCreditAppealMapper.UpdateNdCreditAppealDto(dto);
	}
	
}