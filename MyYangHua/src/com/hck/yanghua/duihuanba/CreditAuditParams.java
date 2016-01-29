package com.hck.yanghua.duihuanba;

import java.util.ArrayList;
import java.util.List;
/**
 * �?��者向兑吧发起请求，�?知兑吧，订单的审核结果的参数
 * 
 * 兑吧产生的部分订单，出于安全的�?虑，会要求开发�?进行审核，审核�?过后才会继续执行兑换操作
 * 
 * 如果�?��者要告知兑吧审核结果，可以向兑吧发起请求，构建这�?CreditAuditParams对象，将此对象发送给兑吧即可
 * 
 * @author xuhengfei
 *
 */
public class CreditAuditParams {

	//审核通过的订单列表
		private List<String> passOrderNums=new ArrayList<String>();
		//审核不通过的订单列表
		private List<String> rejectOrderNums=new ArrayList<String>();
		public List<String> getPassOrderNums() {
			return passOrderNums;
		}
		public void setPassOrderNums(List<String> passOrderNums) {
			this.passOrderNums = passOrderNums;
		}
		public List<String> getRejectOrderNums() {
			return rejectOrderNums;
		}
		public void setRejectOrderNums(List<String> rejectOrderNums) {
			this.rejectOrderNums = rejectOrderNums;
		}
}
