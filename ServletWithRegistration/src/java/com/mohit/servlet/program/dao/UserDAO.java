/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.servlet.program.dao;

import com.mohit.servlet.program.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mohit
 */
public interface UserDAO {

    int insert(User user) throws SQLException, ClassNotFoundException;

    List<User> getAll() throws SQLException, ClassNotFoundException;

    User login(String username, String password) throws SQLException, ClassNotFoundException;

    User getById(int id) throws SQLException, ClassNotFoundException;

    int update(User user) throws SQLException, ClassNotFoundException;
    
    int delete(int id) throws SQLException,ClassNotFoundException;
}
