package com.hck.yanghua.bean;

/**
 * Xinxi entity. @author MyEclipse Persistence Tools
 */

public class Xinxi implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String content;
	private Integer type;
	private String time;
	private String yuantie;
    private int isRed;
    private long tid;
    private long buid;
    
	// Constructors

	public long getBuid() {
		return buid;
	}

	public void setBuid(long buid) {
		this.buid = buid;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public int getIsRed() {
		return isRed;
	}

	public void setIsRed(int isRed) {
		this.isRed = isRed;
	}

	/** default constructor */
	public Xinxi() {
	}

	/** full constructor */
	public Xinxi(User user, String content, Integer type, String time,
			String yuantie) {
		this.user = user;
		this.content = content;
		this.type = type;
		this.time = time;
		this.yuantie = yuantie;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

}