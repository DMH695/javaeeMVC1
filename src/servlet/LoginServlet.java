package servlet;

import dao.impl.UserDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");//设置request的字符集
        response.setContentType("text/html;charset=utf-8");//设置response的字符集

        //1.获取从前端页面中传过来的username和password值
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        //2.创建dao实现类的对象，调用检验登录的方法login().
        UserDaoImpl userDao = new UserDaoImpl();
        //数据库查到了即返回 true，没查到即返回 false
        boolean isSuccess = userDao.login(userName, passWord);

        if(isSuccess){
            //用于相应给客户，success为true --->登录成功
            request.getRequestDispatcher("/list.jsp").forward(request, response);
        }else{
            System.out.println("登录失败");
            response.sendRedirect("index.jsp");
        }
    }
}
