package com.hck.yanghua.duihuanba;

import java.util.Date;

/**
 * �?��者向兑吧发起请求，确认兑换成功失败的参数
 * 
 * 目前仅限于虚拟商品，�?��使用
 * @author xuhengfei
 *
 */
public class CreditConfirmParams {

	private boolean success=true;
	private String errorMessage="";
	private String orderNum="";
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
}
