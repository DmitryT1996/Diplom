package com.projectm.blog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by max on 3/20/17.
 */
@WebServlet(name = "Blog", urlPatterns = {"/blog"})
public class Blog extends HttpServlet {

    private static final String URL = "jdbc:mariadb://localhost:3306/postDb";
    private static final String USER = "root";
    private static final String PASSWORD = "magentam";
    private String header;
    private String text;
    private Date date;
    private String outDate;
    private Connection connection = null;
    private Statement st = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<BlogBean> arr = new ArrayList<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected database successfully...");
            st = connection.createStatement();
            String sql = "SELECT date, header, post FROM post";
            ResultSet rs = st.executeQuery(sql);
            DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
            while(rs.next()) {
                date = rs.getDate("date");
                header = rs.getString("header");
                text = rs.getString("post");

                outDate = dateFormat.format(date);

                System.out.println(outDate);
                System.out.println(header);
                System.out.println(text);

                arr.add(new BlogBean(outDate, header, text));
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(st != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("arr", arr);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/blog.jsp");
        rd.forward(request, response);
    }
}