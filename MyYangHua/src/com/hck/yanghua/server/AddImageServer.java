package com.hck.yanghua.server;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.dao.AddImageDao;

public class AddImageServer extends HibernateDaoSupport implements AddImageDao {

	public boolean addTieZiImage(Tiezi tiezi) {
		try {
            getHibernateTemplate().update(tiezi);
            return true;
		} catch (Exception e) {
			return false;
		}
	}

}
