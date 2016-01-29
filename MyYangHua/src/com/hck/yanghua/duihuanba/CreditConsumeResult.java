package com.hck.yanghua.duihuanba;

public class CreditConsumeResult {

	private boolean success;
	private String errorMessage="";
	private String message="";
	private String bizId="";
	private Long credits=-1L;//用户积分余额
	
	public CreditConsumeResult(boolean success){
		this.success=success;
	}
	
	
	public String toString(){
		if(success){
			return "{'status':'ok','message':'"+message+"','errorMessage':'','bizId':'"+bizId+"','credits':'"+credits+"'}";
		}else{
			return "{'status':'fail','message':'"+message+"','errorMessage':'"+errorMessage+"','credits':'"+credits+"'}";
		}
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getBizId() {
		return bizId;
	}


	public void setBizId(String bizId) {
		this.bizId = bizId;
	}


	public Long getCredits() {
		return credits;
	}


	public void setCredits(Long credits) {
		this.credits = credits;
	}

}
