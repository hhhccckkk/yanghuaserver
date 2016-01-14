package com.hck.yanghua.bean;

/**
 * Huitie entity. @author MyEclipse Persistence Tools
 */

public class Huitie implements java.io.Serializable {

	// Fields

	private Long hid;
	private Tiezi tiezi;
	private User user;
	private String content;
	private String time;

	// Constructors

	/** default constructor */
	public Huitie() {
	}

	/** full constructor */
	public Huitie(Tiezi tiezi, User user, String content, String time) {
		this.tiezi = tiezi;
		this.user = user;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Long getHid() {
		return this.hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public Tiezi getTiezi() {
		return this.tiezi;
	}

	public void setTiezi(Tiezi tiezi) {
		this.tiezi = tiezi;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

}