package com.hck.yanghua.bean;

/**
 * Ad entity. @author MyEclipse Persistence Tools
 */

public class Ad implements java.io.Serializable {

	// Fields

	private Integer id;
	private String image;
	private String url;
	private Integer type;

	// Constructors

	/** default constructor */
	public Ad() {
	}

	/** full constructor */
	public Ad(String image, String url, Integer type) {
		this.image = image;
		this.url = url;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}