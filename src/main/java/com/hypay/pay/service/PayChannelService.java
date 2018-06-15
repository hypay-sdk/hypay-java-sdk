package com.hypay.pay.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.constant.RetEnum;
import com.hypay.pay.domain.entity.PayChannel;
import com.hypay.pay.domain.entity.Scene;
import com.hypay.pay.domain.response.PayChannelResponse;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 商户支付渠道接口
 *
 * @author hypay
 */
public class PayChannelService extends BaseService {

	/**
	 * 获取商户
	 *
	 * @param hyPayConfig 商户配置
	 * @param scene       场景
	 * @return
	 * @throws HyPayException
	 */
	public static PayChannelResponse getPayChannel(HyPayConfig hyPayConfig,
	                                               Scene scene) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}
		if (null == scene) {
			throw new HyPayException("场景不能为空");
		}

		// 2.组织参数
		JSONObject params = new JSONObject();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());
		params.put("scene", scene.scene());

		String url = null;
		try {
			url = CHANNEL_URL
					+ "?params=" + URLEncoder.encode(params.toJSONString(), "UTF-8");
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
		PayChannelResponse response = new PayChannelResponse();
		if (StringUtils.isEmpty(returnStr)) {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_OPERATION_FAIL.getMessage());
			return response;
		}
		JSONObject jsonObject = JSON.parseObject(returnStr);
		List<PayChannel> channelList = new ArrayList<PayChannel>();
		if (null != jsonObject.getInteger("code")
				&& 0 == jsonObject.getInteger("code")) {
			JSONArray channelArray = jsonObject.getJSONArray("data");

			if (null != channelArray
					&& !channelArray.isEmpty()) {
				for (Object tempChannel : channelArray) {
					JSONObject channel = (JSONObject) tempChannel;
					channelList.add(JSON.parseObject(channel.toJSONString(), PayChannel.class));
				}
			}

			response.setRetCode("SUCCESS");
			response.setRetMsg("");
			response.setPayChannelList(channelList);
		} else {
			RetEnum retEnum = RetEnum.getRetEnum(jsonObject.getInteger("code"));
			response.setRetCode("FAIL");
			response.setRetMsg(retEnum.getMessage());
		}

		return response;
	}


}
