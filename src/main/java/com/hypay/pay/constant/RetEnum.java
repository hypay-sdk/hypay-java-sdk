package com.hypay.pay.constant;

/**
 * 返回码枚举类
 *
 * @author hypay
 */
public enum RetEnum {

	// 公共返回码10开头
	RET_COMM_SUCCESS(0, "success"),
	RET_COMM_PARAM_ERROR(10001, "参数错误"),
	RET_COMM_PARAM_NOT_FOUND(10002, "信息填写不完整"),
	RET_COMM_OPERATION_FAIL(10003, "操作失败"),
	RET_COMM_RECORD_NOT_EXIST(10004, "记录不存在"),
	RET_COMM_SIGN_FAIL(10005, "签名验证失败"),
	RET_COMM_UNKNOWN_ERROR(10999, "未知错误"),

	// 业务中心返回码11开头
	RET_SERVICE_MCH_NOT_EXIST(11000, "商户不存在"),
	RET_SERVICE_ACCOUNT_NOT_EXIST(11001, "账户不存在"),
	RET_SERVICE_BANK_ACCOUNT_NOT_EXIST(11002, "银行账号不存在"),
	RET_SERVICE_SETT_AMOUNT_NOT_SETT(11003, "可用余额不足结算"),
	RET_SERVICE_FREEZE_AMOUNT_OUT_LIMIT(11004, "冻结金额超限"),
	RET_SERVICE_ACCOUNT_FROZEN_AMOUNT_FAIL(11005, "冻结金额失败"),
	RET_SERVICE_UN_FREEZE_AMOUNT_OUT_LIMIT(11006, "解冻金额超限"),
	RET_SERVICE_ACCOUNT_AMOUNT_UPDATE_FAIL(11007, "更新账户金额失败"),
	RET_SERVICE_ACCOUNT_BALANCE_OUT_LIMIT(11008, "余额不足,减款超限"),
	RET_SERVICE_SETT_RECORD_NOT_EXIST(11009, "结算记录不存在"),
	RET_SERVICE_SETT_STATUS_ERROR(11010, "结算状态错误"),

	// 商户系统返回码12开头
	RET_MCH_PERMISSION_ERROR(12001, "权限错误"),
	RET_MCH_PASSWORD_NOT_MATCH(12002, "密码不符"),
	RET_MCH_STATUS_AUDIT_ING(12003, "商户审核中"),
	RET_MCH_STATUS_STOP(12004, "商户已停止使用"),
	RET_MCH_MOBILE_USED(12005, "手机号已被使用"),
	RET_MCH_MOBILE_FORMAT_ERROR(12006, "手机号格式错误"),
	RET_MCH_EMAIL_USED(12007, "邮箱已被使用"),
	RET_MCH_EMAIL_FORMAT_ERROR(12008, "邮箱格式错误"),
	RET_MCH_REGISTER_FAIL(12009, "注册失败"),
	RET_MCH_PASSWORD_FORMAT_FAIL(12010, "密码格式不符,8-16位字母和数字组合,且至少2位数字"),
	RET_MCH_AUTH_FAIL(12011, "鉴权失败"),
	RET_MCH_CHANNEL_NOT_EXIST(12012, "渠道不存在"),
	RET_MCH_QR_CODE_STOP(12013, "二维码已停止使用"),
	RET_MCH_UA_NOT_SUPPORT(12014, "不支持当前客户端"),
	RET_MCH_UA_NOT_EXIST(12015, "无法识别的客户端"),
	RET_MCH_CONFIG_NOT_EXIST(12016, "商户相关配置不存在"),
	RET_MCH_STATUS_CLOSE(12017, "商户相关状态已关闭"),
	RET_MCH_QR_CHANNEL_NOT_EXIST(12018, "商户扫码支付渠道没有配置"),
	RET_MCH_QR_UA_NOT_CONFIG(12019, "商户没有配置当前扫码支付渠道"),
	RET_MCH_CREATE_TRADE_ORDER_FAIL(12020, "创建交易订单失败"),
	RET_MCH_CREATE_PAY_ORDER_FAIL(12021, "创建支付订单失败"),
	RET_MCH_WX_OPENID_NOT_EXIST(12022, "缺少OPENID参数"),
	RET_MCH_UPDATE_TRADE_ORDER_FAIL(12023, "更新交易订单失败"),
	RET_MCH_GET_WX_OPENID_FAIL(12024, "获取微信OpenId异常"),
	RET_MCH_TRADE_ORDER_NOT_EXIST(12025, "交易订单不存在"),
	RET_MCH_PASSAGE_NOT_EXIST(12019, "商户没有对应支付通道"),
	RET_MCH_MOBILE_SEND_TOO_MUCH(12020, "手机发送次数超限"),
	RET_MCH_MOBILE_SEND_ERROR(12021, "手机发送短信失败"),
	RET_MCH_SMS_VERIFY_FAIL(12022, "短信验证失败"),
	RET_MCH_SMS_VERIFY_OVER_TIME(12023, "短信验证超时"),
	RET_MCH_CHANNEL_NO_OPEN(12024, "当前通道未开启"),
	RET_MCH_CODE_REPEAT(12026, "二维码金额重复"),
	RET_MCH_PAY_ORDER_STATUS_ERROR(12030, "支付订单状态错误"),
	RET_MCH_CREATE_ORDER_ERROR(12031, "商户内部交易订单创建失败"),

	// 运营系统返回码13开头
	RET_MGR_STATUS_ERROR(13001, "状态错误"),
	RET_MGR_LOGIN_FAIL(13002, "登录失败"),
	RET_MGR_USER_STOP(13003, "用户禁止使用");

	private int code;
	private String message;

	RetEnum(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public static RetEnum getRetEnum(int code) {
		for (RetEnum retEnum : RetEnum.values()) {
			if (retEnum.getCode() == code) {
				return retEnum;
			}
		}
		return RET_COMM_UNKNOWN_ERROR;
	}
}
