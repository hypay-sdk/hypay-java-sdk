package com.hypay.pay.service;

/**
 * @author hypay
 */
public abstract class BaseService {

	/**
	 * 商户支付渠道URL
	 */
	public final static String CHANNEL_URL = "http://pay.1080.com/api/mch/pay_channel";
	/**
	 * 商户一键支付商品URL
	 */
	public final static String GOODS_URL = "http://pay.1080.com/api/mch/goods";
	/**
	 * 商户查询支付订单URL
	 */
	public final static String QUERY_PAY_ORDER_URL = "http://pay.1080.com/api/pay/query_order";
	/**
	 * 商户创建支付订单URL
	 */
	public final static String CREATE_PAY_ORDER_URL = "http://pay.1080.com/api/pay/create_order";
	/**
	 * 商户创建申请退款订单URL
	 */
	public final static String CREATE_REFUND_ORDER_URL = "http://pay.1080.com/api/refund/create_order";
	/**
	 * 商户查询退款订单URL
	 */
	public final static String QUERY_REFUND_ORDER_URL = "http://pay.1080.com/api/refund/query_order";
}
