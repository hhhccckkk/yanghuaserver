package com.hck.yanghua.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.dao.TieZiDao;

public class TieZiServer extends HibernateDaoSupport implements TieZiDao {

	public long addTieZi(Tiezi tiezi) {
		try {
			long id = (Long) getHibernateTemplate().save(tiezi);
			return id;
		} catch (Exception e) {
			return -1;
		}
	}

	public List<Tiezi> getTiezis(int page, int maxSize) {
		if (maxSize <= 0) {
			maxSize = 10;
		}
		String sql = "from Tiezi tiezi order by tiezi.huiFuTime desc";
		return getList(sql, page, maxSize);
	}

	@SuppressWarnings("unchecked")
	private List<Tiezi> getList(String sql, int page, int num) {
		List<Tiezi> pList = new ArrayList<Tiezi>();
		Query query = null;
		Session session = this.getHibernateTemplate().getSessionFactory()
				.openSession();
		query = session.createQuery(sql);
		query.setFirstResult((page - 1) * num);
		query.setMaxResults(num);
		pList = query.list();
		super.releaseSession(session);
		session = null;
		return pList;
	}

	private int getCount(String sql) {

		return this.getHibernateTemplate().find(sql).size();
	}

	public Tiezi getTiezi(long tid) {
		return (Tiezi) getHibernateTemplate().get(Tiezi.class, tid);
	}

	public boolean updateTiezi(Tiezi tiezi) {
		try {
			getHibernateTemplate().update(tiezi);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
