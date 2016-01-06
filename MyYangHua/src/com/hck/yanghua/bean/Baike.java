package com.hck.yanghua.bean;

/**
 * Baike entity. @author MyEclipse Persistence Tools
 */

public class Baike implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String image;

	// Constructors

	/** default constructor */
	public Baike() {
	}

	/** full constructor */
	public Baike(String name, String image) {
		this.name = name;
		this.image = image;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}