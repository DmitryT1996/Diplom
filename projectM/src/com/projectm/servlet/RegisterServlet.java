package com.projectm.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by max on 2/8/17.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/registerServlet"})
public class RegisterServlet extends HttpServlet {

    private static final String URL = "jdbc:mariadb://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "magentam";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMsg = null;

        PrintWriter out = response.getWriter();

        if (name == null || name.equals("")) {
            errorMsg = "User name can't be null or empty";
        }
        if (email == null || email.equals("")) {
            errorMsg = "User email can't be null or empty";
        }
        if (password == null || password.equals("")) {
            errorMsg = "User password can't be null or empty";
        }

        if(errorMsg != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.html");
            out.println("<font color=red>" + errorMsg + "</font>");
            rd.include(request, response);
        }
        else {

            Connection connection;
            PreparedStatement ps;

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                ps = connection.prepareStatement("INSERT INTO Users(name, email, password)" + " VALUES (?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, password);

                ps.execute();

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.html");
                rd.include(request, response);
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

}
