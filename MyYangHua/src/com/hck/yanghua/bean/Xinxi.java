package com.hck.yanghua.bean;

/**
 * Xinxi entity. @author MyEclipse Persistence Tools
 */

public class Xinxi implements java.io.Serializable {

	// Fields

	private Long id;
	private Tiezi tiezi;
	private User user;
	private String content;
	private Integer type;
	private String time;
	private String yuantie;
	private Integer isred;
	private Long buid;
    private int saleOrNorm;
    
	// Constructors

	public int getSaleOrNorm() {
		return saleOrNorm;
	}

	public void setSaleOrNorm(int saleOrNorm) {
		this.saleOrNorm = saleOrNorm;
	}

	/** default constructor */
	public Xinxi() {
	}

	/** full constructor */
	public Xinxi(Tiezi tiezi, User user, String content, Integer type,
			String time, String yuantie, Integer isred, Long buid) {
		this.tiezi = tiezi;
		this.user = user;
		this.content = content;
		this.type = type;
		this.time = time;
		this.yuantie = yuantie;
		this.isred = isred;
		this.buid = buid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getYuantie() {
		return this.yuantie;
	}

	public void setYuantie(String yuantie) {
		this.yuantie = yuantie;
	}

	public Integer getIsred() {
		return this.isred;
	}

	public void setIsred(Integer isred) {
		this.isred = isred;
	}

	public Long getBuid() {
		return this.buid;
	}

	public void setBuid(Long buid) {
		this.buid = buid;
	}

}