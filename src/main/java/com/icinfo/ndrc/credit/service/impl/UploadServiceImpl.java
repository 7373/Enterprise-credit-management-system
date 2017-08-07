/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.service.IUploadService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * 描述:    nd_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
@Service
public class UploadServiceImpl extends MyBatisServiceSupport implements IUploadService {

	@Override
	public String doGetFileName(String deptName) throws Exception {
		return deptName+new SimpleDateFormat("yyyyMMdd").format(new Date())+".xls";
	}

	@Override
	public ResponseEntity<byte[]> downTemple(String fileName,HttpServletRequest request,String deptName) throws Exception {
		byte[] buffer = null;
		HttpHeaders headers = new HttpHeaders();
		try {
			File file = new File(request.getSession().getServletContext().getRealPath("/")+"/WEB-INF/views/temple/"+deptName+".xls");
			FileInputStream fis = new FileInputStream(file);
			byte[] b = new byte[1024];
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
			// 处理响应
			if (request.getHeader("User-Agent").contains("MSIE")
					|| request.getHeader("User-Agent").contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}