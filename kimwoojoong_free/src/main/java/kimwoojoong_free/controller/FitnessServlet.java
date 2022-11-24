package kimwoojoong_free.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kimwoojoong_free.domain.Member;
import kimwoojoong_free.service.FitnessService;
/**
 * Servlet implementation class FitnessServlet
 */
@WebServlet("/FitnessServlet")
public class FitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FitnessService service = new FitnessService();
       
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
		try {
			param = request.getParameter("cmd");
			login = request.getParameter("login");
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
			if(param.equals("signin")) {
				RequestDispatcher view = request.getRequestDispatcher("login.jsp");
				view.forward(request, response);
			}
			if(param.equals("mypage")) {
				RequestDispatcher view = request.getRequestDispatcher("mypage.jsp");
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
		
		String param = "";
		String message = "";
		String id = "";
		String pw = "";
		try {
			param = request.getParameter("cmd");
			if(param.equals("join")) {
				Member member = new Member();
				
				member.setId(request.getParameter("id"));
				member.setPasswd(request.getParameter("passwd"));
				member.setUname(request.getParameter("uname"));
				member.setAge(Integer.parseInt(request.getParameter("age")));
				member.setSex(request.getParameter("sex"));
				member.setAddress(request.getParameter("address"));
				member.setTell(request.getParameter("tell"));
				member.setTrainer(Integer.parseInt(request.getParameter("trainer")));
				
				
				if(service.signUp(member)) message = "가입 축하합니다.";
				else message = "가입 실패입니다.";
				
				request.setAttribute("greetings", message);
				request.setAttribute("member", member);
				
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
				member.setTrainer(Integer.parseInt(request.getParameter("trainer")));
				
				if(service.updateMember(member)) message = "수정이 완료되었습니다.";
				else message = "수정 실패입니다.";
				
				request.setAttribute("greetings", message);
				request.setAttribute("member", member);
				
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			}
			else if(param.equals("login")) {
				id = request.getParameter("id");
				pw = request.getParameter("pw");
				
				if(service.login(id, pw)) {
					request.setAttribute("member", service.getMemberInfo(id));
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
