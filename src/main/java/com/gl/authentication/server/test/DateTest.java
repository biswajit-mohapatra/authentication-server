package com.gl.authentication.server.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

  public static void main(String[] args) throws ParseException {
    Date beforeDate = new Date();
    System.out.println("Before date>>>"+beforeDate);
System.out.println("After date >>>"+trimTime(beforeDate));


SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
System.out.println("sdf>>>>"+sdf.format(beforeDate));
System.out.println("Date>>>"+sdf.parse(sdf.format(beforeDate)));
}

public static Date trimTime(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    return calendar.getTime();
  }

}
