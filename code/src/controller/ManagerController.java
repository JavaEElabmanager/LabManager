package controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import config.Listener;
import model.Computer;
import model.Lab;
import model.Record;
import model.Student;
import service.ComputerService;
import service.LabService;
import service.RecordService;
import service.StudentService;
import tools.Tools;

@Controller
public class ManagerController {
	static RecordService rs = (RecordService)Listener.applicationContext.getBean("recordservice");
	static StudentService ss = (StudentService)Listener.applicationContext.getBean("studentservice");
	static LabService ls = (LabService)Listener.applicationContext.getBean("labservice");
	static ComputerService cs = (ComputerService)Listener.applicationContext.getBean("computerservice");
	
	@RequestMapping(value = "/loadRecordsWithoutEnd", method = RequestMethod.GET)
	public void loadRecordsWithoutEnd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Record> records = rs.loadRecordWithoutEnd();
		
		if (!records.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(records);

			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}

	}
	
	@RequestMapping(value = "/startRecord", method = RequestMethod.GET)
	public void startRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labName = request.getParameter("labName");
		String computerPosition = request.getParameter("computerPosition");
		String studentId = request.getParameter("studentId");
		labName = new String(labName.getBytes("iso8859-1"),"UTF-8");
		System.out.println("computer:" + computerPosition);
		
		Student stu = ss.searchstudent(Integer.valueOf(studentId));
		System.out.println(stu);
		if (stu == null) {
			response.setStatus(231);
		}
		else if (stu.getisUsing()) {
			response.setStatus(232);
		}
		else {
			stu.setisUsing(true);
			ss.updatestudent(stu);
			
			Lab lab = ls.searchlab(labName);
			Computer computer = cs.searchComputerByPosition(lab.getLabId(), Integer.valueOf(computerPosition));
			computer.setisUsing(true);
			cs.updatecomputer(computer);
			
			Record record = new Record();
			record.setStudentId(Integer.valueOf(studentId));
			record.setLabId(ls.searchlab(labName).getLabId());
			record.setComputerPosition(Integer.valueOf(computerPosition));
			record.setStartTime(new Timestamp(System.currentTimeMillis()));
			record.setStudentName(ss.searchstudent(Integer.valueOf(studentId)).getStudentName());
			record.setLabName(labName);
			
			rs.insertrecord(record);
		}	
	}
	
	@RequestMapping(value = "/endRecord", method = RequestMethod.GET)
	public void endRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String recordId = request.getParameter("recordId");
		
		Record record = rs.searchrecord(Integer.valueOf(recordId));
		record.setEndTime(new Timestamp(System.currentTimeMillis()));
		double duration = (record.getEndTime().getTime() - record.getStartTime().getTime())/1000.0;
		record.setDuration((double)Math.round(duration*10)/10);
		rs.updaterecord(record);
		
		int computerPosition = record.getComputerPosition();
		Computer computer = cs.searchComputerByPosition(record.getLabId() ,Integer.valueOf(computerPosition));
		computer.setisUsing(false);
		cs.updatecomputer(computer);
		
		int studentId = record.getStudentId();
		Student student = ss.searchstudent(studentId);
		student.setisUsing(false);
		ss.updatestudent(student);
		
//		record.setStudentId(Integer.valueOf(studentId));
//		record.setLabId(ls.searchlab(labName).getLabId());
//		record.setComputerPosition(Integer.valueOf(computerPosition));
//		record.setStartTime(new Timestamp(System.currentTimeMillis()));
//		record.setStudentName(ss.searchstudent(Integer.valueOf(studentId)).getStudentName());
//		record.setLabName(labName);

	}
	
	@RequestMapping(value = "/getComputersBylabId", method = RequestMethod.GET)
	public void getComputers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labName = request.getParameter("labName");
		labName = new String(labName.getBytes("iso8859-1"),"UTF-8");
		List<Computer> computers = cs.searchComputerByLabIdNotusing(ls.searchlab(labName).getLabId());
		System.out.println(labName);
		System.out.println(ls.searchlab(labName).getLabId());
		
		if (!computers.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(computers);

			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}
	}
}
