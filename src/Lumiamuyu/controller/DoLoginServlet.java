package Lumiamuyu.controller;

import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname+"  "+pwd);
        User user = service.getOne(uname);
        if (user!=null){
            if (user.getPassword().equals(pwd)){
                resp.getWriter().write("1");
            }else {
                resp.getWriter().write("3");
            }
        }else {
            resp.getWriter().write("2");
        }
    }
}
