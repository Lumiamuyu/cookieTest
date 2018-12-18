package Lumiamuyu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getSession(true);





        Cookie cookie = new Cookie("username","中文");
        cookie.setMaxAge(60*60*24*7);
        /*修改过后记得添加方法*/
        resp.addCookie(cookie);
        req.getRequestDispatcher("ckTest.jsp").forward(req,resp);
    }
}
