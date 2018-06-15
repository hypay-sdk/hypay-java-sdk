package com.hypay.pay.domain.response;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 接口response基类
 *
 * @author hypay
 */
public abstract class BaseResponse implements Serializable {
	private static final long serialVersionUID = 5904324787577970997L;
	/**
	 * 返回代码
	 */
	private String retCode;
	/**
	 * 返回信息
	 */
	private String retMsg;
	/**
	 * sign
	 */
	private String sign;

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
