package com.hypay.pay.domain.response;

import com.hypay.pay.domain.entity.MchGoods;

import java.util.List;

/**
 * 商户商品返回结果
 *
 * @author hypay
 */
public class MchGoodsResponse extends BaseResponse {
	private static final long serialVersionUID = 6959529754304217877L;

	/**
	 * 商品列表
	 */
	private List<MchGoods> mchGoodsList;

	public List<MchGoods> getMchGoodsList() {
		return mchGoodsList;
	}

	public void setMchGoodsList(List<MchGoods> mchGoodsList) {
		this.mchGoodsList = mchGoodsList;
	}
}
