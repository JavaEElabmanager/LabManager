package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import config.Listener;
import model.Administrator;
import service.AdministratorService;
import tools.Tools;

@Controller
public class LoginController {
	static AdministratorService as = (AdministratorService)Listener.applicationContext.getBean("administratorservice");
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void handleRequest(HttpServletRequest request, HttpServletResponse respond) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Administrator admin = as.searchadministrator(username);
		if(admin != null && password.equals(admin.getAdminPwd())) {
			HttpSession session = request.getSession();
            session.setAttribute("username", username);
            /*sessionÎ´Íê³É*/
		}
		else {
			respond.setStatus(221);
//			System.out.println("else");
		}
	}
}
