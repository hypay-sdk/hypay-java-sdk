package com.hypay.pay.service;

import com.hypay.pay.config.HyPayConfig;
import com.hypay.pay.constant.RetEnum;
import com.hypay.pay.domain.response.NotifyResponse;
import com.hypay.pay.exception.HyPayException;
import com.hypay.pay.util.BeanConvertUtil;
import com.hypay.pay.util.SignUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理异步通知数据接口
 *
 * @author hypay
 */
public class MchNotifyService extends BaseService {

	/**
	 * 获取异步通知消息
	 *
	 * @param hyPayConfig 商户配置
	 * @param request     请求对象
	 * @return
	 * @throws HyPayException
	 */
	public static NotifyResponse parseNotifyRequest(HyPayConfig hyPayConfig,
	                                                HttpServletRequest request) throws HyPayException {
		// 1.验证参数
		if (null == request) {
			throw new HyPayException("请求不能为空");
		}
		if (null == hyPayConfig) {
			throw new HyPayException("商户配置不能为空");
		}

		NotifyResponse response = new NotifyResponse();

		String payOrderId = request.getParameter("payOrderId");
		Long mchId = Long.valueOf(request.getParameter("mchId"));
		String appId = request.getParameter("appId");
		String passageId = request.getParameter("passageId");
		String mchOrderNo = request.getParameter("mchOrderNo");
		String channelId = request.getParameter("channelId");
		String currency = request.getParameter("currency");
		Long amount = Long.valueOf(request.getParameter("amount"));
		String channelOrderNo = request.getParameter("channelOrderNo");
		String channelAttach = request.getParameter("channelAttach");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		Long paySuccTime = Long.valueOf(request.getParameter("paySuccTime"));
		Integer backType = Integer.valueOf(request.getParameter("backType"));
		String sign = request.getParameter("sign");
		Integer status = Integer.valueOf(request.getParameter("status"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("payOrderId", payOrderId);
		map.put("mchId", mchId);
		map.put("amount", amount);
		map.put("mchOrderNo", mchOrderNo);
		map.put("paySuccTime", paySuccTime);
		map.put("sign", sign);
		map.put("channelOrderNo", channelOrderNo);
		map.put("backType", backType);
		map.put("param1", param1);
		map.put("param2", param2);
		map.put("appId", appId);
		map.put("channelAttach", channelAttach);
		map.put("passageId", passageId);
		map.put("channelId", channelId);
		map.put("currency", currency);
		map.put("status", status);

		if (SignUtil.checkSign(map, hyPayConfig.getKey())) {
			response = BeanConvertUtil.map2Bean(map, NotifyResponse.class);
			response.setRetCode("SUCCESS");
			response.setRetMsg("");
		} else {
			response.setRetCode("FAIL");
			response.setRetMsg(RetEnum.RET_COMM_SIGN_FAIL.getMessage());
		}

		return response;
	}
}
