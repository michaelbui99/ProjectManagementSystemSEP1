package sample.Model;
import java.util.Objects;

public class TeamMember
{

  //Fields

  private String name;
  private int employeeID;
  private String role;
  private int registeredHours;

  //Constructor

  TeamMember(String name, int employeeID, String role)
  {
    this.name = name;
    this.employeeID = employeeID;
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

  //Setter

  public void setEmployeeID(int employeeID)
  {
    this.employeeID = employeeID;
  }




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

  public TeamMember copy(TeamMember teamMember)
  {
    if (teamMember instanceof ProductOwner)
    {
      TeamMember temp = new ProductOwner(teamMember.name, teamMember.employeeID,
          teamMember.role);
      temp.registeredHours=teamMember.getRegisteredHours();

      return temp;
    }
    else
    {
      return null;
    }
  }

}
