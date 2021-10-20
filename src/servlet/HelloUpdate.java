package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MysqlUtil;

import java.io.IOException;

/**
 * Servlet implementation class HelloUpdate
 */
@WebServlet("/HelloUpdate")
public class HelloUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloUpdate() {
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
		response.setContentType("application/json; charset=utf-8");
		
		String pno = request.getParameter("pno");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		String sqlupdate = "update Person set ";
//		sqlupdate += "Pno='"+ pno +"',";
		sqlupdate += "Pname='"+ name +"',";
		sqlupdate += "Psex='"+ sex +"',";
		sqlupdate += "Page="+ age +",";
		sqlupdate += "Pheight="+ height +",";
		sqlupdate += "Pweight="+ weight;
		sqlupdate += " where Pno='"+pno+"'";
		System.out.println(sqlupdate);
		int message = MysqlUtil.update(sqlupdate);
		String rep = "";
		if(message == 1) {
			rep = "{\"code\":\"200\",\"message\":\"更新成功\"}";
		}else {
			rep = "{\"code\":\"999\",\"message\":\"更新失败\"}";
		}
		response.getWriter().write(rep);
		
	}

}
