package Lumiamuyu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/getCookie")
public class GetCookie extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie i:cookies
             ) {
            System.out.println(i.getName());
            System.out.println(i.getValue());
        }
        HttpSession session = req.getSession();
        /*定义停留时间*/
        session.setMaxInactiveInterval(20);
        System.out.println(session.getId());
    }
}
