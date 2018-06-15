package com.hypay.pay.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户支付订单
 *
 * @author hypay
 */
public class PayOrder implements Serializable {
	private static final long serialVersionUID = 4676596160970711867L;

	/**
	 * 支付订单号
	 */
	@JSONField(name = "payOrderId")
	private String payOrderId;

	/**
	 * 商户ID
	 */
	@JSONField(name = "mchId")
	private Long mchId;

	/**
	 * 应用ID
	 */
	@JSONField(name = "appId")
	private String appId;

	/**
	 * 商户订单号
	 */
	@JSONField(name = "mchOrderNo")
	private String mchOrderNo;

	/**
	 * 渠道类型,WX:微信,ALIPAY:支付宝
	 */
	@JSONField(name = "channelType")
	private String channelType;

	/**
	 * 渠道ID
	 */
	@JSONField(name = "channelId")
	private String channelId;

	/**
	 * 通道ID
	 */
	@JSONField(name = "passageId")
	private Integer passageId;

	/**
	 * 支付金额,单位分
	 */
	@JSONField(name = "amount")
	private Long amount;

	/**
	 * 三位货币代码,人民币:cny
	 */
	@JSONField(name = "currency")
	private String currency;

	/**
	 * 支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
	 */
	@JSONField(name = "status")
	private Byte status;

	/**
	 * 渠道订单号
	 */
	@JSONField(name = "channelOrderNo")
	private String channelOrderNo;

	/**
	 * 渠道数据包
	 */
	@JSONField(name = "channelAttach")
	private String channelAttach;

	/**
	 * 扩展参数1
	 */
	@JSONField(name = "param1")
	private String param1;

	/**
	 * 扩展参数2
	 */
	@JSONField(name = "param2")
	private String param2;

	/**
	 * 订单支付成功时间
	 */
	@JSONField(name = "paySuccTime")
	private Date paySuccTime;

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public Long getMchId() {
		return mchId;
	}

	public void setMchId(Long mchId) {
		this.mchId = mchId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMchOrderNo() {
		return mchOrderNo;
	}

	public void setMchOrderNo(String mchOrderNo) {
		this.mchOrderNo = mchOrderNo;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Integer getPassageId() {
		return passageId;
	}

	public void setPassageId(Integer passageId) {
		this.passageId = passageId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public String getChannelAttach() {
		return channelAttach;
	}

	public void setChannelAttach(String channelAttach) {
		this.channelAttach = channelAttach;
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

	public Date getPaySuccTime() {
		return paySuccTime;
	}

	public void setPaySuccTime(Date paySuccTime) {
		this.paySuccTime = paySuccTime;
	}
}