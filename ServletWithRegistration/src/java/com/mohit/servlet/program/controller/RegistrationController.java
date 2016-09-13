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
@WebServlet(name = "register", urlPatterns = {"/"})
public class RegistrationController extends Controller {

    private UserDAO uDao = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/register/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes(), 0, password.length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(finalPassword);
            if (uDao.insert(user) > 0) {
                response.sendRedirect(request.getContextPath() + "/?success");
            } else {
                response.sendRedirect(request.getContextPath() + "/?error");
            }
        } catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
