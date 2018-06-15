package com.hypay.pay.domain.response;

import java.util.Date;

/**
 * 申请退款返回结果
 *
 * @author hypay
 */
public class CreateRefundOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 5616104201796602627L;

	/**
	 * 退款订单号
	 */
	private String refundOrderId;

	/**
	 * 渠道ID
	 */
	private String channelId;

	/**
	 * 退款金额
	 */
	private Long refundAmount;

	/**
	 * 商户退款单号
	 */
	private String mchRefundNo;

	/**
	 * 退款成功时间
	 */
	private Date refundSuccTime;

	/**
	 * 渠道订单号
	 */
	private String channelOrderNo;

	/**
	 * 状态
	 * 0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成
	 */
	private Integer status;

	public String getRefundOrderId() {
		return refundOrderId;
	}

	public void setRefundOrderId(String refundOrderId) {
		this.refundOrderId = refundOrderId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public Long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getMchRefundNo() {
		return mchRefundNo;
	}

	public void setMchRefundNo(String mchRefundNo) {
		this.mchRefundNo = mchRefundNo;
	}

	public Date getRefundSuccTime() {
		return refundSuccTime;
	}

	public void setRefundSuccTime(Date refundSuccTime) {
		this.refundSuccTime = refundSuccTime;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
