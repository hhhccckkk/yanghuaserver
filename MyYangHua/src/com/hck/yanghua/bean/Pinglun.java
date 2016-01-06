package com.hck.yanghua.bean;

/**
 * Pinglun entity. @author MyEclipse Persistence Tools
 */

public class Pinglun implements java.io.Serializable {

	// Fields

	private PinglunId id;
	private Tiezi tiezi;
	private User user;

	// Constructors

	/** default constructor */
	public Pinglun() {
	}

	/** minimal constructor */
	public Pinglun(PinglunId id) {
		this.id = id;
	}

	/** full constructor */
	public Pinglun(PinglunId id, Tiezi tiezi, User user) {
		this.id = id;
		this.tiezi = tiezi;
		this.user = user;
	}

	// Property accessors

	public PinglunId getId() {
		return this.id;
	}

	public void setId(PinglunId id) {
		this.id = id;
	}

	public Tiezi getTiezi() {
		return this.tiezi;
	}

	public void setTiezi(Tiezi tiezi) {
		this.tiezi = tiezi;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}