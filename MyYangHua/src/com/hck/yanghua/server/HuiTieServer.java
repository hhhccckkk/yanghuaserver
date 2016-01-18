package com.hck.yanghua.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Huitie;
import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.dao.HuiTieDao;

public class HuiTieServer extends HibernateDaoSupport implements HuiTieDao {

	public long addHuiTie(Huitie huitie) {
		try {
			long id = (Long) getHibernateTemplate().save(huitie);
			return id;
		} catch (Exception e) {
		}
		return -1;
	}

	public List<Huitie> getHuiTie(long tid, int page, int maxSize) {
		String sql = "from Huitie ht where ht.tid=" + tid
				+ " order by ht.id asc";
		return getList(sql, page, maxSize);
	}

	@SuppressWarnings("unchecked")
	private List<Huitie> getList(String sql, int page, int num) {
		List<Huitie> pList = new ArrayList<Huitie>();
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

}
