package com.hypay.pay.domain.response;

/**
 * 创建订单返回结果
 *
 * @author hypay
 */
public class CreatePayOrderResponse extends BaseResponse {
	private static final long serialVersionUID = 164373483736319195L;

	/**
	 * 支付订单号
	 */
	private String payOrderId;
	/**
	 * 支付参数
	 */
	private String payParams;

	public String getPayOrderId() {
		return payOrderId;
	}

	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	public String getPayParams() {
		return payParams;
	}

	public void setPayParams(String payParams) {
		this.payParams = payParams;
	}
}
