package com.hck.yanghua.phoneaction;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Banben;
import com.hck.yanghua.server.BanBenServer;

public class BanBenAction extends BaseAction {
	private int id;
	private BanBenServer banBenServer;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BanBenServer getBanBenServer() {
		return banBenServer;
	}

	public void setBanBenServer(BanBenServer banBenServer) {
		this.banBenServer = banBenServer;
	}

	public void getBanBenInfo() {
		System.out.print("ddddddddddddd: "+id);
		init();
		Banben banben = banBenServer.getBanben(id);
		if (banben != null) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
			json.put("data", banben);
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		}
		write();

	}

}
