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

@WebServlet("/doIt")
public class DoServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("unames");
        String pwd = req.getParameter("pwd");
        String pwds = req.getParameter("pwds");
        String tele = req.getParameter("tele");
        User u = new User();
        u.setUsername(uname);
        u.setPassword(pwd);
        u.setTelephone(tele);
        int result = service.insert(u);
        if (result>0){
            resp.getWriter().write("1");
        }else {
            resp.getWriter().write("0");
        }
    }
}
