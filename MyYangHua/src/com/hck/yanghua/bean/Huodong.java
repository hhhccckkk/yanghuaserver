package com.hck.yanghua.bean;

/**
 * Huodong entity. @author MyEclipse Persistence Tools
 */

public class Huodong implements java.io.Serializable {

	// Fields

	private Integer id;
	private String img;
	private String content;
	private String url;
    private int jinbi;
    private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getJinbi() {
		return jinbi;
	}

	public void setJinbi(int jinbi) {
		this.jinbi = jinbi;
	}

	/** default constructor */
	public Huodong() {
	}

	/** full constructor */
	public Huodong(String img, String content, String url) {
		this.img = img;
		this.content = content;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}