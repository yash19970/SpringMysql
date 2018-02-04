package controller;

import model.daoimpl.ContactDaoImpl;
import model.entities.Contact;
import sun.misc.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by yashjain on 1/11/18.
 */
@WebServlet(name = "controller.HelloWorld",urlPatterns = "/Hello")
public class HelloWorld extends HttpServlet {
    private String message;
    public void init() throws ServletException {
        // Do required initialization
        message = "ContactBook";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Actual logic goes here.
        RequestDispatcher rd = null;
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String number = request.getParameter("number");

        ContactDaoImpl obj = new ContactDaoImpl();
        Contact cont = new Contact(12,name,number);
        obj.insert(cont);

        out.println("<h1>" + message + "</h1>");

        ContactDaoImpl obj2 = new ContactDaoImpl();
        List<Contact> contacts  = obj2.fetch();
        request.setAttribute("contactList",contacts);
        request.getRequestDispatcher("display.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        //out.println("<h1>" + message + "</h1>");
        out.println(request.getParameter("name"));
        out.println(request.getParameter("age"));

    }
}
