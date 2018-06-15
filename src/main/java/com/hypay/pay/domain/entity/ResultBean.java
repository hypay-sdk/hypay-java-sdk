package com.hypay.pay.domain.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * 接口返回对象
 *
 * @author hypay
 */
public class ResultBean<T> implements Serializable {

	private static final long serialVersionUID = -3199636923440672516L;
	/**
	 * 代码
	 */
	private int code;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * 数据
	 */
	private T data;

	public static <T> ResultBean<T> result(int code, String message, T data) {
		ResultBean<T> resultBean = new ResultBean<T>();
		resultBean.setCode(code);
		resultBean.setMessage(message);
		resultBean.setData(data);
		return resultBean;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return toJSONString();
	}

	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
