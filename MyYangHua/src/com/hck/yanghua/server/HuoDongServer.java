package com.hck.yanghua.server;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Huodong;
import com.hck.yanghua.dao.HuoDongDao;

public class HuoDongServer extends HibernateDaoSupport implements HuoDongDao{

	@SuppressWarnings("unchecked")
	public List<Huodong> getHuodongs() {
		String sqlString="from Huodong";
		return getHibernateTemplate().find(sqlString);
	}

}
