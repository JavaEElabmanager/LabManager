package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import config.Listener;
import model.Record;
import model.Student;
import service.RecordService;
import service.StudentService;
import tools.Tools;

@Controller
public class RecordController {
	
	static RecordService as = (RecordService)Listener.applicationContext.getBean("recordservice");
	
	@RequestMapping(value = "/allRecords", method = RequestMethod.GET)
	public void allRecords(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Record> records = as.loadallrecord();
		
		if (!records.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(records);

			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}

	}
	
	@RequestMapping(value = "/searchRecordsByStudent", method = RequestMethod.GET)
	public void searchRecordsByStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentName = request.getParameter("studentName");
		
		List<Record> records = as.searchRecordByStudentName(studentName);
		
		if (!records.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(records);

			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}

	}
	
	@RequestMapping(value = "/searchRecordsByLab", method = RequestMethod.GET)
	public void searchRecordsByLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labName = request.getParameter("labName");
		
		List<Record> records = as.searchRecordByLabName(labName);
		
		if (!records.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(records);

			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}

	}
}
