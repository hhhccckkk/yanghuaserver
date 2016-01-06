package com.hck.yanghua.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Tiezi entity. @author MyEclipse Persistence Tools
 */

public class Tiezi implements java.io.Serializable {

	// Fields

	private Long tid;
	private String title;
	private String content;
	private String tupian1;
	private String tupian2;
	private String tupian3;
	private String tupian4;
	private String tupian5;
	private String time;
	private Long uid;
	private Integer type;
	private Integer pinglunsize;
	private Integer dingsize;
	private String uname;
	private String uimage;
	private Set pingluns = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tiezi() {
	}

	/** full constructor */
	public Tiezi(String title, String content, String tupian1, String tupian2,
			String tupian3, String tupian4, String tupian5, String time,
			Long uid, Integer type, Integer pinglunsize, Integer dingsize,
			String uname, String uimage, Set pingluns) {
		this.title = title;
		this.content = content;
		this.tupian1 = tupian1;
		this.tupian2 = tupian2;
		this.tupian3 = tupian3;
		this.tupian4 = tupian4;
		this.tupian5 = tupian5;
		this.time = time;
		this.uid = uid;
		this.type = type;
		this.pinglunsize = pinglunsize;
		this.dingsize = dingsize;
		this.uname = uname;
		this.uimage = uimage;
		this.pingluns = pingluns;
	}

	// Property accessors

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
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

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUimage() {
		return this.uimage;
	}

	public void setUimage(String uimage) {
		this.uimage = uimage;
	}

	public Set getPingluns() {
		return this.pingluns;
	}

	public void setPingluns(Set pingluns) {
		this.pingluns = pingluns;
	}

}