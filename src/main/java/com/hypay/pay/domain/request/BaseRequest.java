package com.hypay.pay.domain.request;

import java.io.Serializable;

/**
 * @author hypay
 */
public abstract class BaseRequest implements Serializable {
	private static final long serialVersionUID = 7552100315107389522L;

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

	public long getMchId() {
		return mchId;
	}

	public void setMchId(long mchId) {
		this.mchId = mchId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
