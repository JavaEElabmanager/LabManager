package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import config.Listener;
import model.Computer;
import service.ComputerService;
import tools.Tools;

@Controller
public class ComputerController {
	static ComputerService cs = (ComputerService)Listener.applicationContext.getBean("computerservice");
	
	@RequestMapping(value = "/loadComputersByLabId", method = RequestMethod.GET)
	public void loadComputersByLabId(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		
		List<Computer> computers = cs.searchComputerByLabId(Integer.valueOf(labId));
		
		if (!computers.isEmpty()) {
			Gson gson = new Gson();
			String Json = gson.toJson(computers);
			
			System.out.println(Json);
			
			Tools.renderData(response, Json);
		}

	}
	
	@RequestMapping(value = "/addComputer", method = RequestMethod.GET)
	public void addComputer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		String computerPosition = request.getParameter("computerPosition");
		String computerIp = request.getParameter("computerIp");
		
		
		if (cs.searchComputerByPosition(Integer.valueOf(computerPosition)) == null) {
			Computer computer = new Computer();
			computer.setComputerIp(computerIp);
			computer.setComputerPosition(Integer.valueOf(computerPosition));
			computer.setLabId(Integer.valueOf(labId));
			computer.setisUsing(false);
			
			cs.insertcomputer(computer);
		}
		else {
			response.setStatus(221);
//			response.setHeader(arg0, arg1);
		}
		
	}
	
	@RequestMapping(value = "/deleteComputer", method = RequestMethod.GET)
	public void deleteComputer(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String labId = request.getParameter("labId");
		String computerId = request.getParameter("computerId");
//		String computerIp = request.getParameter("computerIp");
		
		
		Computer computer = new Computer();
//		computer.setComputerIp(computerIp);
		computer.setComputerId(Integer.valueOf(computerId));
//		computer.setLabId(Integer.valueOf(labId));
//		computer.setisUsing(false);

		cs.deletecomputer(computer);
	}
	
	@RequestMapping(value = "/updateComputer", method = RequestMethod.GET)
	public void updateComputer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		String computerId = request.getParameter("computerId");
		String computerPosition = request.getParameter("computerPosition");
		String computerIp = request.getParameter("computerIp");
		
		
		Computer computer = cs.searchComputerById(Integer.valueOf(computerId));
		computer.setComputerIp(computerIp);
		computer.setComputerPosition(Integer.valueOf(computerPosition));
		computer.setLabId(Integer.valueOf(labId));
//		computer.setisUsing(false);

		cs.updatecomputer(computer);
	}
}
