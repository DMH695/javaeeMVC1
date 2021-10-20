package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MysqlUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class HelloQuery
 */
@WebServlet("/HelloQuery")
public class HelloQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		//设置请求以及响应的内容类型以及编码方式
		response.setContentType("application/json; charset=utf-8");
		String pno = request.getParameter("pno");
		String[] params = {"Pno","Pname","Psex","Page","Pheight","Pweight"};
		String sql = "select * from Person where Pno="+pno;
		String data = "{";
		
		String[] str = {"编号","姓名","性别","年龄","身高","体重"};
		List<Map<String,String>> listmap = new ArrayList<>();
		listmap = MysqlUtil.show(sql, params);
		for(int i =0 ; i<listmap.size();i++) {			
			for(int j=0 ; j<listmap.get(i).size();j++) {
				data += "\""+str[j]+"\":"+"\""+listmap.get(i).get(params[j])+"\",";			
			}
		}
		data = data.substring(0, data.length()-1);
		data += "}";
		
		
		System.out.println(data);
		response.getWriter().write(data);
	}
	
	

}
