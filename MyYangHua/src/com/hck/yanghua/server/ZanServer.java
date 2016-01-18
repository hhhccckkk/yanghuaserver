package com.hck.yanghua.server;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Zan;
import com.hck.yanghua.dao.ZanDao;

public class ZanServer extends HibernateDaoSupport implements ZanDao{

	@SuppressWarnings("unchecked")
	public List<Zan> getZans(long tiId) {
		String sql = "from Zan zan where zan.tid="+tiId+" order by zan.id desc";
		return getHibernateTemplate().find(sql);
	}

	public boolean addZan(Zan zan) {
		try {
			getHibernateTemplate().save(zan);
			return true;
		} catch (Exception e) {
			System.out.println("ee: "+e.toString());
			return false;
		}
	}
	public long getCount(String sql) {

		return this.getHibernateTemplate().find(sql).size();
	}

}
