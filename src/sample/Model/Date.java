public class Date
{
  sadkwkaldml
  private int'' day, month, year;

  public Date(){ }

  public Date(int day, int month, int year){
    set(day, month, year);
  }

  public void set(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

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

  public String toString(){
    return "The date seleceted: " + day+"/"+month+"/"+year+"AC";
  }
}