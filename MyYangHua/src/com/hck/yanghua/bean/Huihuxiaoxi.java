package com.hck.yanghua.bean;

/**
 * Huihuxiaoxi entity. @author MyEclipse Persistence Tools
 */

public class Huihuxiaoxi implements java.io.Serializable {

	// Fields

	private HuihuxiaoxiId id;

	// Constructors

	/** default constructor */
	public Huihuxiaoxi() {
	}

	/** full constructor */
	public Huihuxiaoxi(HuihuxiaoxiId id) {
		this.id = id;
	}

	// Property accessors

	public HuihuxiaoxiId getId() {
		return this.id;
	}

	public void setId(HuihuxiaoxiId id) {
		this.id = id;
	}

}