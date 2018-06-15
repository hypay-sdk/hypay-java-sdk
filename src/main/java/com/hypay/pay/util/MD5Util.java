package com.hypay.pay.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 *
 * @author hypay
 */
public class MD5Util {
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	/**
	 * 对字符串进行MD5加密
	 *
	 * @param text 明文
	 * @return 密文
	 */
	public static String encryptToMD5(String text) {
		MessageDigest msgDigest = null;

		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}

		try {
			msgDigest.update(text.getBytes("UTF-8"));// 注意改接口是按照utf-8编码形式加密
		} catch (UnsupportedEncodingException e) {
			throw new IllegalStateException("System doesn't support your EncodingException.");
		}

		byte[] bytes = msgDigest.digest();

		return new String(encodeHex(bytes));
	}

	private static char[] encodeHex(byte[] byteArray) {
		int l = byteArray.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & byteArray[i]) >>> 4];
			out[j++] = DIGITS[0x0F & byteArray[i]];
		}

		return out;
	}

}