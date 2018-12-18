package Lumiamuyu.controller;

import Lumiamuyu.utilTest.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Map<String,Cookie> maps = CookiesUtil.getCookie(cookies);
        Cookie i =  maps.get("username");
        i.setValue("");
        i.setMaxAge(0);
        resp.addCookie(i);
        HttpSession session = req.getSession();
        /*session失效*/
        session.invalidate();
        resp.sendRedirect("login");
    }
}
