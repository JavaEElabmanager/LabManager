package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Record;


public class RecordDao extends HibernateDaoSupport{
	public void insertRecord(Record Record) {
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.save(Record);
    }
	public List loadallRecord() {
		String hql = "from Record order by startTime desc";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Record> ls_Record = (List<Record>) ht.find(hql);
		return ls_Record;

	}
	public List loadRecordWithoutEnd() {
		String hql = "from Record where endTime = null order by startTime asc";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Record> ls_Record = (List<Record>) ht.find(hql);
		return ls_Record;

	}
	public Record searchRecord(int RecordId) {
		String hql = "from Record where RecordId=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Record> ls_Record = (List<Record>) ht.find(hql,RecordId);
		return (null == ls_Record || ls_Record.isEmpty()) ? null : ls_Record.get(0);
	}
	public List searchRecordByStudentName(String StudentName) {
		String hql = "from Record where StudentName like ? order by startTime desc";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Record> ls_Record = (List<Record>) ht.find(hql,"%"+StudentName+"%");
		return ls_Record;
	}
	public List searchRecordByLabName(String LabName) {
		String hql = "from Record where LabName like ? order by startTime desc";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Record> ls_Record = (List<Record>) ht.find(hql,"%"+LabName+"%");
		return ls_Record;
	}
	public void updateRecord(Record Record) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.update(Record);
	}
	public void deleteRecord(Record Record) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.delete(Record);
	}
}
