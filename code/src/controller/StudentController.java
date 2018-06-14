package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import config.Listener;
import model.Lab;
import model.Student;
import service.LabService;
import service.StudentService;
import tools.Tools;

@Controller
public class StudentController {
	
	static StudentService as = (StudentService)Listener.applicationContext.getBean("studentservice");
	
	@RequestMapping(value = "/allStudents", method = RequestMethod.GET)
	public void allStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Student> students = as.loadallstudent();
		
		if (!students.isEmpty()) {
			Gson gson = new Gson();
			String studentJson = gson.toJson(students);

			
			System.out.println(studentJson);
			
			Tools.renderData(response, studentJson);
		}

	}
	
	@RequestMapping(value = "/searchStudentById", method = RequestMethod.GET)
	public void searchStudentById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
//		System.out.println(labName);
		
		Student student = as.searchstudent(Integer.valueOf(studentId));
		
		if (student != null) {
			Gson gson = new Gson();
			String labJson = gson.toJson(student);

//			System.out.println(labJson);
			
			Tools.renderData(response, labJson);
		}
		else {
			System.out.println("null");
		}

	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
//		System.out.println(labName);
		
		if ( as.searchstudent(Integer.valueOf(studentId)) == null ) {
			Student student = new Student();
			student.setStudentId(Integer.valueOf(studentId));
			student.setStudentName(studentName);
			
			as.insertstudent(student);
		}
		else {
//			response.setHeader(arg0, arg1);
		}

	}
	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		//System.out.println(labName);
		
		Student student = new Student();
		student.setStudentId(Integer.valueOf(studentId));
		student.setStudentName(studentName);	
		as.updatestudent(student);

	}
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		//System.out.println(labName);
		
		Student student = new Student();
		student.setStudentId(Integer.valueOf(studentId));
		student.setStudentName(studentName);
		
		as.deletestudent(student);

	}
}
