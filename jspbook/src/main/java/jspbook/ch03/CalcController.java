package jspbook.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcController")
public class CalcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num1=0,num2=0, result=0;
		boolean ret = true;
		String op="";
		// 전달될 컨텐트에 대한 타잎 설정과 캐릿터셋 지정
		response.setContentType("text/html; charset=UTF-8");
		// 클라이언트 응답을 위한 출력 스트림 확보
		PrintWriter out = response.getWriter();
		// HTML 폼 num1, num2 값을 변수에 할당
		// getParameter() 메서드는 문자열을 리턴
		// 숫자 경우 Integer.parseInt()로 int 변환
		String strNum1 = request.getParameter("num1"); 
		String strNum2 = request.getParameter("num2");
		if(strNum1 == null || strNum1.equals("")) 
			ret = false;
		if(strNum2 == null || strNum2.equals("")) 
			ret = false;
		op = request.getParameter("operator");
		if(op != null && ret ) {
		// calc() 메서드 호출로 결과를 받아 온다.
			num1 = Integer.parseInt(strNum1);
			num2 = Integer.parseInt(strNum2);
			Calc calc = new Calc(num1, num2, op);
			result = calc.getResult();
		}
		// 출력 스트림을 통해 화면을 구성 한다.
		request.setAttribute("output", result);
		RequestDispatcher view = request.getRequestDispatcher("/ch03/result.jsp");
		view.forward(request, response);
	}

}
