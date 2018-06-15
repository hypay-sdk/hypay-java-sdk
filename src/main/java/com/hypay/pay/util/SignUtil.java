package com.hypay.pay.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * sign生成和验证工具类
 *
 * @author hypay
 */
public class SignUtil {

	/**
	 * 生成sign
	 *
	 * @param params 参数map
	 * @param key    商户key
	 * @return
	 */
	public static String generateSign(Map<String, Object> params, String key) {
		Map<String, Object> sortMap = new TreeMap<String, Object>(params);
		// 以k1=v1&k2=v2...方式拼接参数
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Object> s : sortMap.entrySet()) {
			String k = s.getKey();
			Object v = s.getValue();

			// 过滤空值
			if (null == v) {
				continue;
			}
			if (v instanceof String
					&& StringUtils.isBlank(String.valueOf(v))) {
				continue;
			}
			builder.append(k).append("=").append(v).append("&");
		}
		builder.append("key=").append(key);

		return MD5Util.encryptToMD5(builder.toString()).toUpperCase();
	}

	/**
	 * 验证sign
	 *
	 * @param params 参数map
	 * @param key    商户key
	 * @return
	 */
	public static boolean checkSign(Map<String, Object> params, String key) {
		String sign = String.valueOf(params.get("sign"));
		if (StringUtils.isEmpty(sign)) {
			return false;
		}
		params.remove("sign");
		String checkSign = generateSign(params, key);
		return checkSign.equalsIgnoreCase(sign);
	}
}
