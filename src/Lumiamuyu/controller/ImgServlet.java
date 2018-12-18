package Lumiamuyu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/imgtest.jsp").forward(req,resp);
        Part part = req.getPart("url");
        String str = "C:\\Users\\Lumia\\IdeaProjects\\cookieTest\\web\\WEB-INF\\img\\"+part.getSubmittedFileName();
        String url = str.substring(str.indexOf("img"));
        File file = new File(str);
        System.out.println(url);
        InputStream inputStream = req.getInputStream();
        OutputStream outputStream = new FileOutputStream(file);
        byte[] b = new byte[1024];
        int r = inputStream.read(b,0,b.length);
        while (r!=-1){
            outputStream.write(b);
            r = inputStream.read(b,0,b.length);
        }
        req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req,resp);

    }
}
