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
@WebServlet(name = "update", urlPatterns = {"/update"})
public class UpdateController extends Controller {

    private UserDAO uDao = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") != null || !request.getParameter("id").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                User u = uDao.getById(id);

                request.setAttribute("user", u);

            } catch (SQLException | ClassNotFoundException ex) {
                PrintWriter out = response.getWriter();
                out.println(ex.getLocalizedMessage());
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/?error");
        }

        request.getRequestDispatcher("/WEB-INF/views/admin/update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        try {
            User u = new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            u.setUsername(username);
            u.setEmail(email);
            u.setId(Integer.parseInt(id));
            if (uDao.update(u) > 0) {
                response.sendRedirect(request.getContextPath() + "/admin?success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin?error");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            PrintWriter out = response.getWriter();
            out.println(ex.getLocalizedMessage());
        }

    }

}
