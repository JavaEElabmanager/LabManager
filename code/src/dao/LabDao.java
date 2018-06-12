package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Lab;


public class LabDao extends HibernateDaoSupport{
	public void insertLab(Lab Lab) {
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.save(Lab);
    }
	public List loadallLab( ) {
		String hql = "from Lab";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Lab> ls_Lab = (List<Lab>) ht.find(hql);
		return ls_Lab;

	}
	public Lab searchLab(String Labname) {
		String hql = "from Labr where LabName=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Lab> ls_Lab = (List<Lab>) ht.find(hql,Labname);
		return (null == ls_Lab || ls_Lab.isEmpty()) ? null : ls_Lab.get(0);
	}
	public void updateLab(Lab Lab) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.update(Lab);
	}
	public void deleteLab(Lab Lab) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.delete(Lab);
	}

}
