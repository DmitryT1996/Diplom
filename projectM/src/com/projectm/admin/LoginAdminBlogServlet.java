package com.projectm.admin;

import com.projectm.db.Admin;
import com.projectm.db.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginAdminBlogServlet", urlPatterns = {"/loginAdminBlogServlet"})
public class LoginAdminBlogServlet extends HttpServlet {

    private static final String URL = "jdbc:mariadb://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "magentam";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection connection;
        PreparedStatement ps;
        ResultSet rs;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = connection.prepareStatement("SELECT id, name, email from Admin where email=? AND password=? limit 1");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if(rs != null && rs.next()) {
                Admin admin = new Admin(rs.getString("name"), rs.getString("email"), rs.getInt("id"));
                HttpSession session = request.getSession();
                session.setAttribute("Admin", admin);
                response.sendRedirect("blogAdmin.jsp");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
/*            finally {
                try {
                    rs.close();
                    ps.close();
                    connection.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
