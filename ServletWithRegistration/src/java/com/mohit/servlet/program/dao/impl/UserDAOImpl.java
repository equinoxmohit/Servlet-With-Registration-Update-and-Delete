/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.servlet.program.dao.impl;

import com.mohit.servlet.program.User;
import com.mohit.servlet.program.connection.DbConnection;
import com.mohit.servlet.program.dao.UserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohit
 */
public class UserDAOImpl implements UserDAO {

    private DbConnection conn = new DbConnection();
    private List<User> userList = new ArrayList<>();

    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_user(first_name,last_name,username,email,password)" + "VALUES(?,?,?,?,?)";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setString(1, user.getFirstName());
        stmnt.setString(2, user.getLastName());
        stmnt.setString(3, user.getUsername());
        stmnt.setString(4, user.getEmail());
        stmnt.setString(5, user.getPassword());
        int result = conn.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_user";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        ResultSet rs = conn.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("user_id"));
            u.setFirstName(rs.getString("first_name"));
            u.setLastName(rs.getString("last_name"));
            u.setUsername(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            userList.add(u);
        }
        conn.close();
        return userList;
    }

    @Override
    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        for (User u : getAll()) {
            if ((u.getUsername().equals(username)) && (u.getPassword().equals(password))) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getById(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        String sql = "SELECT * FROM tbl_user";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        ResultSet rs = conn.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        conn.close();
        return user;

    }

    @Override
    public int update(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tbl_user SET first_name=?,last_name=?,username=?,email=? WHERE user_id=?";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setString(1, user.getFirstName());
        stmnt.setString(2, user.getLastName());
        stmnt.setString(3, user.getUsername());
        stmnt.setString(4, user.getEmail());
        stmnt.setInt(5, user.getId());
        int result = conn.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM  tbl_user WHERE id=?";
        conn.open();
        PreparedStatement stmnt = conn.initStatement(sql);
        stmnt.setInt(1, id);
        int result = conn.executeUpdate();
        conn.close();
        return result;
    }

}
