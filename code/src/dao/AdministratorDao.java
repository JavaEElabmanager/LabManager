package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Administrator;

public class AdministratorDao extends HibernateDaoSupport{
	
	public AdministratorDao() {
//		this.setSessionFactory(Listener.sessionFactory);
	}
	
	public void insertAdministrator(Administrator admin) {
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.save(admin);
    }
	public List loadallAdministrator( ) {
		String hql = "from Administrator";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Administrator> ls_admin = (List<Administrator>) ht.find(hql);
		return ls_admin;

	}
	public Administrator searchAdministrator(String adminname) {
		String hql = "from Administrator where adminName=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Administrator> ls_admin = (List<Administrator>) ht.find(hql,adminname);
		return (null == ls_admin || ls_admin.isEmpty()) ? null : ls_admin.get(0);
	}
	public void updateAdministrator(Administrator admin) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.update(admin);
	}
	public void deleteadminitrator(Administrator admin) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.delete(admin);
	}
}
