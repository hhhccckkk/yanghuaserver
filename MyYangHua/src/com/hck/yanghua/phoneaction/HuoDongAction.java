package com.hck.yanghua.phoneaction;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Huodong;
import com.hck.yanghua.bean.User;
import com.hck.yanghua.dao.HuoDongDao;
import com.hck.yanghua.dao.UserDao;
import com.hck.yanghua.duihuanba.CreditTool;

public class HuoDongAction extends BaseAction {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	private HuoDongDao huoDongDao;

	public HuoDongDao getHuoDongDao() {
		return huoDongDao;
	}

	public void setHuoDongDao(HuoDongDao huoDongDao) {
		this.huoDongDao = huoDongDao;
	}

	public void getHuoDongs() {
		init();
		List<Huodong> huodongs = huoDongDao.getHuodongs();
		json.put("data", huodongs);
		write();
	}
	public void getHuoDongUrl() {
		init();
		
		long time =new Date().getTime();
		String url = getStringData("url");
		System.out.print("url: "+url);
		long uid = getLongData("uid");
		User user = userDao.getUser(uid);
		if (user == null) {
			json.put("isok", false);
		}
		long ponit = user.getJinbi();
		Map<String, String> data = new HashMap<String, String>();
		data.put("appKey", Contans.DUIHUANG_BA_KEY);
		data.put("appSecret", Contans.DUIHUANG_BA_Secret);
		data.put("uid", uid + "");
		data.put("credits", ponit + "");
		data.put("timestamp", time+"");
		data.put("redirect", url);
		String duihuanUrl = null;
		CreditTool tool = new CreditTool(Contans.DUIHUANG_BA_KEY,
				Contans.DUIHUANG_BA_Secret);
		duihuanUrl=tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?", data);
		json.put("isok", true);
		json.put("url", duihuanUrl);
		write();

	}
	
	@SuppressWarnings("unchecked")
	public void getDuiHuanUrl() {
		init();
		String url = null;
		long uid = getLongData("uid");
		long point = getLongData("point");
		if (uid <= 0) {
			json.put("isok", false);
		} else {
			CreditTool tool = new CreditTool(Contans.DUIHUANG_BA_KEY,
					Contans.DUIHUANG_BA_Secret);
			Map params = new HashMap();
			params.put("uid", uid + "");
			params.put("credits", point + "");
			String redirect = "http://www.duiba.com.cn/chome/index";
			params.put("redirect", redirect);
			url = tool.buildUrlWithSign(
					"http://www.duiba.com.cn/autoLogin/autologin?", params);
			json.put("isok", true);
			json.put("url", url);
		}
		write();

	}
	
}
