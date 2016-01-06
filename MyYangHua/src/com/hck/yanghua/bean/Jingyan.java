package com.hck.yanghua.bean;

/**
 * Jingyan entity. @author MyEclipse Persistence Tools
 */

public class Jingyan implements java.io.Serializable {

	// Fields

	private Long id;
	private String image;
	private String name;
	private String title;
	private String time;

	// Constructors

	/** default constructor */
	public Jingyan() {
	}

	/** full constructor */
	public Jingyan(String image, String name, String title, String time) {
		this.image = image;
		this.name = name;
		this.title = title;
		this.time = time;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}