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
		
		
		if (cs.searchComputerByPosition(Integer.valueOf(labId), Integer.valueOf(computerPosition)) == null) {
			if (cs.searchComputerByIp(computerIp) == null) {
				Computer computer = new Computer();
				computer.setComputerIp(computerIp);
				computer.setComputerPosition(Integer.valueOf(computerPosition));
				computer.setLabId(Integer.valueOf(labId));
				computer.setisUsing(false);
				
				cs.insertcomputer(computer);
			}
			else {
				response.setStatus(222);
			}
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
		Computer computer = (Computer)cs.searchComputerById(Integer.valueOf(computerId));
		if (!computer.getisUsing()) {
			cs.deletecomputer(computer);
		}
		else {
			response.setStatus(224);
		}
//		Computer computer = new Computer();
//		computer.setComputerIp(computerIp);
//		computer.setComputerId(Integer.valueOf(computerId));
//		computer.setLabId(Integer.valueOf(labId));
//		computer.setisUsing(false);


	}
	
	@RequestMapping(value = "/updateComputer", method = RequestMethod.GET)
	public void updateComputer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String labId = request.getParameter("labId");
		String computerId = request.getParameter("computerId");
		String computerPosition = request.getParameter("computerPosition");
		String computerIp = request.getParameter("computerIp");
		
//		if (cs.searchComputerByPositionAndLabId(Integer.valueOf(computerPosition), Integer.valueOf(labId), computerIp) == null) {
		try {
			Computer oldcomputer = cs.searchComputerById(Integer.valueOf(computerId));
			Computer computer = new Computer(oldcomputer.getComputerId(), oldcomputer.getComputerPosition(), oldcomputer.getLabId(), oldcomputer.getComputerIp(), oldcomputer.getisUsing());
			if (!computer.getisUsing()) {	
				computer.setComputerIp(computerIp);
				computer.setComputerPosition(Integer.valueOf(computerPosition));
				computer.setLabId(Integer.valueOf(labId));
				cs.updatecomputer(computer);
//					computer.setisUsing(false);

				if (cs.searchComputerByLabIdAndPosition(Integer.valueOf(labId), Integer.valueOf(computerPosition)).size() > 1) {
					cs.updatecomputer(oldcomputer);
					System.out.println(226);
					response.setStatus(226);
				}
			}
			else {
				response.setStatus(225);
			}
		
		}catch (Exception e) {
//			e.printStackTrace();	
			response.setStatus(222);
		}
//		}
//		else {
//			response.setStatus(222);
//		}

	}
}
