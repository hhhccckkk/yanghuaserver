package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Tiezi;

public interface TieZiDao {
/**
 * 手机用
 */
	//增加帖子
	public long addTieZi(Tiezi tiezi);
	public List<Tiezi> getTiezis(int page,int maxSize);
}
