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
import service.ComputerService;
import service.LabService;
import tools.Tools;

@Controller
public class LabController {
	
	static LabService as = (LabService)Listener.applicationContext.getBean("labservice");
	static ComputerService cs = (ComputerService)Listener.applicationContext.getBean("computerservice");
	
	@RequestMapping(value = "/allLab", method = RequestMethod.GET)
	public void loadAllLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Lab> labs = as.loadalllab();
		
		if (!labs.isEmpty()) {
			Gson gson = new Gson();
			String labJson = gson.toJson(labs);

			
			System.out.println(labJson);
			
			Tools.renderData(response, labJson);
		}

	}
	
	@RequestMapping(value = "/searchLabByname", method = RequestMethod.GET)
	public void searchLabByname(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labName = request.getParameter("labName");
		labName = new String(labName.getBytes("iso8859-1"),"UTF-8");
//		System.out.println(labName);
		
		List<Lab> labs = as.searchLabByName(labName);
		
		if (!labs.isEmpty()) {
			Gson gson = new Gson();
			String labJson = gson.toJson(labs);

//			System.out.println(labJson);
			
			Tools.renderData(response, labJson);
		}
		else {
			System.out.println("null");
		}

	}
	

	@RequestMapping(value = "/addLab", method = RequestMethod.GET)
	public void addLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labName = request.getParameter("labName");
		String labPosition = request.getParameter("labPosition");
		labName = new String(labName.getBytes("iso8859-1"),"UTF-8");
		labPosition = new String(labPosition.getBytes("iso8859-1"),"UTF-8");
//		System.out.println(labName);
		
		
			if (as.searchlab(labName) == null) {
				if (as.searchLabByPosintion(labPosition) == null) {
					Lab lab = new Lab();
					lab.setLabName(labName);
					lab.setLabPosition(labPosition);
					as.insertlab(lab);
				}
				else {
					response.setStatus(222);
				}	
			}
			else {
				response.setStatus(221);
			}


	}
	
	@RequestMapping(value = "/updateLab", method = RequestMethod.GET)
	public void updateLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		String labName = request.getParameter("labName");
		String labPosition = request.getParameter("labPosition");
		labName = new String(labName.getBytes("iso8859-1"),"UTF-8");
		labPosition = new String(labPosition.getBytes("iso8859-1"),"UTF-8");
//		System.out.println(labName);
		
		try {
			Lab lab = new Lab();
			lab.setLabId(Integer.valueOf(labId));
			lab.setLabName(labName);
			lab.setLabPosition(labPosition);
			
			as.updatelab(lab);;
		}catch (Exception e) {
			response.setStatus(223);
		}
	}

	@RequestMapping(value = "/deleteLab", method = RequestMethod.GET)
	public void deleteLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
//		String labName = request.getParameter("labName");
//		String labPosition = request.getParameter("labPosition");
//		System.out.println(labName);
		
		if ( cs.searchComputerByLabId(Integer.valueOf(labId)).isEmpty()) {
			Lab lab = new Lab();
			lab.setLabId(Integer.valueOf(labId));
//			lab.setLabName(labName);
//			lab.setLabPosition(labPosition);
			
			as.deletelab(lab);
		}
		else {
			response.setStatus(231);
		}


	}
}
