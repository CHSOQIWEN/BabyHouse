package com.bittch.servlet;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="loginservlet",urlPatterns = "/loginservlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer=resp.getWriter();
        writer.append("<html>")
                .append("<head><title></title></head>")
                .append("<form action='' method='post'>")//对应doget或者dopost
                .append("username=<input name='username' type='text' /></br>")
                .append("password:<input name='password' type='password'/></br>")
                .append("<input type='submit' value='Submit'>")
                .append("<input type ='reset' value='Reset'>")
                .append("</form>")
                .append("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
