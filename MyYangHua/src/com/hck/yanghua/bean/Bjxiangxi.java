package com.hck.yanghua.bean;

/**
 * Bjxiangxi entity. @author MyEclipse Persistence Tools
 */

public class Bjxiangxi implements java.io.Serializable {

	// Fields

	private Long id;
	private Long bid;
	private Integer type;
	private String content;
	private String time;

	// Constructors

	/** default constructor */
	public Bjxiangxi() {
	}

	/** full constructor */
	public Bjxiangxi(Long bid, Integer type, String content, String time) {
		this.bid = bid;
		this.type = type;
		this.content = content;
		this.time = time;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBid() {
		return this.bid;
	}

	public void setBid(Long bid) {
		this.bid = bid;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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