package com.hck.yanghua.bean;

/**
 * Zan entity. @author MyEclipse Persistence Tools
 */

public class Zan implements java.io.Serializable {

	// Fields

	private Long id;
	private Long tid;
	private Long uid;
	private String image;

	// Constructors

	/** default constructor */
	public Zan() {
	}

	/** full constructor */
	public Zan(Long tid, Long uid, String image) {
		this.tid = tid;
		this.uid = uid;
		this.image = image;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}