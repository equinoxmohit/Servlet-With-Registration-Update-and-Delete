/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.servlet.program.connection;

import com.mohit.servlet.program.connection.constant.DbConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mohit
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmnt = null;

    public void open() throws ClassNotFoundException, SQLException {
        Class.forName(DbConstant.DB_CLASSNAME);
        conn = DriverManager.getConnection(DbConstant.DB_URL, DbConstant.DB_USERNAME, DbConstant.DB_PASSWORD);
    }

    public PreparedStatement initStatement(String sql) throws SQLException {
        stmnt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        return stmnt;
    }

    public int executeUpdate() throws SQLException {
        return stmnt.executeUpdate();
    }

    public ResultSet executeQuery() throws SQLException {
        return stmnt.executeQuery();
    }

    public void close() throws SQLException {
        if (conn != null || !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

}
