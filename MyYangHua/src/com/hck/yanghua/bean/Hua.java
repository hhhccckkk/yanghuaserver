package com.hck.yanghua.bean;

import java.sql.Timestamp;

/**
 * Hua entity. @author MyEclipse Persistence Tools
 */

public class Hua implements java.io.Serializable {

	// Fields

	private Long id;
	private String image;
	private String content;
	private String name;
	private Timestamp time;
	private Long uid;

	// Constructors

	/** default constructor */
	public Hua() {
	}

	/** full constructor */
	public Hua(String image, String content, String name, Timestamp time,
			Long uid) {
		this.image = image;
		this.content = content;
		this.name = name;
		this.time = time;
		this.uid = uid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}