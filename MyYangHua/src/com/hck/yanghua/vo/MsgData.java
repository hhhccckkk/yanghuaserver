package com.hck.yanghua.vo;

import com.hck.yanghua.bean.User;

public class MsgData {
	private Long id;
	private String content;
	private Integer type;
	private String time;
	private String yuantie;
    private int isRed;
    private long tid;
    private String userName;
    private String touxiang;
    private long uid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getYuantie() {
		return yuantie;
	}
	public void setYuantie(String yuantie) {
		this.yuantie = yuantie;
	}
	public int getIsRed() {
		return isRed;
	}
	public void setIsRed(int isRed) {
		this.isRed = isRed;
	}
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
    
}
