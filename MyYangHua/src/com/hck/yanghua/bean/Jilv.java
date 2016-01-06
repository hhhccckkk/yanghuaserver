package com.hck.yanghua.bean;

/**
 * Jilv entity. @author MyEclipse Persistence Tools
 */

public class Jilv implements java.io.Serializable {

	// Fields

	private Long id;
	private Long huaid;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private String time;
	private String caozuo;
	private String daxiao;
	private String zhuangtai;

	// Constructors

	/** default constructor */
	public Jilv() {
	}

	/** full constructor */
	public Jilv(Long huaid, String content, String image1, String image2,
			String image3, String image4, String image5, String time,
			String caozuo, String daxiao, String zhuangtai) {
		this.huaid = huaid;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.time = time;
		this.caozuo = caozuo;
		this.daxiao = daxiao;
		this.zhuangtai = zhuangtai;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHuaid() {
		return this.huaid;
	}

	public void setHuaid(Long huaid) {
		this.huaid = huaid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage1() {
		return this.image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return this.image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return this.image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getImage4() {
		return this.image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return this.image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCaozuo() {
		return this.caozuo;
	}

	public void setCaozuo(String caozuo) {
		this.caozuo = caozuo;
	}

	public String getDaxiao() {
		return this.daxiao;
	}

	public void setDaxiao(String daxiao) {
		this.daxiao = daxiao;
	}

	public String getZhuangtai() {
		return this.zhuangtai;
	}

	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

}