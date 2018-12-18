package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type","text/html;charset=UTF-8");
        System.out.println(uname+"  "+pwd);
        User user = service.getOne(uname);
        if (user!=null){
            if (user.getPassword().equals(pwd)){
                resp.getWriter().write("1");
                /*长时间存储*/
                HttpSession session = req.getSession();
                Cookie cookieu = new Cookie("username",uname);
                Cookie cookiep = new Cookie("password",pwd);
                cookieu.setMaxAge(60*60*24*7);
                cookiep.setMaxAge(60*60*24*7);
                resp.addCookie(cookiep);
                resp.addCookie(cookieu);
                session.setAttribute("user",user);
                resp.sendRedirect("list");
            }else {
                resp.getWriter().write("3");
            }
        }else {
            resp.getWriter().write("2");
        }
    }
}
