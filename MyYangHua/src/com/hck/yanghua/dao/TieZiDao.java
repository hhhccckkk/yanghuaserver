package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Tiezi;

public interface TieZiDao {
/**
 * 手机用
 */
	//增加帖子
	public long addTieZi(Tiezi tiezi);
	//获取帖子
	public List<Tiezi> getTiezis(int page,int maxSize);
	//用id获取帖子
	public Tiezi getTiezi(long tid);
	
	public boolean updateTiezi(Tiezi tiezi);
}
