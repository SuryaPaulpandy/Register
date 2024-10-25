package com.da.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.da.model.Register;

public class RegisterForm extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String emailid = request.getParameter("emailid");
        String mobilenumber = request.getParameter("mobilenumber");

        Register register = new Register(name, address, emailid, mobilenumber);
        int rows = register.save(); // Save to database and get the result

        HttpSession session = request.getSession();
        if (rows == 1) {
            session.setAttribute("name", name);
            session.setAttribute("address", address);
            session.setAttribute("emailid", emailid);
            session.setAttribute("mobilenumber", mobilenumber);
            response.sendRedirect("registerSuccess.jsp");
        } else {
            response.sendRedirect("registerFailure.jsp");
        }
    }
}
