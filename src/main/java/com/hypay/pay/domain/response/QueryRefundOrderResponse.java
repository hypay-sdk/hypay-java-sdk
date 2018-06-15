package com.hypay.pay.domain.response;

import com.hypay.pay.domain.entity.RefundOrder;

/**
 * 查询退款订单返回结果
 *
 * @author hypay
 */
public class QueryRefundOrderResponse extends BaseResponse {
	private static final long serialVersionUID = -1523316659542739285L;

	/**
	 * 退款订单
	 */
	private RefundOrder refundOrder;

	public RefundOrder getRefundOrder() {
		return refundOrder;
	}

	public void setRefundOrder(RefundOrder refundOrder) {
		this.refundOrder = refundOrder;
	}
}
