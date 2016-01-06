package com.hck.yanghua.pcaction;

import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class BaseAction extends ActionSupport{
	 @Id
	@GeneratedValue
	public long id;
	 public int page;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

}
