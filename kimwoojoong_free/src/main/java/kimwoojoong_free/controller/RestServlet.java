package kimwoojoong_free.controller;

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

import kimwoojoong_free.domain.Member;
import kimwoojoong_free.service.FitnessService;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FitnessService service = new FitnessService();
       
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String param = request.getParameter("cmd");
		
		if(param == null) return;
		
		
		JSONArray arrayJson = new JSONArray();
		
		
		if(param.equals("list")) {
			List<Member> voList = service.getAllMembers();
			try {
				for(Member vo : voList ) {
					JSONObject json = new JSONObject();
					json.put("id", vo.getId()); json.put("passwd", vo.getPasswd()); 
					json.put("uname", vo.getUname()); json.put("age", vo.getAge()); 
					json.put("sex", vo.getSex()); json.put("tell", vo.getTell()); 
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
				Member vo = service.getMemberInfo(id);
				JSONObject json = new JSONObject();
				json.put("id", vo.getId()); json.put("passwd", vo.getPasswd()); 
				json.put("uname", vo.getUname()); json.put("age", vo.getAge()); 
				json.put("sex", vo.getSex()); json.put("tell", vo.getTell()); 
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
		doGet(request, response);
	}

}
