package service;

import java.util.List;

import dao.StudentDao;
import model.Student;


public class StudentService {
	private StudentDao studentdao;

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	public void insertstudent(Student student) {
		studentdao.insertStudent(student);
	}
	public Student searchstudent(int studentId) {
		return studentdao.searchStudent(studentId);
	}
	public List searchStudents(int StudentId) {
		return studentdao.searchStudents(StudentId);
	}
	public void updatestudent(Student student) {
		studentdao.updateStudent(student);
	}
	public void deletestudent(Student student) {
		studentdao.deleteStudent(student);
	}
	public List loadallstudent( ) {
		return studentdao.loadallStudent();
	}
}
