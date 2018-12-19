package Lumiamuyu.controller;

import Lumiamuyu.pojo.Product;
import Lumiamuyu.service.IProductService;
import Lumiamuyu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/doAdd")
public class DoAddServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        /*req.getRequestDispatcher("WEB-INF/pages/imgtest.jsp").forward(req,resp);*/
        Part part = req.getPart("url");
        String str = "C:\\Users\\Lumia\\IdeaProjects\\cookieTest\\web\\img\\"+part.getSubmittedFileName();
        String url = str.substring(str.indexOf("img"));
        File file = new File(str);
        System.out.println(url);

        OutputStream outputStream = new FileOutputStream(file);

        byte[] b = new byte[1024];
        InputStream inputStream = part.getInputStream();
        int r = inputStream.read(b,0,b.length);
        while (r!=-1){
            outputStream.write(b);
            r = inputStream.read(b,0,b.length);
        }
        String name = req.getParameter("name");
        double price =Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");
        /*String url1 = req.getParameter("url");*/
        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);
        p.setUrl(url);
        p.setProductDes(des);
        service.add(p);
        resp.sendRedirect("list");
    }
}
