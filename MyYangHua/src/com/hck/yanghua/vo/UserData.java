package com.hck.yanghua.vo;

import java.io.Serializable;

public class UserData implements Serializable,Comparable<UserData>{
	private Long uid;
	private String name;
	private String password;
	private String touxiang;
	private Integer type;
	private Integer xingbie;
	private Long jifeng;
	private Integer jinbi;
	private Integer fensi;
	private Integer guanzhu;
	private Integer dongtai;
	private Double jingdu;
	private Double weidu;
	private String address;
	private String aihao;
	private String time;
	private String logintime;
	private String userId;
	private String imei;
	private int juli;
	
	public int getJuli() {
		return juli;
	}
	public void setJuli(int juli) {
		this.juli = juli;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTouxiang() {
		return touxiang;
	}
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getXingbie() {
		return xingbie;
	}
	public void setXingbie(Integer xingbie) {
		this.xingbie = xingbie;
	}
	public Long getJifeng() {
		return jifeng;
	}
	public void setJifeng(Long jifeng) {
		this.jifeng = jifeng;
	}
	public Integer getJinbi() {
		return jinbi;
	}
	public void setJinbi(Integer jinbi) {
		this.jinbi = jinbi;
	}
	public Integer getFensi() {
		return fensi;
	}
	public void setFensi(Integer fensi) {
		this.fensi = fensi;
	}
	public Integer getGuanzhu() {
		return guanzhu;
	}
	public void setGuanzhu(Integer guanzhu) {
		this.guanzhu = guanzhu;
	}
	public Integer getDongtai() {
		return dongtai;
	}
	public void setDongtai(Integer dongtai) {
		this.dongtai = dongtai;
	}
	public Double getJingdu() {
		return jingdu;
	}
	public void setJingdu(Double jingdu) {
		this.jingdu = jingdu;
	}
	public Double getWeidu() {
		return weidu;
	}
	public void setWeidu(Double weidu) {
		this.weidu = weidu;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAihao() {
		return aihao;
	}
	public void setAihao(String aihao) {
		this.aihao = aihao;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public int compareTo(UserData o) {
		return this.juli-o.getJuli();
	}
	

}
