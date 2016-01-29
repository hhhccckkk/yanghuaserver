package com.hck.yanghua.bean;

/**
 * Guanzhu entity. @author MyEclipse Persistence Tools
 */

public class Guanzhu implements java.io.Serializable {

	// Fields

	private Long id;
	private User userByBuid;
	private User userByUid;
	private String time;

	// Constructors

	/** default constructor */
	public Guanzhu() {
	}

	/** full constructor */
	public Guanzhu(User userByBuid, User userByUid, String time) {
		this.userByBuid = userByBuid;
		this.userByUid = userByUid;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserByBuid() {
		return this.userByBuid;
	}

	public void setUserByBuid(User userByBuid) {
		this.userByBuid = userByBuid;
	}

	public User getUserByUid() {
		return this.userByUid;
	}

	public void setUserByUid(User userByUid) {
		this.userByUid = userByUid;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}