package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Guanzhu;

public interface GuanZhuDao {
public long addGuanZhu(Guanzhu guanzhu);
public List<Guanzhu> getGuanzhus(long uid,int page,int num);
public List<Guanzhu> getGuanzhusUid(long uid);
public boolean deleteGuanZhu(long gid);
public long getMaxId(long uid); //��ȡ��ע�����һ����Ϣid
}
