package com.hck.yanghua.bean;

/**
 * Banben entity. @author MyEclipse Persistence Tools
 */

public class Banben implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer version;
	private String url;
	private String content;

	// Constructors

	/** default constructor */
	public Banben() {
	}

	/** full constructor */
	public Banben(Integer version, String url, String content) {
		this.version = version;
		this.url = url;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}