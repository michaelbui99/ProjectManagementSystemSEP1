package sample.Model;
import java.io.Serializable;
import java.util.Objects;

public class TeamMember implements Serializable
{

  //Fields
  private String name;
  private int employeeID;
  private String role;
  private int registeredHours;
  //private String whoWorksWithWho;

  //Constructor

  public TeamMember(String name, int employeeID, String role)
  {
    this.name = name;
    this.employeeID = employeeID;
    this.role = role;
    registeredHours = 0;
  }

  public TeamMember(String name, String role)
  {
    this.name = name;
    this.role = role;
    registeredHours = 0;
  }


  //Getter

  public String getName()
  {
    return name;
  }

  public int getEmployeeID()
  {
    return employeeID;
  }

  public String getRole()
  {
    return role;
  }

  public int getRegisteredHours()
  {
    return registeredHours;
  }

  /*public String getWhoWorksWithWho()
  {
    return whoWorksWithWho;
  }*/

  //Setter

  public void setEmployeeID(int employeeID)
  {
    this.employeeID = employeeID;
  }

  public void setRole(String role)
  {
    this.role = role;
  }

  public void setRegisteredHours(int registeredHours)
  {
    this.registeredHours = registeredHours;
  }

  public void addName(String name){
    this.name = name;
  }

  public void addEmployeeID(int employeeID){
    this.employeeID = employeeID;
  }

  /*public void setWhoWorksWithWho(String whoWorksWithWho)
  {
    this.whoWorksWithWho = whoWorksWithWho;
  }*/
  //Methods


  public String toString()
  {
    return "The name: " + name + ", employeeID: " + employeeID
        + ", and the role: '" + role + " registeredHours: " + registeredHours;
  }



  public boolean equals(Object obj)
  {
    if (!(obj instanceof TeamMember))
    {
      return false;
    }
    else
    {
      TeamMember other = (TeamMember) obj;
      return other.name.equals(((TeamMember) obj).name) && other.role.equals(((TeamMember) obj).role) && other.employeeID==employeeID;
    }
  }

  public void registerTime(int hours)
  {
    registeredHours=+ hours;
  }

  public TeamMember copy()
  {
    return new TeamMember(name, employeeID, role);
  }

}
