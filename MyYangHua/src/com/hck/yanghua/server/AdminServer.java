package com.hck.yanghua.server;

import java.util.List;

import javax.persistence.Entity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hck.yanghua.bean.Admin;
import com.hck.yanghua.dao.AdminDao;

@Entity
public class AdminServer extends HibernateDaoSupport implements AdminDao {
	public Admin login(Admin admin) {
	    List<Admin> admin2=null;
	    Admin admin3=null;
		//String sql="from Admin a where a.name='"+admin.getName()+"' and a.password='"+Md5.MD5(admin.getPassword())+"'";
		String sql="from Admin a where a.name='"+admin.getName()+"' and a.password='"+admin.getPassword()+"'";
		admin2=this.getHibernateTemplate().find(sql);
		if (admin2.size()>0) {
			admin3=admin2.get(0);
		}
		return admin3;
	}

	
}
