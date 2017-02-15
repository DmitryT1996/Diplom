package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.userDB;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by max on 9/16/16.
 */
public class queryServlet extends HttpServlet {

    public static Time convertToTime(Date date, boolean am) {
        if(date == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);

        if(am) {
            if(hourOfDay > 11) {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay - 12);
                date.setTime(cal.getTimeInMillis());
            }
        }
        else {
            if(cal.get(Calendar.HOUR_OF_DAY) < 11) {
                cal.set(Calendar.HOUR_OF_DAY, hourOfDay + 12);
                date.setTime(cal.getTimeInMillis());
            }
        }
        return new Time(date.getTime());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Integer id = new Integer(0);
        String fn = new String();
        String ln = new String();
        String em = new String();
        long time = System.currentTimeMillis();
        Date sqlDate = new Date(time);
        Time sqlTime = new Time(time);
        Time sqlTime2 = new Time(time);

        if(request.getParameter("submit") != null) {

            if(request.getParameter("firstName") != null) {
                fn = request.getParameter("firstName");
            }
            if(request.getParameter("lastName") != null) {
                ln = request.getParameter("lastName");
            }
            if(request.getParameter("email") != null) {
                em = request.getParameter("email");
            }
            if(request.getParameter("date") != null) {
                try {
                    String str = request.getParameter("date");
                    java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
                    sqlDate = Date.valueOf(str);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(request.getParameter("fromT") != null) {
                try {
                    String str = request.getParameter("fromT");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    long ms = sdf.parse(str).getTime();
                    sqlTime = new Time(ms);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            if(request.getParameter("toT") != null) {
                try {
                    String str = request.getParameter("toT");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    long ms = sdf.parse(str).getTime();
                    sqlTime2 = new Time(ms);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            userDB db = new userDB();

            db.setUser(id, fn, ln, em, sqlDate, sqlTime, sqlTime2);

        }
    }

}
