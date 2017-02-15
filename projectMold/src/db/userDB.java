package db;

import java.sql.*;

/**
 * Created by max on 9/16/16.
 */
public class userDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/userDB";
    private static final String USER = "root";
    private static final String PASSWORD = "magentam";

    PreparedStatement insertUser = null;
    Connection connection = null;

    public userDB() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            insertUser = connection.prepareStatement("INSERT INTO userMakeReg(id, firstName," +
                    " lastName, email,  date, fromTime, toTime)" + "VALUES(?, ?, ?, ?, ?, ?, ?)");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int setUser(int id, String fn, String ln, String em, Date d, Time ft, Time tt) {

        try {
            insertUser.setInt(1, id);
            insertUser.setString(2, fn);
            insertUser.setString(3, ln);
            insertUser.setString(4, em);
            insertUser.setDate(5, d);
            insertUser.setTime(6, ft);
            insertUser.setTime(7, tt);

            insertUser.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                insertUser.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

}
