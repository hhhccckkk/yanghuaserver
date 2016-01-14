package com.hck.yanghua.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Tiezi entity. @author MyEclipse Persistence Tools
 */

public class Tiezi implements java.io.Serializable {

	// Fields

	private Long tid;
	private User user;
	private String content;
	private String tupian1;
	private String tupian2;
	private String tupian3;
	private String tupian4;
	private String tupian5;
	private String tupian6;
	private String tupian7;
	private String time;
	private Integer type;
	private Integer pinglunsize;
	private Integer dingsize;
	private Integer isjinghua;
	private Integer iszhiding;
	private Integer istuijian;
	private String huiFuTime;
	private Set huities = new HashSet(0);
	private Set pingluns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tiezi() {
	}

	/** full constructor */
	public Tiezi(User user, String content, String tupian1, String tupian2,
			String tupian3, String tupian4, String tupian5, String time,
			Integer type, Integer pinglunsize, Integer dingsize,
			Integer isjinghua, Integer iszhiding, Integer istuijian,
			String tupian6, String tupian7, Set huities, Set pingluns) {
		this.user = user;
		this.content = content;
		this.tupian1 = tupian1;
		this.tupian2 = tupian2;
		this.tupian3 = tupian3;
		this.tupian4 = tupian4;
		this.tupian5 = tupian5;
		this.time = time;
		this.type = type;
		this.pinglunsize = pinglunsize;
		this.dingsize = dingsize;
		this.isjinghua = isjinghua;
		this.iszhiding = iszhiding;
		this.istuijian = istuijian;
		this.tupian6 = tupian6;
		this.tupian7 = tupian7;
		this.huities = huities;
		this.pingluns = pingluns;
	}

	// Property accessors

	public String getHuiFuTime() {
		return huiFuTime;
	}

	public void setHuiFuTime(String huiFuTime) {
		this.huiFuTime = huiFuTime;
	}

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
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

	public String getTupian1() {
		return this.tupian1;
	}

	public void setTupian1(String tupian1) {
		this.tupian1 = tupian1;
	}

	public String getTupian2() {
		return this.tupian2;
	}

	public void setTupian2(String tupian2) {
		this.tupian2 = tupian2;
	}

	public String getTupian3() {
		return this.tupian3;
	}

	public void setTupian3(String tupian3) {
		this.tupian3 = tupian3;
	}

	public String getTupian4() {
		return this.tupian4;
	}

	public void setTupian4(String tupian4) {
		this.tupian4 = tupian4;
	}

	public String getTupian5() {
		return this.tupian5;
	}

	public void setTupian5(String tupian5) {
		this.tupian5 = tupian5;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPinglunsize() {
		return this.pinglunsize;
	}

	public void setPinglunsize(Integer pinglunsize) {
		this.pinglunsize = pinglunsize;
	}

	public Integer getDingsize() {
		return this.dingsize;
	}

	public void setDingsize(Integer dingsize) {
		this.dingsize = dingsize;
	}

	public Integer getIsjinghua() {
		return this.isjinghua;
	}

	public void setIsjinghua(Integer isjinghua) {
		this.isjinghua = isjinghua;
	}

	public Integer getIszhiding() {
		return this.iszhiding;
	}

	public void setIszhiding(Integer iszhiding) {
		this.iszhiding = iszhiding;
	}

	public Integer getIstuijian() {
		return this.istuijian;
	}

	public void setIstuijian(Integer istuijian) {
		this.istuijian = istuijian;
	}

	public String getTupian6() {
		return this.tupian6;
	}

	public void setTupian6(String tupian6) {
		this.tupian6 = tupian6;
	}

	public String getTupian7() {
		return this.tupian7;
	}

	public void setTupian7(String tupian7) {
		this.tupian7 = tupian7;
	}

	public Set getHuities() {
		return this.huities;
	}

	public void setHuities(Set huities) {
		this.huities = huities;
	}

	public Set getPingluns() {
		return this.pingluns;
	}

	public void setPingluns(Set pingluns) {
		this.pingluns = pingluns;
	}

}