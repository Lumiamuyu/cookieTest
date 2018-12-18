package Lumiamuyu.controller;


import Lumiamuyu.pojo.Product;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> lists = service.getLists();
        String lis = JSONObject.toJSONString(lists);
        System.out.println(lis);
        req.setAttribute("lists",lists);
        req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
    }
}
