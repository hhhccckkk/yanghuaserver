package com.hck.yanghua.phoneaction;

import java.util.ArrayList;
import java.util.List;

import com.hck.data.contans.Contans;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.User;
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
			
			msgData.setTime(xinxi.getTime());
			msgData.setTouxiang(xinxi.getUser().getTouxiang());
			msgData.setType(xinxi.getType());
			msgData.setUid(xinxi.getUser().getUid());
			msgData.setUserName(xinxi.getUser().getName());
			msgData.setYuantie(xinxi.getYuantie());
			msgData.setUserMsgId(xinxi.getUser().getUserid());
			
			Tiezi tiezi=xinxi.getTiezi();
			User user=tiezi.getUser();
			msgData.setXingbie(user.getXingbie());
			msgData.setAddress(user.getAddress());
			msgData.setFensi(user.getFensi());
			msgData.setFatieTime(tiezi.getTime());
			msgData.setImage1(tiezi.getTupian1());
			msgData.setImage2(tiezi.getTupian2());
			msgData.setImage3(tiezi.getTupian3());
			msgData.setImage4(tiezi.getTupian4());
			msgData.setImage5(tiezi.getTupian5());
			msgData.setTid(tiezi.getTid());
			msgData.setTieziUserName(user.getName());
			msgData.setFatieUserTX(user.getTouxiang());
			msgDatas.add(msgData);
		}
		return msgDatas;
	}

	public void deleteHuiFuMsg() {
		init();
		long msgId = getLongData("msgId");
		System.out.println("deleteHuiFuMsg: "+msgId);
		boolean b = msgDao.deleteMsg(msgId);
		if (b) {
			json.put(Contans.CODE, Contans.GET_DATA_SUCCESS);
		} else {
			json.put(Contans.CODE, Contans.GET_DATA_ERROR);
		}

		write();
	}

}
