package com.hypay.pay.test;

import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.domain.entity.Scene;
import com.hypay.pay.domain.request.CreatePayOrderRequest;
import com.hypay.pay.domain.response.*;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.service.MchGoodsService;
import com.hypay.pay.service.PayChannelService;
import com.hypay.pay.service.PayOrderService;
import com.hypay.pay.service.RefundOrderService;

import java.io.IOException;

public class SDKTest {

	public static void main(String[] args) throws HyPayException, IOException {
		HyPayConfig hyPayConfig = new HyPayConfig(8,
				"83686ece228a49779d9b3d680d4e7b6c",
				"6xFzbj9YOHpFZGDzti1XYUOp1NTS3ohZeRanexfLh8b814op");

		MchGoodsResponse goodsResponse = MchGoodsService.getGoods(hyPayConfig);
		System.out.println(goodsResponse.toJSONString());

		PayChannelResponse channelResponse = PayChannelService.getPayChannel(hyPayConfig, Scene.WAP);
		System.out.println(channelResponse.toJSONString());

		QueryPayOrderResponse queryPayOrderResponse = PayOrderService.queryOrder(hyPayConfig,
				"P01201804270352236450006",
				"MO8G33T1524815543419R81562",
				null);
		System.out.println(queryPayOrderResponse.toJSONString());

		CreatePayOrderRequest request = new CreatePayOrderRequest();
		request.setMchOrderNo("MO8G33T1524815658381R124534");
		request.setChannelId("alipay_mobile");
		request.setCurrency("cny");
		request.setAmount(1L);
		request.setClientIp(null);
		request.setDevice(null);
		request.setSubject("sdk测试");
		request.setBody("sdk测试");
		request.setParam1("MO8G33T1524815658381R124534");
		request.setParam2("MO8G33T1524815658381R124534");
		request.setExtra(new JSONObject() {{
			put("openId", "123123123");
		}});
		CreatePayOrderResponse createOrderResponse = PayOrderService.createOrder(hyPayConfig, request);
		System.out.println(createOrderResponse.toJSONString());

		QueryRefundOrderResponse queryRefundOrderResponse = RefundOrderService.queryOrder(hyPayConfig,
				"P01201804270352236450006",
				"MO8G33T1524815543419R81562",
				null);
		System.out.println(queryRefundOrderResponse.toJSONString());
	}
}
