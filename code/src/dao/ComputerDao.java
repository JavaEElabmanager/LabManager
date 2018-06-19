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
	public Computer searchComputerById(int computerId) {
		String hql = "from Computer where ComputerId=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,computerId);
		return (null == ls_Computer || ls_Computer.isEmpty()) ? null : ls_Computer.get(0);
	}
	public Computer searchComputerByPosition(int computerPosition) {
		String hql = "from Computer where ComputerPosition=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,computerPosition);
		return (null == ls_Computer || ls_Computer.isEmpty()) ? null : ls_Computer.get(0);
	}
	public Computer searchComputerByPositionAndLabId(int computerPosition, int labId, String ip) {
		String hql = "from Computer where labId=? and (ComputerPosition=? or computerIp=?)";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,labId,computerPosition,ip);
		return (null == ls_Computer || ls_Computer.isEmpty()) ? null : ls_Computer.get(0);
	}
	public List searchComputerByLabIdNotusing(int LabId) {
		String hql = "from Computer where LabId=? and isUsing = false";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,LabId);
		return ls_Computer;
	}
	public List searchComputerByLabId(int LabId) {
		String hql = "from Computer where LabId=?";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Computer> ls_Computer = (List<Computer>) ht.find(hql,LabId);
		return ls_Computer;
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
