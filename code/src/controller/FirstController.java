package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import config.Listener;
import model.Administrator;
import service.AdministratorService;


@Controller
//@RequestMapping("/hello")
public class FirstController  {
	AdministratorService as = (AdministratorService)Listener.applicationContext.getBean("administratorservice");
	
	@RequestMapping(value = "/logintest", method = RequestMethod.POST)
	public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//	            "lab/xml/applicationContext.xml");
//	    administratorservice as =(administratorservice) context.getBean("administratorservice");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String JSONString = getRequestJsonString(req);
		System.out.println(req);
		System.out.println(JSONString);

//		JSONObject jsonObject = new JSONObject(req);
		
//		String password = jsonObject.getString("password");
		
		System.out.println();
		System.out.println(as);
		Administrator admin = as.searchadministrator("admin");
		System.out.println(admin.getAdminPwd());
//		administrator admin = new administrator();
//		admin.setAdminName("admin");
//		admin.setAdminPwd("admin");
		
		if(admin != null && password.equals(admin.getAdminPwd())) {
			return "/managelab.html";
		}
		else {
			renderData(resp, "error");
			return null;
		}
//		System.out.println(req.getParameter("name"));
//	    String jsonResult = getRequestJsonString(req);
//	    System.out.println(jsonResult);
	    
//	    renderData(resp, jsonResult);
//		PrintWriter printWriter = resp.getWriter();
//		printWriter.print("test");
	}
	
//	private String getJSONString(HttpServletRequest request) {
//	    //故意构造一个数组，使返回的数据为json数组，数据更复杂些
//	    List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>(5);
//	    Map<String, Object> map1 = new HashMap<String, Object>(10);
//	    //可以获得ajax请求中的参数
//	    System.out.println(request.getAttribute("username"));
//	    map1.put("istrue", "1");
//	    map1.put("password", "2");
////	    map1.put("c", request.getParameter("c"));
//	    datas.add(map1);
//	    //故意构造一个数组，使返回的数据为json数组，数据更复杂些
//	    Map<String, Object> map2 = new HashMap<String, Object>(10);
//	    map2.put("a", "11");
//	    map2.put("b", "22");
//	    map2.put("c", "33");
//	    datas.add(map2);
//	    String jsonResult = JSON.toJSONString(datas);
//	    return jsonResult;
//	  }

	  /**
	   * 通过PrintWriter将响应数据写入response，ajax可以接受到这个数据
	   * 
	   * @param response
	   * @param data 
	   */
	  private void renderData(HttpServletResponse response, String data) {
	    PrintWriter printWriter = null;
	    try {
	      printWriter = response.getWriter();
	      printWriter.print(data);
	    } catch (IOException ex) {
	      Logger.getLogger(FirstController.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	      if (null != printWriter) {
	        printWriter.flush();
	        printWriter.close();
	      }
	    }
	  }
	  
	  public String JsonReq(HttpServletRequest request) {  
		    BufferedReader br;  
		    StringBuilder sb = null;  
		    String reqBody = null;  
		    try {  
		        br = new BufferedReader(new InputStreamReader(  
		                request.getInputStream()));  
		        String line = null;  
		        sb = new StringBuilder();  
		        while ((line = br.readLine()) != null) {  
		            sb.append(line);  
		        }  
		        reqBody = URLDecoder.decode(sb.toString(), "UTF-8");  
//		        reqBody = reqBody.substring(reqBody.indexOf("{"));  
		        request.setAttribute("inputParam", reqBody);  
		        System.out.println("JsonReq reqBody>>>>>" + reqBody);  
		        return reqBody;  
		    } catch (IOException e) {  
		        // TODO Auto-generated catch block  
		        e.printStackTrace();  
		        return "jsonerror";  
		    }  
		}
	  
	  public static String getRequestJsonString(HttpServletRequest request)  
	            throws IOException {
	        String submitMehtod = request.getMethod();  
	        // GET  
	        if (submitMehtod.equals("GET")) {  
	            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");  
	        // POST  
	        } else {  
	            return getRequestPostStr(request);  
	        }  
	    }  
	  
	    /**       
	     * 描述:获取 post 请求的 byte[] 数组 
	     * <pre> 
	     * 举例： 
	     * </pre> 
	     * @param request 
	     * @return 
	     * @throws IOException       
	     */  
	    public static byte[] getRequestPostBytes(HttpServletRequest request)  
	            throws IOException {  
	        int contentLength = request.getContentLength();  
	        if(contentLength<0){  
	            return null;  
	        }  
	        byte buffer[] = new byte[contentLength];  
	        for (int i = 0; i < contentLength;) {  
	  
	            int readlen = request.getInputStream().read(buffer, i,  
	                    contentLength - i);  
	            if (readlen == -1) {  
	                break;  
	            }  
	            i += readlen;  
	        }  
	        return buffer;  
	    }  
	  
	    /**       
	     * 描述:获取 post 请求内容 
	     * <pre> 
	     * 举例： 
	     * </pre> 
	     * @param request 
	     * @return 
	     * @throws IOException       
	     */  
	    public static String getRequestPostStr(HttpServletRequest request)  
	            throws IOException {  
	        byte buffer[] = getRequestPostBytes(request);  
	        String charEncoding = request.getCharacterEncoding();  
	        if (charEncoding == null) {  
	            charEncoding = "UTF-8";  
	        }  
	        return new String(buffer, charEncoding);  
	    } 

}
