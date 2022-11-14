package kimwoojoong_mvcdb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kimwoojoong_mvcdb.domain.StudentDAO;
import kimwoojoong_mvcdb.domain.StudentVO;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String param = request.getParameter("cmd");
		
		if(param == null) return;
		
		StudentDAO dao = new StudentDAO();
		JSONArray arrayJson = new JSONArray();
		
		
		if(param.equals("list")) {
			List<StudentVO> voList = dao.getStudentList();
			try {
				for(StudentVO vo : voList ) {
					JSONObject json = new JSONObject();
					json.put("id", vo.getId()); json.put("passwd", vo.getPasswd()); 
					json.put("username", vo.getUsername()); json.put("snum", vo.getSnum()); 
					json.put("depart", vo.getDepart()); json.put("mobile", vo.getMobile()); 
					json.put("email", vo.getEmail()); 
					arrayJson.put(json);
				}
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
			out.println(arrayJson);
		}
		else if(param.equals("read")) {
			try {
				String id = request.getParameter("id");
				if(id == null) {
					out.print("계정을 확인하세오.");
				}
				StudentVO vo = dao.read(id);
				JSONObject json = new JSONObject();
				json.put("id", vo.getId()); json.put("passwd", vo.getPasswd()); 
				json.put("username", vo.getUsername()); json.put("snum", vo.getSnum()); 
				json.put("depart", vo.getDepart()); json.put("mobile", vo.getMobile()); 
				json.put("email", vo.getEmail());
				out.print(json);
				
			}catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
