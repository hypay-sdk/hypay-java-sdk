package com.hypay.pay.domain.response;

import com.hypay.pay.domain.entity.PayChannel;

import java.util.List;

/**
 * 商品支付渠道返回结果
 *
 * @author hypay
 */
public class PayChannelResponse extends BaseResponse {
	private static final long serialVersionUID = 3826015671138349475L;

	/**
	 * 支付渠道列表
	 */
	private List<PayChannel> payChannelList;

	public List<PayChannel> getPayChannelList() {
		return payChannelList;
	}

	public void setPayChannelList(List<PayChannel> payChannelList) {
		this.payChannelList = payChannelList;
	}
}
