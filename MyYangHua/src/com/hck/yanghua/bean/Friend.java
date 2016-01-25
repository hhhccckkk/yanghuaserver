package com.hck.yanghua.bean;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private Long uid;
	private Integer isok;
	private String time;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** full constructor */
	public Friend(User user, Long uid, Integer isok, String time) {
		this.user = user;
		this.uid = uid;
		this.isok = isok;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getIsok() {
		return this.isok;
	}

	public void setIsok(Integer isok) {
		this.isok = isok;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}