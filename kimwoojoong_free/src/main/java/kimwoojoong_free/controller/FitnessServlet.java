package kimwoojoong_free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kimwoojoong_free.domain.Member;
import kimwoojoong_free.service.FitnessService;
/**
 * Servlet implementation class FitnessServlet
 */
@WebServlet("/FitnessServlet")
public class FitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FitnessService service = new FitnessService();
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FitnessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param = "";
		String login = "";
		String id="";
		session = request.getSession();
		try {
			param = request.getParameter("cmd");
			login = request.getParameter("login");
			id = request.getParameter("id");
			if(param.equals("main")) {
				if(login.equals("true")) {
					RequestDispatcher view = request.getRequestDispatcher("loginedmain.jsp");
					view.forward(request, response);
				}
				if(login.equals("false")) {
					RequestDispatcher view = request.getRequestDispatcher("mainpage.html");
					view.forward(request, response);
				}
			}
			if(param.equals("trainers")) {
				session.setAttribute("trainers", service.getAllTrainers());
				RequestDispatcher view = request.getRequestDispatcher("trainers.jsp");
				view.forward(request, response);
			}
			if(param.equals("register")) {
				session.setAttribute("trainers", service.getAllTrainers());	// 세션에 트레이너 리스트 바인딩
				RequestDispatcher view = request.getRequestDispatcher("register.jsp");
				view.forward(request, response);
			}
			if(param.equals("mypage")) {
				RequestDispatcher view = request.getRequestDispatcher("mypage.jsp"); 
				view.forward(request, response);
			}
			if(param.equals("update")) {
				session.setAttribute("trainers", service.getAllTrainers());
				RequestDispatcher view = request.getRequestDispatcher("update.jsp");
				view.forward(request, response);
			}
			if(param.equals("delete")) {
				service.deleteMember(id);
				RequestDispatcher view = request.getRequestDispatcher("mainpage.html");
				view.forward(request, response);
			}
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		session = request.getSession();
		
		String param = "";
		String id = "";
		String pw = "";
		try {
			param = request.getParameter("cmd");
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			
			if(param.equals("join")) {
				Member member = new Member();
				
				member.setId(request.getParameter("id"));
				member.setPasswd(request.getParameter("passwd"));
				member.setUname(request.getParameter("uname"));
				member.setAge(Integer.parseInt(request.getParameter("age")));
				member.setSex(request.getParameter("sex"));
				member.setAddress(request.getParameter("address"));
				member.setTell(request.getParameter("tell"));
				member.setTname(request.getParameter("trainer"));
				
				service.signUp(member);
				
				session.setAttribute("member", member);
				
				RequestDispatcher view = request.getRequestDispatcher("loginedmain.jsp");
				view.forward(request, response);
			}
			else if(param.equals("update")) {
				Member member = new Member();
				
				member.setId(request.getParameter("id"));
				member.setPasswd(request.getParameter("passwd"));
				member.setUname(request.getParameter("uname"));
				member.setAge(Integer.parseInt(request.getParameter("age")));
				member.setSex(request.getParameter("sex"));
				member.setAddress(request.getParameter("address"));
				member.setTell(request.getParameter("tell"));
				member.setTname(request.getParameter("trainer"));
				
				service.updateMember(member);
				
				request.setAttribute("member", service.getMemberInfo(request.getParameter("id")));
				
				RequestDispatcher view = request.getRequestDispatcher("mainpage.html");
				view.forward(request, response);
			}
			else if(param.equals("login")) {
				
				if(service.login(id, pw)) {
					session.setAttribute("member", service.getMemberInfo(id));
					RequestDispatcher view = request.getRequestDispatcher("loginedmain.jsp");
					view.forward(request, response);
				}
				else {
					RequestDispatcher view = request.getRequestDispatcher("mainpage.html");
					view.forward(request, response);
				}
				
				
			}
		} catch (Exception e) {}
	}

}
