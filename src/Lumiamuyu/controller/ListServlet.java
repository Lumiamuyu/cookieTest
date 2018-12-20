package Lumiamuyu.controller;


import Lumiamuyu.pojo.Product;
import Lumiamuyu.pojo.ResultData;
import Lumiamuyu.pojo.User;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.IUserService;
import Lumiamuyu.service.ProductServiceImpl;
import Lumiamuyu.service.UserServiceImpl;
import Lumiamuyu.utilTest.CookiesUtil;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    private IUserService uService = new UserServiceImpl();

/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> lists = service.getLists();
        req.setAttribute("lists", lists);
        req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
    }
*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = req.getParameter("pageNo")==null?1:Integer.parseInt(req.getParameter("pageNo"));
        int pageSize = 5;
        ResultData data = service.getLists(pageNo,pageSize);
        data.setUrl("list");
        req.setAttribute("data",data);

        /*List<Product> lists = service.getLists();*/
        HttpSession session = req.getSession();
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");

        Cookie[] cookies = req.getCookies();
        CookiesUtil.getCookie(cookies);
        Map<String, Cookie> maps = CookiesUtil.getCookie(cookies);
        Cookie coo = maps.get("username");
        String uname = coo.getValue();
        User u =  (User)session.getAttribute("user");
        /*String lis = JSONObject.toJSONString(lists);*/
        /*System.out.println(lis);*/
        /*req.setAttribute("lists", lists);*/
        if (u==null){
            User user = uService.getOne(uname);
            session.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String text =req.getParameter("text");
        text="%"+text+"%";
        if (text==""){
            List<Product> lists = service.getLists();
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }else{
            List<Product> lists = service.getResult(text);
            req.setAttribute("lists", lists);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req, resp);
        }
    }
}
