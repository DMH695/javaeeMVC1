package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.MysqlUtil;

import java.io.IOException;

/**
 * Servlet implementation class HelloDelete
 */
@WebServlet("/HelloDelete")
public class HelloDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloDelete() {
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
		
		
		String sqlDel = "delete from Person where pno="+pno;
		
		
		int message = MysqlUtil.del(sqlDel);
		String rep = "";
		if(message == 1) {
			rep = "{\"code\":\"200\",\"message\":\"删除成功\"}";
		}else {
			rep = "{\"code\":\"999\",\"message\":\"删除失败\"}";
		}
		response.getWriter().write(rep);
	}

}
