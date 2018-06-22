package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("in");
		String url = request.getRequestURI();
//		System.out.println(url);
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
//		System.out.println("username" + username);
		if(url.indexOf("/login")>=0) {
			return true;
		}
		if(username != null && username.length() != 0) {
			System.out.println("success");
			return true;
		}
//		System.out.println(request.getContextPath());
		response.setStatus(230);
//		System.out.println("×´Ì¬Âë·µ»Ø");
		return false;
	}

}
