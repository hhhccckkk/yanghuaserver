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
	public List<Tiezi> getTiezis(int type,int page,int maxSize);
	//用id获取帖子
	public Tiezi getTiezi(long tid);
	//更新帖子
	public boolean updateTiezi(Tiezi tiezi);
	//获取热门帖子
	public List<Tiezi> getHotTiezis(int page,int maxSize);
	
	
}
