package com.hck.yanghua.dao;

import java.util.List;

import com.hck.yanghua.bean.Zan;

public interface ZanDao {
 public List<Zan> getZans(long tie);
 public boolean addZan(Zan zan);
}
