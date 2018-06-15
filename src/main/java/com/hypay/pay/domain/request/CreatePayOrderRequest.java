package com.hypay.pay.domain.request;

import com.alibaba.fastjson.JSONObject;

/**
 * 创建支付订单请求
 *
 * @author hypay
 */
public class CreatePayOrderRequest extends BaseRequest {
	private static final long serialVersionUID = 683291234129207392L;

	/**
	 * 商户订单号
	 */
	private String mchOrderNo;
	/**
	 * 商户支付渠道
	 */
	private String channelId;
	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 支付金额，单元：分
	 */
	private Long amount;
	/**
	 * 客户端ip
	 */
	private String clientIp;
	/**
	 * 客户端设备
	 */
	private String device;
	/**
	 * 商品主题
	 */
	private String subject;
	/**
	 * 商品描述
	 */
	private String body;
	/**
	 * 扩展参数1
	 */
	private String param1;
	/**
	 * 扩展参数2
	 */
	private String param2;
	/**
	 * 附加参数
	 */
	private JSONObject extra;

	public String getMchOrderNo() {
		return mchOrderNo;
	}

	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public JSONObject getExtra() {
		return extra;
	}

	public void setExtra(JSONObject extra) {
		this.extra = extra;
	}
}
