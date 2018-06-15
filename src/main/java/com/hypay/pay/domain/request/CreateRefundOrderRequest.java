package com.hypay.pay.domain.request;

import com.alibaba.fastjson.JSONObject;

/**
 * 创建退款订单请求
 *
 * @author hypay
 */
public class CreateRefundOrderRequest extends BaseRequest {
	private static final long serialVersionUID = 7453664447775793510L;

	/**
	 * 支付订单号
	 */
	private String payOrderId;
	/**
	 * 商户订单号
	 */
	private String mchOrderNo;
	/**
	 * 商户退款单号
	 */
	private String mchRefundNo;
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
	 * 通知地址
	 */
	private String notifyUrl;
	/**
	 *扩展参数1
	 */
	private String param1;
	/**
	 *扩展参数2
	 */
	private String param2;
	/**
	 *附加参数
	 */
	private JSONObject extra;

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getMchOrderNo() {
		return mchOrderNo;
	}

	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public String getMchRefundNo() {
		return mchRefundNo;
	}

	public void setMchRefundNo(String mchRefundNo) {
		this.mchRefundNo = mchRefundNo;
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

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
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
