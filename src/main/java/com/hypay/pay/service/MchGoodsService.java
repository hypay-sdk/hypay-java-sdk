package com.hypay.pay.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.constant.RetEnum;
import com.hypay.pay.domain.entity.MchGoods;
import com.hypay.pay.domain.response.MchGoodsResponse;
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
 * 商户一键支付商品接口
 *
 * @author hypay
 */
public class MchGoodsService extends BaseService {

	/**
	 * 获取商品列表
	 *
	 * @param hyPayConfig 商户配置
	 * @return
	 * @throws HyPayException
	 */
	public static MchGoodsResponse getGoods(HyPayConfig hyPayConfig) throws HyPayException {
		// 1.验证参数
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}

		// 2.组织参数
		JSONObject params = new JSONObject();
		params.put("mchId", hyPayConfig.getMchId());
		params.put("appId", hyPayConfig.getAppId());

		String url = null;
		try {
			url = GOODS_URL
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
		MchGoodsResponse response = new MchGoodsResponse();
		if (StringUtils.isEmpty(returnStr)) {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_OPERATION_FAIL.getMessage());
			return response;
		}

		JSONObject jsonObject = JSON.parseObject(returnStr);
		List<MchGoods> goodsList = new ArrayList<MchGoods>();
		if (null != jsonObject.getInteger("code")
				&& 0 == jsonObject.getInteger("code")) {
			JSONArray virtualGoodsArray = jsonObject.getJSONObject("data").getJSONArray("virtualList");
			JSONArray itemGoodsArray = jsonObject.getJSONObject("data").getJSONArray("itemList");

			if (null != virtualGoodsArray
					&& !virtualGoodsArray.isEmpty()) {
				for (Object tempGoods : virtualGoodsArray) {
					JSONObject goods = (JSONObject) tempGoods;
					goodsList.add(JSON.parseObject(goods.toJSONString(), MchGoods.class));
				}
			}
			if (null != itemGoodsArray
					&& !itemGoodsArray.isEmpty()) {
				for (Object tempGoods : itemGoodsArray) {
					JSONObject goods = (JSONObject) tempGoods;
					goodsList.add(JSON.parseObject(goods.toJSONString(), MchGoods.class));
				}
			}

			response.setRetCode("SUCCESS");
			response.setRetMsg("");
			response.setMchGoodsList(goodsList);
		} else {
			RetEnum retEnum = RetEnum.getRetEnum(jsonObject.getInteger("code"));
			response.setRetCode("FAIL");
			response.setRetMsg(retEnum.getMessage());
		}

		return response;
	}
}
