package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Huitie;

public interface HuiTieDao {
 /**
  * �ֻ�
  */
	//���ӻظ�
	public long addHuiTie(Huitie huitie);
	
	public List<Huitie> getHuiTie(long tid,int page,int maxSize);
	
}
