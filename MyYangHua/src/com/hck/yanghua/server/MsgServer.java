package com.hck.yanghua.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Tiezi;
import com.hck.yanghua.bean.Xinxi;
import com.hck.yanghua.dao.MsgDao;

public class MsgServer extends HibernateDaoSupport implements MsgDao {

	public boolean addHuiFuMsg(Xinxi xinxi) {
		try {
			getHibernateTemplate().save(xinxi);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private List<Xinxi> getList(String sql, int page, int num) {
		List<Xinxi> pList = new ArrayList<Xinxi>();
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

	public List<Xinxi> getHuiFuMsg(long uid, int page) {
		String sql = "from Xinxi xinxi where xinxi.buid=" + uid
				+ " order by xinxi.id desc";
		return getList(sql, page, 20);
	}

}
