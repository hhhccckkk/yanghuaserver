package com.hck.yanghua.bean;

/**
 * Huitie entity. @author MyEclipse Persistence Tools
 */

public class Huitie implements java.io.Serializable {

	// Fields

	private Long hid;
	private User user;
	private Long tid;
	private String content;
	private String time;
	private String image1;
	private String iamge2;
	private String iamge3;
	private Integer type;
    private String address;
    private String huifuname;
    
    public String getHuifuname() {
		return huifuname;
	}

	public void setHuifuname(String huifuname) {
		this.huifuname = huifuname;
	}

	private String yuanTie;
    
	public String getYuanTie() {
		return yuanTie;
	}

	public void setYuanTie(String yuanTie) {
		this.yuanTie = yuanTie;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/** default constructor */
	public Huitie() {
	}

	/** full constructor */
	public Huitie(User user, Long tid, String content, String time,
			String image1, String iamge2, String iamge3, Integer type) {
		this.user = user;
		this.tid = tid;
		this.content = content;
		this.time = time;
		this.image1 = image1;
		this.iamge2 = iamge2;
		this.iamge3 = iamge3;
		this.type = type;
	}

	// Property accessors

	public Long getHid() {
		return this.hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getImage1() {
		return this.image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getIamge2() {
		return this.iamge2;
	}

	public void setIamge2(String iamge2) {
		this.iamge2 = iamge2;
	}

	public String getIamge3() {
		return this.iamge3;
	}

	public void setIamge3(String iamge3) {
		this.iamge3 = iamge3;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}