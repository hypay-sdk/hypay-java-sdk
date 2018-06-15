package com.hypay.pay.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户一键支付商品
 *
 * @author hypay
 */
public class MchGoods implements Serializable {
	private static final long serialVersionUID = -1857658342244493012L;

	/**
	 * 商品ID
	 */
	@JSONField(name = "goodsId")
	private Long goodsId;

	/**
	 * 商品名称
	 */
	@JSONField(name = "goodsName")
	private String goodsName;

	/**
	 * 状态,在用(1),注销(0)
	 */
	@JSONField(name = "status")
	private Byte status;

	/**
	 * 状态变更时间
	 */
	@JSONField(name = "statusTime")
	private Date statusTime;

	/**
	 * 商户ID
	 */
	@JSONField(name = "mchId")
	private Long mchId;

	/**
	 * 类型:1-平台账户,2-私有账户
	 */
	@JSONField(name = "mchType")
	private Byte mchType;

	/**
	 * 应用ID
	 */
	@JSONField(name = "appId")
	private String appId;

	/**
	 * 商品分类
	 */
	@JSONField(name = "cateId")
	private Integer cateId;

	/**
	 * 商品分类名称
	 */
	@JSONField(name = "cateName")
	private String cateName;

	/**
	 * 商品原价,单位分
	 */
	@JSONField(name = "oriPrice")
	private Long oriPrice;

	/**
	 * 商品售价,单位分(最终价格,显示以此为准)
	 */
	@JSONField(name = "salePrice")
	private Long salePrice;

	/**
	 * 优惠比率
	 */
	@JSONField(name = "disRate")
	private BigDecimal disRate;

	/**
	 * 优惠金额,单位分
	 */
	@JSONField(name = "disAmount")
	private Long disAmount;

	/**
	 * 图片地址
	 */
	@JSONField(name = "imageUrl")
	private String imageUrl;

	/**
	 * 序列号
	 */
	@JSONField(name = "sequence")
	private Byte sequence;

	/**
	 * 备注
	 */
	@JSONField(name = "remark")
	private String remark;

	/**
	 * 创建时间
	 */
	@JSONField(name = "createTime")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@JSONField(name = "updateTime")
	private Date updateTime;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Date statusTime) {
		this.statusTime = statusTime;
	}

	public Long getMchId() {
		return mchId;
	}

	public void setMchId(Long mchId) {
		this.mchId = mchId;
	}

	public Byte getMchType() {
		return mchType;
	}

	public void setMchType(Byte mchType) {
		this.mchType = mchType;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Long getOriPrice() {
		return oriPrice;
	}

	public void setOriPrice(Long oriPrice) {
		this.oriPrice = oriPrice;
	}

	public Long getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Long salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getDisRate() {
		return disRate;
	}

	public void setDisRate(BigDecimal disRate) {
		this.disRate = disRate;
	}

	public Long getDisAmount() {
		return disAmount;
	}

	public void setDisAmount(Long disAmount) {
		this.disAmount = disAmount;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Byte getSequence() {
		return sequence;
	}

	public void setSequence(Byte sequence) {
		this.sequence = sequence;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}