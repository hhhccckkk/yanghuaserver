package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Tiezi;

public interface TieZiDao {
/**
 * �ֻ���
 */
	//��������
	public long addTieZi(Tiezi tiezi);
	//��ȡ����
	public List<Tiezi> getTiezis(int type,int page,int maxSize);
	//��id��ȡ����
	public Tiezi getTiezi(long tid);
	//��������
	public boolean updateTiezi(Tiezi tiezi);
	//��ȡ��������
	public List<Tiezi> getHotTiezis(int page,int maxSize);
	
	
}
