package com.hypay.pay.config;

import com.hypay.pay.exception.HyPayException;
import org.apache.commons.lang3.StringUtils;

/**
 * 商户配置
 *
 * @author hypay
 */
public class HyPayConfig {
	/**
	 * 商户ID
	 */
	private long mchId;
	/**
	 * 商户应用ID
	 */
	private String appId;
	/**
	 * 商户key
	 */
	private String key;

	public HyPayConfig(long mchId, String appId, String key) throws HyPayException {
		this.mchId = mchId;
		if (StringUtils.isEmpty(appId)) {
			throw new HyPayException("应用ID不能为空");
		} else {
			this.appId = appId;
		}
		if (StringUtils.isEmpty(key)) {
			throw new HyPayException("key不能为空");
		} else {
			this.key = key;
		}
	}

	public long getMchId() {
		return mchId;
	}

	public String getAppId() {
		return appId;
	}

	public String getKey() {
		return key;
	}
}
