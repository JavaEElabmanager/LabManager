package dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import model.Student;


public class StudentDao extends HibernateDaoSupport{
	public void insertStudent(Student Student) {
        HibernateTemplate ht = this.getHibernateTemplate();
        ht.save(Student);
    }
	public List loadallStudent( ) {
		String hql = "from Student";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Student> ls_Student = (List<Student>) ht.find(hql);
		return ls_Student;

	}
	public Student searchStudent(int StudentId) {
		String hql = "from Student where StudentId=? ";
		HibernateTemplate ht = this.getHibernateTemplate();
		List<Student> ls_Student = (List<Student>) ht.find(hql,StudentId);
		return (null == ls_Student || ls_Student.isEmpty()) ? null : ls_Student.get(0);
	}
	public void updateStudent(Student Student) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.update(Student);
	}
	public void deleteStudent(Student Student) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.delete(Student);
	}
}
