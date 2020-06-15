package com.cice.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "jdbc:oracle:oci:@localhost:1521:OEDB";
        //String user = "OE";
        //String pass = "OE";
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        System.out.println("user-->" + user);
        System.out.println("password-->" + password);


        Connection conn = null;
        PreparedStatement pst = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement("insert into customers (customer_id, cust_first_name, cust_last_name) VALUES (2,'CHOCHI','ROCHI')");
            pst.execute();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
