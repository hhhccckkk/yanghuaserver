package com.hck.yanghua.bean;

/**
 * HuihuxiaoxiId entity. @author MyEclipse Persistence Tools
 */

public class HuihuxiaoxiId implements java.io.Serializable {

	// Fields

	private Long id;
	private Long uid;
	private String yuantie;
	private String huihu;
	private String time;
	private Long tid;
	private Long pid;

	// Constructors

	/** default constructor */
	public HuihuxiaoxiId() {
	}

	/** full constructor */
	public HuihuxiaoxiId(Long id, Long uid, String yuantie, String huihu,
			String time, Long tid, Long pid) {
		this.id = id;
		this.uid = uid;
		this.yuantie = yuantie;
		this.huihu = huihu;
		this.time = time;
		this.tid = tid;
		this.pid = pid;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return this.uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getYuantie() {
		return this.yuantie;
	}

	public void setYuantie(String yuantie) {
		this.yuantie = yuantie;
	}

	public String getHuihu() {
		return this.huihu;
	}

	public void setHuihu(String huihu) {
		this.huihu = huihu;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getTid() {
		return this.tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HuihuxiaoxiId))
			return false;
		HuihuxiaoxiId castOther = (HuihuxiaoxiId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getUid() == castOther.getUid()) || (this.getUid() != null
						&& castOther.getUid() != null && this.getUid().equals(
						castOther.getUid())))
				&& ((this.getYuantie() == castOther.getYuantie()) || (this
						.getYuantie() != null && castOther.getYuantie() != null && this
						.getYuantie().equals(castOther.getYuantie())))
				&& ((this.getHuihu() == castOther.getHuihu()) || (this
						.getHuihu() != null && castOther.getHuihu() != null && this
						.getHuihu().equals(castOther.getHuihu())))
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getTid() == castOther.getTid()) || (this.getTid() != null
						&& castOther.getTid() != null && this.getTid().equals(
						castOther.getTid())))
				&& ((this.getPid() == castOther.getPid()) || (this.getPid() != null
						&& castOther.getPid() != null && this.getPid().equals(
						castOther.getPid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37 * result
				+ (getYuantie() == null ? 0 : this.getYuantie().hashCode());
		result = 37 * result
				+ (getHuihu() == null ? 0 : this.getHuihu().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getTid() == null ? 0 : this.getTid().hashCode());
		result = 37 * result
				+ (getPid() == null ? 0 : this.getPid().hashCode());
		return result;
	}

}