package com.icinfo.ndrc.credit.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.icinfo.framework.core.service.BaseService;

public interface IUploadService extends BaseService{

	/**
	 * 获取文件名称
	 * @author zjj
	 */
	public String doGetFileName(String deptName) throws Exception;
	/**
	 * 获取模板
	 * @author zjj
	 */
	public ResponseEntity<byte[]> downTemple(String fileName,HttpServletRequest request,String deptName) throws Exception;
}
