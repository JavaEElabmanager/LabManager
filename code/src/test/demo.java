package test;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.regexp.internal.recompile;

import antlr.ASdebug.ASDebugStream;
import model.Administrator;
import service.AdministratorService;

public class demo {

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		 //Spring������,����Spring�����ļ�
		//System.out.println("here");
//       ApplicationContext context = new ClassPathXmlApplicationContext(
//               "config/applicationContext.xml");
       // ��ȡһ��ҵ�������Ķ���
//       AdministratorService us =(AdministratorService) context.getBean("administratorservice");
//       Administrator test = new Administrator();
//       test.setAdminId(2);
//       test.setAdminName("cwj");
//       test.setAdminPwd("cwj");
////       us.insertadministrator(test);
//       
//       test = us.searchadministrator("admin");
       System.out.println(new Timestamp(System.currentTimeMillis()));
      // System.out.println(us.loadalladministrator());
       // ���õ�¼����
//       administrator temp = new administrator();
//       temp.setAdminId(1);
//       temp.setAdminName("cwj");
//       temp.setAdminPwd("1234567");
//       us.deleteadministrator(temp);
       	 //System.out.println(us.loadalladministrator());

	}

}
