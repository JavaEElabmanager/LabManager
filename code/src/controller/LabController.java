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
import service.LabService;
import tools.Tools;

@Controller
public class LabController {
	
	static LabService as = (LabService)Listener.applicationContext.getBean("labservice");
	
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
//		System.out.println(labName);
		
		Lab lab = as.searchlab(labName);
		
		if (lab != null) {
			Gson gson = new Gson();
			String labJson = gson.toJson(lab);

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
//		System.out.println(labName);
		
		if (as.searchlab(labName) == null) {
			Lab lab = new Lab();
			lab.setLabName(labName);
			lab.setLabPosition(labPosition);
			
			as.insertlab(lab);
		}
		else {
//			response.setHeader(arg0, arg1);
		}

	}
	
	@RequestMapping(value = "/updateLab", method = RequestMethod.GET)
	public void updateLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		String labName = request.getParameter("labName");
		String labPosition = request.getParameter("labPosition");
//		System.out.println(labName);
		
		
		Lab lab = new Lab();
		lab.setLabId(Integer.valueOf(labId));
		lab.setLabName(labName);
		lab.setLabPosition(labPosition);
		
		as.updatelab(lab);;

	}

	@RequestMapping(value = "/deleteLab", method = RequestMethod.GET)
	public void deleteLab(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
//		String labName = request.getParameter("labName");
//		String labPosition = request.getParameter("labPosition");
//		System.out.println(labName);
		
		
		Lab lab = new Lab();
		lab.setLabId(Integer.valueOf(labId));
//		lab.setLabName(labName);
//		lab.setLabPosition(labPosition);
		
		as.deletelab(lab);

	}
}
