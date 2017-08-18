/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.ndrc.credit.dto.NdCreditAppealDto;
import com.icinfo.ndrc.credit.model.NdCreditAppeal;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:    nd_credit_appeal 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public interface INdCreditAppealService extends BaseService {
	
	/**
	 * 文件上传
	 * @author zjj
	 * @param filaName
	 * @return
	 * @throws Exception
	 */
	public String upload(MultipartFile files,String filaName) throws Exception;

	/**
	 * 视频文件上传
	 * @author ylr
	 * @param filaName
	 * @return
	 * @throws Exception
	 */
	public String uploadvideo(MultipartFile files, String filaName, HttpServletRequest request) throws Exception;
	/**
	 * 文件下载
	 * @author zjj
	 * @param fileName
	 * @throws exception
	 */
	public ResponseEntity<byte[]> download(String fileName) throws Exception;
	/**
	 * 保存信用申诉
	 * @author zjj
	 */
	public int insert(NdCreditAppealDto ndCreditAppealDto) throws Exception;
	/**
	 * 获取异议申诉的数据
	 * @author zjj
	 */
	public List<NdCreditAppealDto> doGetList(PageRequest request) throws Exception;
	
	/**
	 * 获取异议申诉的数据
	 * @author zjj
	 */
	public List<NdCreditAppealDto> selectList(Map<String,Object> qryMap) throws Exception;
	/**
	 * 获取下载文件
	 */
	public String downloadFile(String uid,String proveMaterial) throws Exception;
	
	/**
	 * 更新
	 * @author fanzhen
	 * @date 20170614
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int UpdateNdCreditAppealDto(NdCreditAppeal dto) throws Exception;
}