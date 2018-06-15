package com.hypay.pay.domain.response;

import com.hypay.pay.domain.entity.PayOrder;

/**
 * 查询支付订单返回结果
 *
 * @author hypay
 */
public class QueryPayOrderResponse extends BaseResponse {
	private static final long serialVersionUID = -4033590124064950348L;

	/**
	 * 支付订单
	 */
	private PayOrder payOrder;

	public PayOrder getPayOrder() {
		return payOrder;
	}

	public void setPayOrder(PayOrder payOrder) {
		this.payOrder = payOrder;
	}
}
