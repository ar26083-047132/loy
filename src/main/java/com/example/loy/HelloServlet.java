package com.example.loy;

import java.io.*;
import java.nio.file.FileStore;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        Integer num = (Integer) session.getAttribute("sessDate");

        if (num == null){
            session.setAttribute("sessDate", 1);
            num = 1;
        }else{
            session.setAttribute("sessDate", ++num);
        }

        // Hello
        PrintWriter out = response.getWriter();
        int a = 2, b = 8;
        out.println("<html><body>");
        out.println("<h1> swich(a, b) </h1>");
        out.print("a = " + a + " b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        out.println("<h1>" + message + "</h1>");
        out.print("a = " + a + " b = " + b);
        out.print("<h1> number of pageupdate: " + num + "</h1>");
        out.println("</body></html>");


    }

    public void destroy() {
    }
}