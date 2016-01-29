package com.hck.yanghua.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Guanzhu;
import com.hck.yanghua.dao.GuanZhuDao;
import com.hck.yanghua.util.Log;

public class GuanZhuServer extends HibernateDaoSupport implements GuanZhuDao {

	public long addGuanZhu(Guanzhu guanzhu) {
		try {
			long gid=(Long) getHibernateTemplate().save(guanzhu);
			return gid;
		} catch (Exception e) {
			Log.log("GuanZhuServer addGuanZhu: " + e.toString());
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Guanzhu> getGuanzhusUid(long uid) {
		String sql = "from Guanzhu gz where gz.userByUid.uid=" + uid;
		return getHibernateTemplate().find(sql);
	}

	@SuppressWarnings("unchecked")
	private List<Guanzhu> getList(String sql, int page, int num) {
		List<Guanzhu> pList = new ArrayList<Guanzhu>();
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

	public List<Guanzhu> getGuanzhus(long uid, int page, int num) {
		String sql = "from Guanzhu  where gz.uid=" + uid;
		if (num == 0) {
			num = 20;
		}
		return getList(sql, page, num);
	}

	public boolean deleteGuanZhu(long gid) {
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(Guanzhu.class, gid));
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public long getMaxId(long uid) {
		String sqlString="from Guanzhu gz where gz.userByUid.uid=" + uid +"order by id desc";
		List<Guanzhu> guanzhus=getHibernateTemplate().find(sqlString);
		if (guanzhus!=null && !guanzhus.isEmpty()) {
			return guanzhus.get(0).getId();
		}
		return 0;
		
	}

}
