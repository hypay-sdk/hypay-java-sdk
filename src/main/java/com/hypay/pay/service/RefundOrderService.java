package com.hypay.pay.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.constant.RetEnum;
import com.hypay.pay.domain.entity.RefundOrder;
import com.hypay.pay.domain.request.CreateRefundOrderRequest;
import com.hypay.pay.domain.response.CreateRefundOrderResponse;
import com.hypay.pay.domain.response.QueryRefundOrderResponse;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.util.DateTimeConverter;
import com.hypay.pay.util.HttpUtil;
import com.hypay.pay.util.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hypay
 */
public class RefundOrderService extends BaseService {

	/**
	 * @param hyPayConfig
	 * @param refundOrderId
	 * @param mchRefundNo
	 * @param executeNotify
	 * @return
	 * @throws HyPayException
	 */
	public static QueryRefundOrderResponse queryOrder(HyPayConfig hyPayConfig,
	                                                  String refundOrderId,
	                                                  String mchRefundNo,
	                                                  Boolean executeNotify) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}
		if (StringUtils.isEmpty(refundOrderId)
				&& StringUtils.isEmpty(mchRefundNo)) {
			throw new HyPayException("退款订单号和商户退款单号至少填写一个");
		}

		// 2.组织参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());
		if (StringUtils.isNotEmpty(refundOrderId)) {
			params.put("refundOrderId", refundOrderId);
		}
		if (StringUtils.isNotEmpty(mchRefundNo)) {
			params.put("mchRefundNo", mchRefundNo);
		}
		if (null != executeNotify) {
			params.put("executeNotify", executeNotify);
		}
		String sign = SignUtil.generateSign(params, hyPayConfig.getKey());
		params.put("sign", sign);

		String url = null;
		try {
			url = QUERY_REFUND_ORDER_URL +
					"?params=" + URLEncoder.encode(JSON.toJSONString(params), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new HyPayException("URL转码错误", e);
		}

		// 3.发起请求
		HttpGet httpGet = new HttpGet(url);
		String returnStr = null;
		try {
			returnStr = HttpUtil.get(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
			throw new HyPayException("http请求错误", e);
		}

		// 4.处理返回值
		QueryRefundOrderResponse response = new QueryRefundOrderResponse();
		if (StringUtils.isEmpty(returnStr)) {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_OPERATION_FAIL.getMessage());
			return response;
		}
		JSONObject jsonObject = JSON.parseObject(returnStr);
		if (SignUtil.checkSign(jsonObject, hyPayConfig.getKey())) {
			if (StringUtils.isNotEmpty(jsonObject.getString("retCode"))
					&& "SUCCESS".equalsIgnoreCase(jsonObject.getString("retCode"))) {
				RefundOrder order = JSON.parseObject(jsonObject.toJSONString(), RefundOrder.class);

				response.setRetCode("SUCCESS");
				response.setRetMsg("");
				response.setRefundOrder(order);
			} else {
				RetEnum retEnum = RetEnum.getRetEnum(jsonObject.getInteger("retCode"));
				response.setRetCode("FAIL");
				response.setRetMsg(retEnum.getMessage());
			}
		} else {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_SIGN_FAIL.getMessage());
		}

		return response;
	}

	/**
	 * 创建退款订单
	 *
	 * @param hyPayConfig 商户配置
	 * @param request     创建退款订单请求
	 * @return
	 * @throws HyPayException
	 */
	public static CreateRefundOrderResponse createOrder(HyPayConfig hyPayConfig,
	                                                    CreateRefundOrderRequest request) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}
		if (null == request) {
			throw new HyPayException("创建退款订单请求不能为空");
		}
		if (StringUtils.isEmpty(request.getMchOrderNo())) {
			throw new HyPayException("商户订单号不能为空");
		}
		if (StringUtils.isEmpty(request.getPayOrderId())) {
			throw new HyPayException("支付单号不能为空");
		}
		if (StringUtils.isEmpty(request.getMchRefundNo())) {
			throw new HyPayException("商户退款单号不能为空");
		}
		if (StringUtils.isEmpty(request.getCurrency())) {
			throw new HyPayException("币种不能为空");
		}
		if (null == request.getAmount()) {
			throw new HyPayException("金额不能为空");
		}

		// 2.组织参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());
		params.put("payOrderId", request.getPayOrderId());
		params.put("mchOrderNo", request.getMchOrderNo());
		params.put("mchRefundNo", request.getMchRefundNo());
		params.put("currency", request.getCurrency());
		params.put("amount", request.getAmount());
		params.put("clientIp", request.getClientIp());
		params.put("device", request.getDevice());
		params.put("notifyUrl", request.getNotifyUrl());
		params.put("param1", request.getParam1());
		params.put("param2", request.getParam2());
		if (null != request.getExtra()) {
			params.put("extra", request.getExtra().toJSONString());
		}
		String sign = SignUtil.generateSign(params, hyPayConfig.getKey());
		params.put("sign", sign);

		String url = null;
		try {
			url = CREATE_REFUND_ORDER_URL +
					"?params=" + URLEncoder.encode(JSON.toJSONString(params), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new HyPayException("URL转码错误", e);
		}

		// 3.发起请求
		HttpGet httpGet = new HttpGet(url);
		String returnStr = null;
		try {
			returnStr = HttpUtil.get(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
			throw new HyPayException("http请求错误", e);
		}

		// 4.处理返回值
		CreateRefundOrderResponse response = new CreateRefundOrderResponse();
		if (StringUtils.isEmpty(returnStr)) {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_OPERATION_FAIL.getMessage());
			return response;
		}
		JSONObject jsonObject = JSON.parseObject(returnStr);
		if (null != jsonObject.getString("retCode")
				&& "SUCCESS".equalsIgnoreCase(jsonObject.getString("retCode"))) {
			// 验证sign
			if (SignUtil.checkSign(jsonObject, hyPayConfig.getKey())) {
				response.setRetCode("SUCCESS");
				response.setRetMsg("");
				response.setRefundOrderId(jsonObject.getString("refundOrderId"));
				response.setChannelId(jsonObject.getString("channelId"));
				response.setRefundAmount(jsonObject.getLong("refundAmount"));

				if (StringUtils.isNotEmpty(request.getNotifyUrl())) {
					response.setMchRefundNo(jsonObject.getString(""));
					if (null != jsonObject.getLong("refundSuccTime")) {
						response.setRefundSuccTime((Date) DateTimeConverter.toDate(Date.class, jsonObject.getLong("refundSuccTime")));
					}
					response.setChannelOrderNo(jsonObject.getString("channelOrderNo"));
					response.setStatus(jsonObject.getInteger("status"));
				}
			} else {
				response.setRetCode("FAIL");
				response.setRetMsg(RetEnum.RET_COMM_SIGN_FAIL.getMessage());
			}
		} else {
			response.setRetCode("FAIL");
			response.setRetMsg(jsonObject.getString("retMsg"));
		}

		return response;
	}
}
