package com.hck.yanghua.bean;

import java.sql.Timestamp;

/**
 * PinglunId entity. @author MyEclipse Persistence Tools
 */

public class PinglunId implements java.io.Serializable {

	// Fields

	private Long pid;
	private User user;
	private Tiezi tiezi;
	private String content;
	private String image1;
	private String image2;
	private String image3;
	private String image4;
	private String image5;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public PinglunId() {
	}

	/** full constructor */
	public PinglunId(Long pid, User user, Tiezi tiezi, String content,
			String image1, String image2, String image3, String image4,
			String image5, Timestamp time) {
		this.pid = pid;
		this.user = user;
		this.tiezi = tiezi;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.image4 = image4;
		this.image5 = image5;
		this.time = time;
	}

	// Property accessors

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tiezi getTiezi() {
		return this.tiezi;
	}

	public void setTiezi(Tiezi tiezi) {
		this.tiezi = tiezi;
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

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PinglunId))
			return false;
		PinglunId castOther = (PinglunId) other;

		return ((this.getPid() == castOther.getPid()) || (this.getPid() != null
				&& castOther.getPid() != null && this.getPid().equals(
				castOther.getPid())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())))
				&& ((this.getTiezi() == castOther.getTiezi()) || (this
						.getTiezi() != null && castOther.getTiezi() != null && this
						.getTiezi().equals(castOther.getTiezi())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())))
				&& ((this.getImage1() == castOther.getImage1()) || (this
						.getImage1() != null && castOther.getImage1() != null && this
						.getImage1().equals(castOther.getImage1())))
				&& ((this.getImage2() == castOther.getImage2()) || (this
						.getImage2() != null && castOther.getImage2() != null && this
						.getImage2().equals(castOther.getImage2())))
				&& ((this.getImage3() == castOther.getImage3()) || (this
						.getImage3() != null && castOther.getImage3() != null && this
						.getImage3().equals(castOther.getImage3())))
				&& ((this.getImage4() == castOther.getImage4()) || (this
						.getImage4() != null && castOther.getImage4() != null && this
						.getImage4().equals(castOther.getImage4())))
				&& ((this.getImage5() == castOther.getImage5()) || (this
						.getImage5() != null && castOther.getImage5() != null && this
						.getImage5().equals(castOther.getImage5())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPid() == null ? 0 : this.getPid().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getTiezi() == null ? 0 : this.getTiezi().hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result
				+ (getImage1() == null ? 0 : this.getImage1().hashCode());
		result = 37 * result
				+ (getImage2() == null ? 0 : this.getImage2().hashCode());
		result = 37 * result
				+ (getImage3() == null ? 0 : this.getImage3().hashCode());
		result = 37 * result
				+ (getImage4() == null ? 0 : this.getImage4().hashCode());
		result = 37 * result
				+ (getImage5() == null ? 0 : this.getImage5().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}

}