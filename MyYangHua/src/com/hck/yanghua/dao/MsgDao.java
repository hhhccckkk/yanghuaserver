package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Xinxi;

public interface MsgDao {
	public boolean addHuiFuMsg(Xinxi xinxi);

	public List<Xinxi> getHuiFuMsg(long uid, int page);

	public boolean deleteMsg(long msgId);

	public long getMsgSize(long uid);

}
