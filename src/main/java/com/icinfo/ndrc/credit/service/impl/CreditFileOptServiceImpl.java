package com.icinfo.ndrc.credit.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chinaoly.oss.SgsOSSClient;
import com.icinfo.ndrc.credit.service.ICreditFileOptService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.util.FileUtil;
import com.icinfo.ndrc.util.OssUtil;
import com.icinfo.ndrc.util.RequestUtil;
import com.icinfo.ndrc.util.UUIDUtils;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 文件相关操作
 * 
 * @author zhuyong
 */
@Service
public class CreditFileOptServiceImpl extends MyBatisServiceSupport implements ICreditFileOptService {
	
	@Value("${cloudModel}")
	private String cloudModel;//云模式
	
	@Value("${filePath}")
	private String filePath;
	
	@Autowired
	private SgsOSSClient ossClient;//oss client

	/**
	 * 文件上传
	 * 
	 * @author zhuyong
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
	/**
	 * 处理文件名
	 * @param fileName
	 * @return
	 */
	public String doGetFileName(String fileName){
		fileName = fileName.replaceAll("\\\\", "/");
   		fileName =  "ndrc" + UUIDUtils.randomUUID()+ "-" + fileName;
   		return fileName;
	}
	
	/**
	 * 将服务器文件下载到本地
	 * 
	 * @author zhuyong
	 * @param sourceDir
	 * @param targetDir
	 * @throws Exception
	 */
	public void download(String sourceDir,String targetDir) throws Exception{
		if(Constants.CLOUDMODEL_OPEN.equalsIgnoreCase(cloudModel)){//云模式
			OssUtil.saveFile(ossClient, sourceDir, targetDir);
		}else{//本地模式
			FileUtil.fileCopy(sourceDir, targetDir);
		}
	}
	
	/**
	 * 查看图片
	 * @author zjj
	 */
	public String lookpic(String fileName,HttpServletResponse response) throws Exception{
		response.setCharacterEncoding("utf-8");
		 response.setContentType("image/png");  
	     File file = new File(filePath+File.separator + fileName);
	     FileInputStream fis =  new FileInputStream(file);
	     byte[] b = new byte[fis.available()];
	     fis.read(b);
	     OutputStream out = response.getOutputStream();
	     out.write(b);
	     out.flush();
	     return null;
	}
	
}
