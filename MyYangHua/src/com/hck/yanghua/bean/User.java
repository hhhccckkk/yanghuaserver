package com.hck.yanghua.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

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
	private Timestamp logintime;
	private String userid;
	private String imei;
	private String city;
	private String pushid;
	private Set tiezis = new HashSet(0);
	private Set huities = new HashSet(0);
	private Set pingluns = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password, String touxiang, Integer type,
			Integer xingbie, Long jifeng, Integer jinbi, Integer fensi,
			Integer guanzhu, Integer dongtai, Double jingdu, Double weidu,
			String address, String aihao, String time, Timestamp logintime,
			String userid, String imei, String city, String pushid, Set tiezis,
			Set huities, Set pingluns) {
		this.name = name;
		this.password = password;
		this.touxiang = touxiang;
		this.type = type;
		this.xingbie = xingbie;
		this.jifeng = jifeng;
		this.jinbi = jinbi;
		this.fensi = fensi;
		this.guanzhu = guanzhu;
		this.dongtai = dongtai;
		this.jingdu = jingdu;
		this.weidu = weidu;
		this.address = address;
		this.aihao = aihao;
		this.time = time;
		this.logintime = logintime;
		this.userid = userid;
		this.imei = imei;
		this.city = city;
		this.pushid = pushid;
		this.tiezis = tiezis;
		this.huities = huities;
		this.pingluns = pingluns;
	}

	// Property accessors

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getXingbie() {
		return this.xingbie;
	}

	public void setXingbie(Integer xingbie) {
		this.xingbie = xingbie;
	}

	public Long getJifeng() {
		return this.jifeng;
	}

	public void setJifeng(Long jifeng) {
		this.jifeng = jifeng;
	}

	public Integer getJinbi() {
		return this.jinbi;
	}

	public void setJinbi(Integer jinbi) {
		this.jinbi = jinbi;
	}

	public Integer getFensi() {
		return this.fensi;
	}

	public void setFensi(Integer fensi) {
		this.fensi = fensi;
	}

	public Integer getGuanzhu() {
		return this.guanzhu;
	}

	public void setGuanzhu(Integer guanzhu) {
		this.guanzhu = guanzhu;
	}

	public Integer getDongtai() {
		return this.dongtai;
	}

	public void setDongtai(Integer dongtai) {
		this.dongtai = dongtai;
	}

	public Double getJingdu() {
		return this.jingdu;
	}

	public void setJingdu(Double jingdu) {
		this.jingdu = jingdu;
	}

	public Double getWeidu() {
		return this.weidu;
	}

	public void setWeidu(Double weidu) {
		this.weidu = weidu;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAihao() {
		return this.aihao;
	}

	public void setAihao(String aihao) {
		this.aihao = aihao;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Timestamp getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Timestamp logintime) {
		this.logintime = logintime;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPushid() {
		return this.pushid;
	}

	public void setPushid(String pushid) {
		this.pushid = pushid;
	}

	public Set getTiezis() {
		return this.tiezis;
	}

	public void setTiezis(Set tiezis) {
		this.tiezis = tiezis;
	}

	public Set getHuities() {
		return this.huities;
	}

	public void setHuities(Set huities) {
		this.huities = huities;
	}

	public Set getPingluns() {
		return this.pingluns;
	}

	public void setPingluns(Set pingluns) {
		this.pingluns = pingluns;
	}

}