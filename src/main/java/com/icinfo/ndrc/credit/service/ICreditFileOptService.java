package com.icinfo.ndrc.credit.service;


import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.framework.core.service.BaseService;

/**
 * 文件相关操作 
 * 
 * @author zhuyong
 */
public interface ICreditFileOptService extends BaseService{
	
	/**
	 * 文件上传
	 * 
	 * @author zhuyong
	 * @param filaName
	 * @return
	 * @throws Exception
	 */
	public String upload(MultipartFile files,String filaName) throws Exception;
	
	/**
	 * 文件下载
	 * 
	 * @author zhuyong
	 * @param fileName
	 * @throws exception
	 */
	public ResponseEntity<byte[]> download(String fileName) throws Exception;
	
	/**
	 * 将服务器文件下载到本地
	 * 
	 * @author zhuyong
	 * @param sourceDir
	 * @param targetDir
	 * @throws Exception
	 */
	public void download(String sourceDir,String targetDir) throws Exception;
	
}
