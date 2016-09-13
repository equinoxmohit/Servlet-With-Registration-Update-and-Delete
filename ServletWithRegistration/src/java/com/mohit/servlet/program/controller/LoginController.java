/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.servlet.program.controller;

import com.mohit.servlet.program.User;
import com.mohit.servlet.program.dao.UserDAO;
import com.mohit.servlet.program.dao.impl.UserDAOImpl;
import com.mohit.servlet.program.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends Controller {

    
    private UserDAO uDao = new UserDAOImpl();
   

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            User user=uDao.login(username, finalPassword);
            if(user!=null)
            {
                response.sendRedirect(request.getContextPath()+"/admin?success");
            }else
            {
                response.sendRedirect(request.getContextPath()+"/?error");
            }
        } catch (NoSuchAlgorithmException | SQLException | ClassNotFoundException|NullPointerException ex) {
            PrintWriter out=response.getWriter();
            out.println(ex.getLocalizedMessage());
        }

    }

}
