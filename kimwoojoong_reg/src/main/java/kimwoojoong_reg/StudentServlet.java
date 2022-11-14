package kimwoojoong_reg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kimwoojoong_reg.domain.StudentVO;
import kimwoojoong_reg.persistence.StudentDAO;


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
		//doPost(request, response);
		String cmdReq="";
		try {
			cmdReq = request.getParameter("cmd");
		
		
			if(cmdReq == null) {
				RequestDispatcher view = request.getRequestDispatcher("/welcome.html");
				view.forward(request, response);
			}
		
			if(cmdReq.equals("join")) {
				RequestDispatcher view = request.getRequestDispatcher("/register.html");
				view.forward(request, response);
			}
			else if(cmdReq.equals("mypage")) {
				RequestDispatcher view = request.getRequestDispatcher("/mypage.html");
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
		
		String cmdReq="";
		cmdReq = request.getParameter("cmd");
		
		if(cmdReq.equals("join")) {
			StudentVO studentVO = new StudentVO();
			
			studentVO.setId(request.getParameter("id"));
			studentVO.setPasswd(request.getParameter("passwd"));
			studentVO.setUsername(request.getParameter("username"));
			studentVO.setSnum(request.getParameter("snum"));
			studentVO.setDepart(request.getParameter("depart"));
			studentVO.setMobile(request.getParameter("mobile"));
			studentVO.setEmail(request.getParameter("email"));
			
			StudentDAO studentDAO = new StudentDAO();
			studentDAO.join(studentVO);
			
			request.setAttribute("id", studentVO.getId());
			request.setAttribute("username", studentVO.getUsername());
			request.setAttribute("snum", studentVO.getSnum());
			request.setAttribute("depart", studentVO.getDepart());
			request.setAttribute("mobile", studentVO.getMobile());
			request.setAttribute("email", studentVO.getEmail());
			
			RequestDispatcher view = request.getRequestDispatcher("/result.jsp");
			view.forward(request, response);
		}
	}

}
