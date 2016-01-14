package com.hck.yanghua.phoneaction;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

public class BaseAction {

	public String password;
	public JSONObject json;
	public String jsonString;
	public HttpServletRequest request = null;
	public HttpServletResponse response = null;
	
	public boolean isPasswordOk(String password) {
		if (password == null || "".equals(password)
				|| !"HCK123hck".equals(password)) {
			return false;
		}
		return true;
	}

	public void init() {
		json = new JSONObject();
		if (response == null) {
			response = ServletActionContext.getResponse();
		}
		if (request == null) {
			request = ServletActionContext.getRequest();
		}
		response = ServletActionContext.getResponse();
		request = ServletActionContext.getRequest();
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		

	}

	public void write() {

		jsonString = json.toString();
		OutputStream oStream = null;
		try {
			oStream = response.getOutputStream();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			oStream.write(jsonString.getBytes("UTF-8"));
			oStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		response = null;
		request = null;
		oStream=null;
	}

	public String getStringData(String key) {
		return request.getParameter(key);
	}

	public int getIntData(String key) {
		if (getStringData(key)==null) {
			return 0;
		}
		int data = Integer.parseInt(getStringData(key));
		return data;
	}
	public double getDoubleData(String key) {
		if (getStringData(key)==null) {
			return 0.0;
		}
		double data = Double.valueOf(getStringData(key));
		return data;
	}

	public long getLongData(String key) {
		if (getStringData(key)==null) {
			return 0l;
		}
		long data = Long.parseLong(getStringData(key));
		return data;
	}
}
