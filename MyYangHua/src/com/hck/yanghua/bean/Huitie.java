package com.hck.yanghua.bean;

/**
 * Huitie entity. @author MyEclipse Persistence Tools
 */

public class Huitie implements java.io.Serializable {

	// Fields

	private Long hid;
	private Long uid;
	private Long pid;
	private String content;
	private String time;

	// Constructors

	/** default constructor */
	public Huitie() {
	}

	/** full constructor */
	public Huitie(Long uid, Long pid, String content, String time) {
		this.uid = uid;
		this.pid = pid;
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

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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