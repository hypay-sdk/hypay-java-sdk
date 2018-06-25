package com.hypay.pay.test;

import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.domain.entity.Scene;
import com.hypay.pay.domain.request.CreatePayOrderRequest;
import com.hypay.pay.domain.request.CreateRefundOrderRequest;
import com.hypay.pay.domain.response.*;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.service.MchGoodsService;
import com.hypay.pay.service.PayChannelService;
import com.hypay.pay.service.PayOrderService;
import com.hypay.pay.service.RefundOrderService;

import java.io.IOException;

public class HyPaySDKDemo {

	public static void main(String[] args) throws HyPayException, IOException {
		// 商户ID
		long mchId = 8;
		// 商户应用ID
		String appId = "83686ece228a49779d9b3d680d4e7b6c";
		// 商户KEY
		String key = "6xFzbj9YOHpFZGDzti1XYUOp1NTS3ohZeRanexfLh8b814op";

		// 1.商户配置
		HyPayConfig hyPayConfig = new HyPayConfig(mchId, appId, key);

		// 2.获取商户一键支付商品列表
		MchGoodsResponse goodsResponse = MchGoodsService.getGoods(hyPayConfig);
		System.out.println(goodsResponse.toJSONString());

		// 3.获取商户的支付渠道列表
		PayChannelResponse channelResponse = PayChannelService.getPayChannel(hyPayConfig, Scene.WAP);
		System.out.println(channelResponse.toJSONString());

		// 4.查询支付订单
		// 支付订单号
		String payOrderId = "P01201804270352236450006";
		// 商户订单号
		String mchOrderNo = "MO8G33T1524815543419R81562";
		QueryPayOrderResponse queryPayOrderResponse = PayOrderService.queryOrder(hyPayConfig,
				payOrderId,
				mchOrderNo,
				null);
		System.out.println(queryPayOrderResponse.toJSONString());

		// 5.创建支付订单
		CreatePayOrderRequest payOrderRequest = new CreatePayOrderRequest();
		payOrderRequest.setMchOrderNo("MO8G33T1524815658381R124534");
		payOrderRequest.setChannelId("alipay_wap");
		payOrderRequest.setCurrency("cny");
		payOrderRequest.setAmount(1L);
		payOrderRequest.setClientIp("127.0.0.1");
		payOrderRequest.setDevice("android");
		payOrderRequest.setSubject("苹果");
		payOrderRequest.setBody("红富士苹果");
		payOrderRequest.setParam1("");
		payOrderRequest.setParam2("");
		payOrderRequest.setExtra(new JSONObject() {{
			put("ali_show_url", "http://www.1080.com");
		}});
		CreatePayOrderResponse createOrderResponse = PayOrderService.createOrder(hyPayConfig, payOrderRequest);
		System.out.println(createOrderResponse.toJSONString());

		// 6.查询退款订单
		// 退款单号
		String refundOrderId = "P01201804270352236450006";
		// 商户退款单号
		String mchRefundNo = "MO8G33T1524815543419R81562";
		QueryRefundOrderResponse queryRefundOrderResponse = RefundOrderService.queryOrder(hyPayConfig,
				refundOrderId,
				mchRefundNo,
				null);
		System.out.println(queryRefundOrderResponse.toJSONString());

		// 7.申请退款
		CreateRefundOrderRequest refundOrderRequest = new CreateRefundOrderRequest();
		refundOrderRequest.setPayOrderId("P01201804270352236450006");
		refundOrderRequest.setMchOrderNo("MO8G33T1524815543419R81562");
		refundOrderRequest.setMchRefundNo("MO8G33T1524815543419R81562");
		refundOrderRequest.setCurrency("cny");
		refundOrderRequest.setAmount(1L);
		refundOrderRequest.setClientIp("127.0.0.1");
		refundOrderRequest.setDevice("android");
		refundOrderRequest.setNotifyUrl("http://www.1080.com");
		refundOrderRequest.setParam1("");
		refundOrderRequest.setParam2("");
		refundOrderRequest.setExtra(null);
		CreateRefundOrderResponse refundOrderResponse = RefundOrderService.createOrder(hyPayConfig, refundOrderRequest);
		System.out.println(refundOrderResponse.toJSONString());
	}
}
