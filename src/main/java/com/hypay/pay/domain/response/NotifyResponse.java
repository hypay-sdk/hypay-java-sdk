package com.hypay.pay.domain.response;

import java.util.Date;

/**
 * 异步通知返回结果
 *
 * @author hypay
 */
public class NotifyResponse extends BaseResponse {
	private static final long serialVersionUID = -4949600257563778132L;

	/**
	 * 支付订单号
	 */
	private String payOrderId;
	/**
	 * 商户ID
	 */
	private Long mchId;
	/**
	 * 应用ID
	 */
	private String appId;
	/**
	 * 通道ID
	 */
	private String passageId;
	/**
	 * 商户订单号
	 */
	private String mchOrderNo;
	/**
	 * 渠道ID
	 */
	private String channelId;
	/**
	 * 币种
	 */
	private String currency;
	/**
	 * 支付金额 单位分
	 */
	private Long amount;
	/**
	 * 渠道订单号
	 */
	private String channelOrderNo;
	/**
	 * 渠道数据包
	 */
	private String channelAttach;
	/**
	 * 扩展参数1
	 */
	private String param1;
	/**
	 * 扩展参数2
	 */
	private String param2;
	/**
	 * 支付成功时间
	 */
	private Date paySuccTime;
	/**
	 * 通知类型
	 * 1-前台通知，2-后台通知
	 */
	private Integer backType;
	/**
	 * 状态
	 * 0-订单生成,1-支付中,2-支付成功,3-业务处理完成
	 */
	private Integer status;

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

	public String getPassageId() {
		return passageId;
	}

	public void setPassageId(String passageId) {
		this.passageId = passageId;
	}

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

	public Integer getBackType() {
		return backType;
	}

	public void setBackType(Integer backType) {
		this.backType = backType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
