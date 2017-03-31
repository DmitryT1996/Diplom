package com.projectm.servlet;

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

/**
 * Created by max on 2/10/17.
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/loginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String URL = "jdbc:mariadb://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "magentam";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String errorMsg = null;

        if (email == null || email.equals("")) {
            errorMsg = "User email can't be null or empty";
        }
        if (password == null || password.equals("")) {
            errorMsg = "Password can't be null or empty";
        }

        if(errorMsg != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            out.println("<font color=red>" + errorMsg + "</font>");
            rd.include(request, response);
        }
        else {

            Connection connection;
            PreparedStatement ps;
            ResultSet rs;

            try {
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                ps = connection.prepareStatement("SELECT id, name, email from Users where email=? AND password=? limit 1");
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();

                if(rs != null && rs.next()) {
                    User user = new User(rs.getString("name"), rs.getString("email"), rs.getInt("id"));
                    HttpSession session = request.getSession();
                    session.setAttribute("User", user);
                    response.sendRedirect("home.jsp");
                }
                else {
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/welcome.html");
                    out.println("<font color=red>No user found with given email id, please register first.</font>");
                    rd.include(request, response);
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

}
