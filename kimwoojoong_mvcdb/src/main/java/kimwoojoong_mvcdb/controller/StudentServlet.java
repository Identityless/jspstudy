package kimwoojoong_mvcdb.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kimwoojoong_mvcdb.domain.StudentDAO;
import kimwoojoong_mvcdb.domain.StudentVO;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String param = "";
		try {
			param = request.getParameter("cmd");
			
			if(param == null) {
				RequestDispatcher view = request.getRequestDispatcher("welcome.html");
				view.forward(request, response);
			}
		
			if(param.equals("join")) {
				RequestDispatcher view = request.getRequestDispatcher("register.html");
				view.forward(request, response);
			}
			else if(param.equals("list")) {
				StudentDAO dao = new StudentDAO();
				ArrayList<StudentVO> studentList = dao.getStudentList();
				request.setAttribute("studentList", studentList);
				RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
				view.forward(request, response);
			}
			else if(param.equals("update")) {
				StudentDAO dao = new StudentDAO();
				StudentVO student = dao.read(request.getParameter("id"));
				request.setAttribute("student", student);
				RequestDispatcher view = request.getRequestDispatcher("update.jsp");
				view.forward(request, response);
			}
			else if(param.equals("delete")) {
				StudentDAO dao = new StudentDAO();
				String id = request.getParameter("id");
				dao.delete(id);
				
				ArrayList<StudentVO> studentList = dao.getStudentList();
				request.setAttribute("studentList", studentList);
				RequestDispatcher view = request.getRequestDispatcher("student_list.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String param = "";
		String message = "";
		try {
			param = request.getParameter("cmd");
			if(param.equals("join")) {
				StudentVO studentVO = new StudentVO();
				
				studentVO.setId(request.getParameter("id"));
				studentVO.setPasswd(request.getParameter("passwd"));
				studentVO.setUsername(request.getParameter("username"));
				studentVO.setSnum(request.getParameter("snum"));
				studentVO.setDepart(request.getParameter("depart"));
				studentVO.setMobile(request.getParameter("mobile"));
				studentVO.setEmail(request.getParameter("email"));
				
				StudentDAO studentDAO = new StudentDAO();
				
				if(studentDAO.add(studentVO)) message = "가입 축하합니다.";
				else message = "가입 실패입니다.";
				
				request.setAttribute("greetings", message);
				request.setAttribute("student", studentVO);
				
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			}
			else if(param.equals("update")) {
				StudentVO vo = new StudentVO();
				vo.setId(request.getParameter("id"));
				vo.setPasswd(request.getParameter("passwd"));
				vo.setUsername(request.getParameter("username"));
				vo.setSnum(request.getParameter("snum"));
				vo.setDepart(request.getParameter("depart"));
				vo.setMobile(request.getParameter("mobile"));
				vo.setEmail(request.getParameter("email"));
				
				StudentDAO dao = new StudentDAO();
				
				if(dao.update(vo)) message = "수정이 완료되었습니다.";
				else message = "수정 실패입니다.";
				
				request.setAttribute("greetings", message);
				request.setAttribute("student", vo);
				
				RequestDispatcher view = request.getRequestDispatcher("result.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {}
	}

}
