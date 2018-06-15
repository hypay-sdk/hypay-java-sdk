package com.hypay.pay.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.constant.RetEnum;
import com.hypay.pay.domain.entity.PayOrder;
import com.hypay.pay.domain.request.CreatePayOrderRequest;
import com.hypay.pay.domain.response.CreatePayOrderResponse;
import com.hypay.pay.domain.response.QueryPayOrderResponse;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.util.HttpUtil;
import com.hypay.pay.util.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付订单接口
 *
 * @author hypay
 */
public class PayOrderService extends BaseService {

	/**
	 * 查询订单
	 *
	 * @param hyPayConfig   商户配置
	 * @param payOrderId    支付订单号
	 * @param mchOrderNo    商户订单号
	 * @param executeNotify 是否执行回调
	 * @return
	 * @throws HyPayException
	 */
	public static QueryPayOrderResponse queryOrder(HyPayConfig hyPayConfig,
	                                               String payOrderId,
	                                               String mchOrderNo,
	                                               Boolean executeNotify) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}
		if (StringUtils.isEmpty(payOrderId)
				&& StringUtils.isEmpty(mchOrderNo)) {
			throw new HyPayException("支付订单号和商户订单号至少填写一个");
		}

		// 2.组织参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());
		if (StringUtils.isNotEmpty(payOrderId)) {
			params.put("payOrderId", payOrderId);
		}
		if (StringUtils.isNotEmpty(mchOrderNo)) {
			params.put("mchOrderNo", mchOrderNo);
		}
		if (null != executeNotify) {
			params.put("executeNotify", executeNotify);
		}
		String sign = SignUtil.generateSign(params, hyPayConfig.getKey());
		params.put("sign", sign);

		String url = null;
		try {
			url = QUERY_PAY_ORDER_URL +
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
		QueryPayOrderResponse response = new QueryPayOrderResponse();
		if (StringUtils.isEmpty(returnStr)) {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_OPERATION_FAIL.getMessage());
			return response;
		}
		JSONObject jsonObject = JSON.parseObject(returnStr);
		if (SignUtil.checkSign(jsonObject, hyPayConfig.getKey())) {
			if (StringUtils.isNotEmpty(jsonObject.getString("retCode"))
					&& "SUCCESS".equalsIgnoreCase(jsonObject.getString("retCode"))) {
				PayOrder order = JSON.parseObject(jsonObject.toJSONString(), PayOrder.class);

				response.setRetCode("SUCCESS");
				response.setRetMsg("");
				response.setPayOrder(order);
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
	 * 创建支付订单
	 *
	 * @param hyPayConfig 商户配置
	 * @param request     创建订单请求
	 * @return
	 * @throws HyPayException
	 */
	public static CreatePayOrderResponse createOrder(HyPayConfig hyPayConfig,
	                                                 CreatePayOrderRequest request) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}
		if (null == request) {
			throw new HyPayException("创建订单请求不能为空");
		}
		if (StringUtils.isEmpty(request.getMchOrderNo())) {
			throw new HyPayException("商户订单号不能为空");
		}
		if (StringUtils.isEmpty(request.getChannelId())) {
			throw new HyPayException("支付渠道不能为空");
		}
		if (StringUtils.isEmpty(request.getCurrency())) {
			throw new HyPayException("币种不能为空");
		}
		if (StringUtils.isEmpty(request.getSubject())) {
			throw new HyPayException("商品主题不能为空");
		}
		if (StringUtils.isEmpty(request.getBody())) {
			throw new HyPayException("商品描述不能为空");
		}
		if (null == request.getAmount()) {
			throw new HyPayException("金额不能为空");
		}
		if ("wxpay_jsapi".equalsIgnoreCase(request.getChannelId())
				|| "wxpay_native".equalsIgnoreCase(request.getChannelId())
				|| "alipay_wap".equalsIgnoreCase(request.getChannelId())
				|| "alipay_pc".equalsIgnoreCase(request.getChannelId())) {
			if (null == request.getExtra()) {
				throw new HyPayException("附加参数不能为空");
			}
		}

		// 2.组织参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());
		params.put("mchOrderNo", request.getMchOrderNo());
		params.put("channelId", request.getChannelId());
		params.put("currency", request.getCurrency());
		params.put("amount", request.getAmount());
		params.put("clientIp", request.getClientIp());
		params.put("device", request.getDevice());
		params.put("subject", request.getSubject());
		params.put("body", request.getBody());
		params.put("param1", request.getParam1());
		params.put("param2", request.getParam2());
		params.put("extra", request.getExtra().toJSONString());
		String sign = SignUtil.generateSign(params, hyPayConfig.getKey());
		params.put("sign", sign);

		String url = null;
		try {
			url = CREATE_PAY_ORDER_URL +
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
		CreatePayOrderResponse response = new CreatePayOrderResponse();
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
				response.setPayOrderId(jsonObject.getString("payOrderId"));
				response.setPayParams(jsonObject.getString("payParams"));
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
