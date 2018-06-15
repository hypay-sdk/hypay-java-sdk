package com.hypay.pay.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 退款订单
 *
 * @author hypay
 */
public class RefundOrder implements Serializable {
	private static final long serialVersionUID = 3108392783916240383L;

	/**
	 * 商户ID	mchId	是	long	20001222	分配的商户号
	 * 应用ID	appId	是	String(32)	0ae8be35ff634e2abe94f5f32f6d5c4f	该商户创建的应用对应的ID
	 * 支付订单号	payOrderId	是	String(32)	20160427210604000490	支付中心生成的订单号
	 * 商户支付单号	mchOrderNo	是	String(30)	20170427210604660428	商户生成的支付订单号，和payOrderId至少填一个
	 * 商户退款单号	mchRefundNo	是	String(30)	20180427213414000425	商户生成的退款订单号
	 * 币种	currency	是	String(3)	cny	三位货币代码,人民币:cny
	 * 退款金额	amount	是	int	100	退款金额,单位分。目前只支持全额退款，要和支付时金额一致。
	 * 客户端IP	clientIp	否	String(32)	210.73.10.148	客户端IP地址
	 * 设备	device	否	String(64)	ios10.3.1	客户端设备
	 * 退款结果回调URL	notifyUrl	否	String(200)	http://shop.xxpay.org/notify.htm	退款结果回调URL，如果填了该值，则发起异步退款，退款成功后，通过该地址通知退款结果
	 * 扩展参数1	param1	否	String(64)		支付中心回调时会原样返回
	 * 扩展参数2	param2	否	String(64)		支付中心回调时会原样返回
	 * 附加参数	extra	是	String(512)	{“openId”:”o2RvowBf7sOVJf8kJksUEMceaDqo”}	特定渠道发起时额外参数,见下面说明
	 * 签名	sign	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名值，详见签名算法
	 */

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
	 * 退款订单号
	 */
	@JSONField(name = "refundOrderId")
	private String refundOrderId;

	/**
	 * 商户退款单号
	 */
	@JSONField(name = "mchRefundNo")
	private String mchRefundNo;

	/**
	 * 退款金额
	 */
	@JSONField(name = "refundAmount")
	private Long refundAmount;

	/**
	 * 渠道订单号
	 */
	@JSONField(name = "channelOrderNo")
	private String channelOrderNo;

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
	 * 退款成功时间
	 */
	@JSONField(name = "refundSuccTime")
	private Date refundSuccTime;

	/**
	 * 退款状态,0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成
	 */
	@JSONField(name = "status")
	private Byte status;

	public String getRefundOrderId() {
		return refundOrderId;
	}

	public void setRefundOrderId(String refundOrderId) {
		this.refundOrderId = refundOrderId;
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

	public String getMchRefundNo() {
		return mchRefundNo;
	}

	public void setMchRefundNo(String mchRefundNo) {
		this.mchRefundNo = mchRefundNo;
	}

	public Long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getChannelOrderNo() {
		return channelOrderNo;
	}

	public void setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo = channelOrderNo;
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

	public Date getRefundSuccTime() {
		return refundSuccTime;
	}

	public void setRefundSuccTime(Date refundSuccTime) {
		this.refundSuccTime = refundSuccTime;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
