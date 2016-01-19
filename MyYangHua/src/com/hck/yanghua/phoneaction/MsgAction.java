package com.hck.yanghua.phoneaction;

import java.util.ArrayList;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Xinxi;
import com.hck.yanghua.dao.MsgDao;
import com.hck.yanghua.vo.MsgData;

public class MsgAction extends BaseAction {
	private MsgDao msgDao;

	public MsgDao getMsgDao() {
		return msgDao;
	}

	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}

	public void getHuiFuMsg() {
		init();
		long uid = getLongData("uid");
		int page = getIntData("page");
		List<Xinxi> msg = msgDao.getHuiFuMsg(uid, page);
		json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
		json.put("data", getDatas(msg));
		write();
	}

	private List<MsgData> getDatas(List<Xinxi> xinxis) {
		List<MsgData> msgDatas = new ArrayList<MsgData>();
		MsgData msgData = null;
		Xinxi xinxi = null;
		for (int i = 0; i < xinxis.size(); i++) {
			xinxi = xinxis.get(i);
			msgData = new MsgData();
			msgData.setContent(xinxi.getContent());
			msgData.setId(xinxi.getId());
			msgData.setIsRed(xinxi.getIsRed());
			msgData.setTid(xinxi.getTid());
			msgData.setTime(xinxi.getTime());
			msgData.setTouxiang(xinxi.getUser().getTouxiang());
			msgData.setType(xinxi.getType());
			msgData.setUid(xinxi.getUser().getUid());
			msgData.setUserName(xinxi.getUser().getName());
			msgData.setYuantie(xinxi.getYuantie());
			msgDatas.add(msgData);
		}
		return msgDatas;
	}

}
