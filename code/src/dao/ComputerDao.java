package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Computer;


public class ComputerDao extends HibernateDaoSupport{
	public void insertComputer(Computer Computer) {
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.save(Computer);
    }
	public List loadallComputer( ) {
		String hql = "from Computer";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql);
		return ls_Computer;

	}
	public Computer searchComputer(int ComputerId) {
		String hql = "from Computer where ComputerId=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,ComputerId);
		return (null == ls_Computer || ls_Computer.isEmpty()) ? null : ls_Computer.get(0);
	}
	public void updateComputer(Computer Computer) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.update(Computer);
	}
	public void deleteComputer(Computer Computer) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.delete(Computer);
	}
}
