package servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MysqlUtil;

import java.io.IOException;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
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
		
		String sqlInsert = "INSERT  INTO Person (Pno,Pname,Psex,Page,Pheight,Pweight) VALUES('";
		sqlInsert += pno +"','";
		sqlInsert += name +"','";
		sqlInsert += sex +"',";
		sqlInsert += age +",";
		sqlInsert += height +",";
		sqlInsert += weight +")";
		
		int message = MysqlUtil.add(sqlInsert);
		String rep = "";
		if(message == 1) {
			rep = "{\"code\":200,\"message\":\"成功插入数据库\"}";
		}else {
			rep = "{\"code\":\"999\",\"message\":\"插入失败了\"}";
		}
		response.getWriter().write(rep);
		
		
	}

}
