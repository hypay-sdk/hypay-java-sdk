package com.hypay.pay.domain.entity;

/**
 * 应用场景
 *
 * @author hypay
 */
public enum Scene {
	/**
	 * 1:移动APP
	 */
	APP("APP", (byte) 1),
	/**
	 * 2:移动网页
	 */
	WAP("WAP", (byte) 2),
	/**
	 * 3:PC网页
	 */
	PC("PC", (byte) 3),
	/**
	 * 4:微信公众平台
	 */
	WEIXIN("WEIXIN", (byte) 4),
	/**
	 * 5:手机扫码
	 */
	SCAN("SCAN", (byte) 5),
	/**
	 * 6:个人码
	 */
	QR("QR", (byte) 6);

	private final String code;
	private final byte scene;

	Scene(String code, byte scene) {
		this.scene = scene;
		this.code = code;
	}

	public String code() {
		return this.code;
	}

	public byte scene() {
		return this.scene;
	}
}
