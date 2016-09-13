/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.servlet.program.controller;

import com.mohit.servlet.program.User;
import com.mohit.servlet.program.dao.UserDAO;
import com.mohit.servlet.program.dao.impl.UserDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohit
 */
@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class DeleteController {

    private final UserDAO uDao = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            if (uDao.delete(id) > 0) {
                response.sendRedirect(request.getContextPath() + "/admin?success");
            } else {
                response.sendRedirect(request.getContextPath() + "/admin?error");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            PrintWriter out = response.getWriter();
            out.println(ex.getLocalizedMessage());
        }

        request.getRequestDispatcher("/WEB-INF/views/admin/delete.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
