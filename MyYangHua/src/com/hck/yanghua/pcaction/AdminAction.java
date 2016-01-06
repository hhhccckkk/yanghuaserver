package com.hck.yanghua.pcaction;

import com.hck.yanghua.bean.Admin;
import com.hck.yanghua.server.AdminServer;
import com.opensymphony.xwork2.ActionContext;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@SuppressWarnings("serial")
public class AdminAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private AdminServer aServer;
	@ManyToOne
	private Admin admin;

	public AdminServer getaServer() {
		return aServer;
	}

	public void setaServer(AdminServer aServer) {
		this.aServer = aServer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() {
		Admin admin2 = aServer.login(admin);
		if (admin2 == null || admin2.getName() == null) {
			addActionError("µÇÂ½Ê§°Ü");
			return ERROR;
		}
		ActionContext.getContext().getSession().put("admin",admin2);
		return SUCCESS;
	}

}
