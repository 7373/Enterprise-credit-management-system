package com.icinfo.ndrc.util;

/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 加密解密帮助类
 * @author 徐建军
 * @date 2014-3-4
 * @version 1.0
 */
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.icinfo.ndrc.support.Constants;

/**
 * 描述: 加密解密帮助类
 * 
 * @author 徐建军
 * @date 2014-3-4
 */
public class AESEUtil {

	/**
	 * 描述: 加密
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] encrypt(String content, String password) {

		try {

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());

			kgen.init(128, secureRandom);

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			byte[] byteContent = content.getBytes("utf-8");

			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(byteContent);

			return result; // 加密

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 描述: 解密
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param content
	 * @param password
	 * @return
	 */
	public static byte[] decrypt(byte[] content, String password) {

		try {

			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(password.getBytes());

			kgen.init(128, secureRandom);

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");// 创建密码器

			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化

			byte[] result = cipher.doFinal(content);

			return result; // 解密

		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;

	}

	/**
	 * 描述: 将二进制转换成16进制
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte[] buf) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 描述: 将16进制转换为二进制
	 * 
	 * @author 徐建军
	 * @date 2014-3-4
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
					16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}
	
	/** 
	 * 描述: 字符串解密
	 * 
	 * @author zhuyong
	 * @date 2014-10-23 
	 * @return string
	 * @throws UnsupportedEncodingException 
	 */
	public static String decryptContext(String param) throws UnsupportedEncodingException {
		if(param.length()<30){
			return param;
		}
		return new String(AESEUtil.decrypt(AESEUtil.parseHexStr2Byte(param), Constants.SECRET_KEY),"utf-8");
	}
	
	
	/** 
	 * 描述: 字符串加密
	 * 
	 * @author 朱勇
	 * @date 2015-10-23
	 * @return string
	 * @throws UnsupportedEncodingException 
	 */
	public static String encryptContext(String param) {
		return new String(AESEUtil.parseByte2HexStr(AESEUtil.encrypt(param,Constants.SECRET_KEY)));
	}
	
}
