package com.hypay.pay.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 商户支付渠道
 *
 * @author hypay
 */
public class PayChannel implements Serializable {
	private static final long serialVersionUID = 5839706728153373174L;
	/**
	 * 商户渠道ID
	 */
	@JSONField(name = "id")
	private Integer id;

	/**
	 * 商户ID
	 */
	@JSONField(name = "mchId")
	private Long mchId;

	/**
	 * 名称
	 */
	@JSONField(name = "name")
	private String name;

	/**
	 * 应用ID
	 */
	@JSONField(name = "appId")
	private String appId;

	/**
	 * 渠道ID
	 */
	@JSONField(name = "channelId")
	private String channelId;

	/**
	 * 渠道类型,alipay:支付宝,wx:微信支付,qqpay:qq支付,unionpay:银联支付,applepay:苹果支付,bdpay:百付宝,jdpay:京东支付
	 */
	@JSONField(name = "channelType")
	private String channelType;

	/**
	 * 应用场景,1:移动APP,2:移动网页,3:PC网页,4:微信公众平台,5:手机扫码
	 */
	@JSONField(name = "scene")
	private Byte scene;

	/**
	 * 渠道商户ID
	 */
	@JSONField(name = "channelMchId")
	private String channelMchId;

	/**
	 * 渠道状态,0-停止使用,1-使用中
	 */
	@JSONField(name = "status")
	private Byte status;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMchId() {
		return mchId;
	}

	public void setMchId(Long mchId) {
		this.mchId = mchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public Byte getScene() {
		return scene;
	}

	public void setScene(Byte scene) {
		this.scene = scene;
	}

	public String getChannelMchId() {
		return channelMchId;
	}

	public void setChannelMchId(String channelMchId) {
		this.channelMchId = channelMchId;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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