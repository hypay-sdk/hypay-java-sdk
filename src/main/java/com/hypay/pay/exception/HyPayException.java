package com.hypay.pay.exception;

/**
 * 异常类
 *
 * @author hypay
 */
public class HyPayException extends Exception {
	private static final long serialVersionUID = 5815592887197921179L;

	/**
	 * 错误码
	 */
	private String errCode;
	/**
	 * 错误信息
	 */
	private String errMsg;

	public HyPayException() {
	}

	public HyPayException(String message, Throwable cause) {
		super(message, cause);
	}

	public HyPayException(String message) {
		super(message);
	}

	public HyPayException(Throwable cause) {
		super(cause);
	}

	public HyPayException(String errCode, String errMsg) {
		super(errCode + ":" + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return this.errCode;
	}

	public String getErrMsg() {
		return this.errMsg;
	}
}
