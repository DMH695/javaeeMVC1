package servlet;

import dao.ProvinceDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class QueryProvinceName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求参数
        String strporid = req.getParameter("proid");
        String name ="";
        if(strporid != null && !strporid.trim().equals("")){
            ProvinceDao provinceDao = new ProvinceDao();
            name = provinceDao.queryProvinceName(Integer.valueOf(strporid));
        }
        //输出数据，响应ajax请求
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        //输出name
        out.println(name);
        //清空缓存
        out.flush();
        out.close();
    }
}
