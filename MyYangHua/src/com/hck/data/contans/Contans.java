package com.hck.data.contans;

public class Contans {
	public static final String APP_NAME="来自app养花社区";
	public static final String CODE = "code";
	public static final int GET_DATA_SUCCESS = 0;
	public static final int GET_DATA_ERROR = -1;
	public static final int USER_TYPE_NORM = 1; // 一般用户
	public static final int tiez_TYPE = 0; // 用户发帖，1系统后台发帖，用html
	public static final int ADD_IMAGE_ERROR_OUT_MAX_SIZE=1; //图片大小超过最大限制
	public static final int ADD_IMAGE_ERROR_UNKNOW=2; //图片上传出问题
	//public static final String image_path = "D:\\myeclipse_workplace\\.metadata\\.me_tcat7\\webapps\\MyYangHua\\tiezi_images\\";
	  public static final String image_path="D:\\workplace\\.metadata\\.me_tcat7\\webapps\\MyYangHua\\tiezi_images\\";
	  public static final String image_xiaotu_path="D:\\workplace\\.metadata\\.me_tcat7\\webapps\\MyYangHua\\tiezi_images_xiaotu\\";
	  
	  
	  
	// 对吧key和id
		public static final String DUIHUANG_BA_KEY = "3GnY3bVw9mj9FcwVucNRzzXZ64Y8";
		public static final String DUIHUANG_BA_Secret = "38MqFCgrQU1Ew6EntFjUPMuJvVXh";
		/**
		 * order type
		 */
		public static int ORDER_ORDER=1;  //订单
		public static int ORDER_HUODONG=2;  //抽奖活动
		public static String ERROR_MSG="审核不通过";
		public static int DUIHUAN_SUCCESS=1;  //订单处理成功
		public static int DUIHUAN_ERROR_SHEHE=2; //订单审核不通过
		public static int DUIHUAN_ERROR_OTHER=3; //其他原因兑换失败
}
