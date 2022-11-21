package jspbook.ch09;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitialMember implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		//ServletContextListener.super.contextInitialized(sce);
		ServletContext context = sce.getServletContext();
		ArrayList<Member> datas = new ArrayList<>();
		
		for(int i = 0 ; i < 8 ; i++) {
			Member data = new Member("강호동"+i,"test"+i+"@tukorea.ac.kr");
			datas.add(data);
		}
		
		datas.add(new Member("홍길동", null));
		datas.add(new Member("김길동", null));
		
		context.setAttribute("members", datas);
		context.setAttribute("member",new Member());
	}
	
}
