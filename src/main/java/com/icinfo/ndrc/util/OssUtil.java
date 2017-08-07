package com.icinfo.ndrc.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSException;
import com.chinaoly.oss.SgsOSSClient;

public class OssUtil {
	
	
	/**
	 * 列出文件夹下一定数目的文件
	 * 
	 * @param dir
	 *            文件夹路径，路径结尾需带/，若dir为null或空或/，则为应用根目录
	 * @return
	 */
	public static List<String> getFileListLimit(SgsOSSClient ossClient, String dir, Integer num) {
		if (num < 1 || num > 1000) {
			return null;
		}
		return ossClient.listObjects(dir, num);// 返回文件列表
	}
	
	/**
	 * 列出对应文件夹下的所有文件
	 * 
	 * @param dir
	 *            文件夹路径，路径结尾需带/，若dir为null或空或/，则为应用根目录
	 * @return
	 */
	public static List<String> getFileList(SgsOSSClient ossClient, String dir) {
		return ossClient.listAllObjects(dir); // 返回文件列表
	}
	


	/**
	 * 文件上传
	 * 
	 * @param srcFilePath
	 *            文件来源路径
	 * @param targetFilePath
	 *            要上传到OSS上的文件路径
	 * @return
	 */
	public static boolean putFile(SgsOSSClient ossClient, String srcFilePath, String targetFilePath) {
		System.out.println("文件来源路径：" + srcFilePath);
		System.out.println("要上传到OSS上的文件路径：" + targetFilePath);
		boolean result = ossClient.putFile(targetFilePath, srcFilePath); // 返回true:上传成功；false：上传失败
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}

	/**
	 * 
	 * @param srcFilePath
	 *            文件来源路径
	 * @param targetFilePath
	 *            要上传到OSS上的文件路径
	 * @return
	 */
	public static boolean putStream(SgsOSSClient ossClient, String srcFilePath, String targetFilePath)
			throws IOException {
		File file = new File(srcFilePath);
		InputStream content = new FileInputStream(file); // 要上传的文件流
		boolean result = ossClient.putStream(targetFilePath, content); // 返回true:上传成功；false：上传失败
		content.close();
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}

	/**
	 * 直接上传Spring mvc 的MultipartFile文件流
	 * 
	 * @param file
	 * @param targetFilePath
	 * @return
	 * @throws IOException
	 */
	public static boolean putStream(SgsOSSClient ossClient, MultipartFile file, String targetFilePath)
			throws Exception {
		System.out.println("OSS 上传开始");
		InputStream content = file.getInputStream(); // 要上传的文件流
		boolean result = ossClient.putStream(targetFilePath, content); // 返回true:上传成功；false：上传失败
		content.close();
		System.out.println("oss 上传结束，返回结果" + result);
		return result;
	}
	

	/**
	 * 下载文件到本地
	 * 
	 * @param srcFilePath
	 *            OSS文件存放路径
	 * @param localFilePath
	 *            保存本地文件路径
	 */
	public static boolean saveFile(SgsOSSClient ossClient, String srcFilePath, String localFilePath) {
		if (isWindows()) {
			localFilePath = localFilePath.replaceAll("\\\\", "/");
		}
		System.out.println("OSS 下载开始");
		System.out.println("OSS文件存放路径：" + srcFilePath);
		System.out.println("保存本地文件路径：" + localFilePath);
		boolean result = false;
		result = ossClient.saveFile(srcFilePath, localFilePath); // 返回true:下载成功；false：下载失败
		System.out.println("oss 下载结束，返回结果" + result);
		return result;
	}

	/**
	 * 上传到OSS服务器
	 * 
	 * @param files
	 * @param fileName
	 * @return
	 */
	public static String uploadToOSS(SgsOSSClient ossClient, MultipartFile files, String fileName, String fileOssPath) {
		boolean flag = false;
		try {
			flag = putStream(ossClient, files, fileOssPath + "/" + fileName);
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message: " + oe.getErrorMessage());
			System.out.println("Error Code: " + oe.getErrorCode());
			System.out.println("Request ID: " + oe.getRequestId());
			System.out.println("Host ID: " + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Code: " + ce.getErrorCode());
			System.out.println("Error Message: " + ce.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			return fileName;
		} else
			return "error";
	}
	
	
	/**
	 * 从OSS下载文件接口
	 * 
	 * @param fileName
	 * @return
	 */
	public static ResponseEntity<byte[]> downFormOSS(SgsOSSClient ossClient, String fileName,
			HttpServletRequest request) {
		if (fileName == null || StringUtils.isBlank(fileName)) {
			return null;
		}
		try {
			HttpHeaders headers = new HttpHeaders();
			// 从OSS获取文件流
			byte[] by = getStream(ossClient, fileName);
			// 处理请求头
			int index = fileName.indexOf("-");
			fileName = fileName.substring(index + 1);
			if (request.getHeader("User-Agent").contains("MSIE")
					|| request.getHeader("User-Agent").contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
			} else {
				// 非IE浏览器的处理
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(by, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/** 测试方法 */
	public static void main(String[] args) throws Exception {
		String serverUrl = "http://59.202.25.69/";//例如: http://59.202.25.69/
		String bucketName = "csoss";//bucket名
		String appName = "cs";//应用名
		SgsOSSClient soc = new SgsOSSClient(serverUrl,bucketName,appName);//初始化一个SgsOSSClient
	}
	
	/**
	 * 下载文件流
	 * 
	 * @param srcFilePath
	 *            --OSS文件存放路径
	 * @return
	 */
	public static byte[] getStream(SgsOSSClient ossClient, String srcFilePath) throws Exception {
		System.out.println(new Date() + "--OSS 下载开始");
		System.out.println(new Date() + "--OSS文件存放路径：" + srcFilePath);
		byte[] data = null;
		InputStream result = ossClient.getStream(srcFilePath); // 返回一个文件流
		data = readInputStream(result);
		return data;
	}

	public static byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[2048];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		byte[] byteArray = outStream.toByteArray();
		outStream.close();
		return byteArray;
	}

	/**
	 * 删除文件
	 * 
	 * @param srcFilePath
	 *            --OSS上的文件路径
	 * @return
	 */
	public static void deleteObject(SgsOSSClient ossClient, String srcFilePath) {
		ossClient.deleteObject(srcFilePath);// 删除文件
	}

	/**
	 * 描述: 判断是否为WINDOWS系统
	 */
	private static final boolean isWindows() {
		return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
	}

}
