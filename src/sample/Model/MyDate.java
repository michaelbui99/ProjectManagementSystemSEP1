package sample.Model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate implements Serializable
{
  /*
  Fields
   */
  private int day;
  private int month;
  private int year;

  /*
  Constructors
   */
  public MyDate(int day, int month, int year)
  {
   set(day,month,year);
  }

  public MyDate()
  {
    Calendar now = GregorianCalendar.getInstance();
    day = now.get(Calendar.DAY_OF_MONTH);
    month = now.get(Calendar.MONTH) + 1;
    year = now.get(Calendar.YEAR);
  }

  /*
  Setters
   */

 public void set(int day, int month, int year)
 {
   if (year < 0)
   {
     this.year = year*(-1);
   }
   else
   {
     this.year = year;
   }


   if (month < 1)
   {
     this.month = 1;
   }
   else if (month > 12)
   {
     this.month = 12;
   }
   else
   {
     this.month = month;
   }

   if (day < 1)
   {
     this.day = 1;
   }
   else if (day > numberOfDaysInMonth(month))
   {
     this.day = numberOfDaysInMonth(month);
   }
   else
   {
     this.day = day;
   }
 }

  public MyDate copy()
  {
    MyDate other;
    other = new MyDate(day, month, year);
    return other;
  }

  /*
  Getters
   */

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {

    return year;
  }

  public String toString()
  {
    return String.format("%s/%s/%s", day, month, year);

  }


  public String getMonthName()
  {
    switch (month)
    {
      default:
        return null;

      case 1:
        return "January";

      case 2:
        return "February";

      case 3:
        return "March";

      case 4:
        return "April";

      case 5:
        return "May";

      case 6:
        return "June";

      case 7:
        return "July";

      case 8:
        return "August";

      case 9:
        return "September";

      case 10:
        return "Oktober";

      case 11:
        return "November";

      case 12:
        return "December";

    }
  }

  public boolean isLeapYear()
  {
    if (year % 4 == 0 && (!(year % 100 == 0)) || (year % 400 == 0))
    {
      return true;
    }
    else
      return false;
  }

  public int numberOfDaysInMonth(int monthNumber)
  {
    switch (monthNumber)
    {
      default:
        return -1;
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        return 31;
      case 2:
        if (isLeapYear())
        {
          return 29;
        }
        else
        {
          return 28;
        }

      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
    }
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof MyDate))
    {
      return false;
    }
    MyDate other = (MyDate) obj;
    return day == other.getDay() && month == other.getMonth() && year == other.getYear();
  }

  public boolean isBefore(MyDate other)
  {
    if (year < other.getYear())
    {
      return true;
    }
    else if (year == other.getYear() && month < other.getMonth())
    {
      return true;
    }
    else if (year == other.getYear() && month == other.getMonth() && day < other
        .getDay())
    {
      return true;
    }
    else
      return false;
  }

  public static MyDate now()
  {
    MyDate other = new MyDate();
    return other;
  }
}
