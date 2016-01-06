package com.hck.yanghua.bean;

/**
 * Xinxi entity. @author MyEclipse Persistence Tools
 */

public class Xinxi implements java.io.Serializable {

	// Fields

	private Long id;
	private String content;
	private Integer type;
	private String time;

	// Constructors

	/** default constructor */
	public Xinxi() {
	}

	/** full constructor */
	public Xinxi(String content, Integer type, String time) {
		this.content = content;
		this.type = type;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}