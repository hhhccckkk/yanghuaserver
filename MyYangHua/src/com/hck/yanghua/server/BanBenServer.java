package com.hck.yanghua.server;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Banben;
import com.hck.yanghua.dao.BanBenDao;

public class BanBenServer extends HibernateDaoSupport implements BanBenDao {

	public Banben getBanben(int id) {
		return (Banben) getHibernateTemplate().get(Banben.class, id);
	}

}
