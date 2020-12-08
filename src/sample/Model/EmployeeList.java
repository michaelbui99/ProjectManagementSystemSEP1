package sample.Model;

import java.util.ArrayList;

public class EmployeeList
{

  //Fields

  private ArrayList<TeamMember> teamMembers;

  //Constructor

  EmployeeList ()
  {
    teamMembers = new ArrayList<TeamMember>();
  }

  //Methods

  public void addEmployee(TeamMember teamMember)
  {
    teamMembers.add(teamMember);
  }

  public void removeEmployee(int employeeID)
  {
    for (int i = 0; i < teamMembers.size(); i++)
    {
      if (teamMembers.get(i).getEmployeeID()==employeeID)
        teamMembers.remove(i);
    }
  }

  //Getter

  public TeamMember getEmployee(String employeeName)
  {
    for (int i = 0; i < teamMembers.size(); i++)
    {
      if (teamMembers.get(i).equals(employeeName))
        return teamMembers.get(i);
    }
    return null;
  }

  public TeamMember getEmployee(int index)//TODO: ADD METODEN TIL ASTAH CLASS DIAGRAM
  {
    return teamMembers.get(index);
  }



  public ArrayList<TeamMember> getAllEmployees()
  {
    return this.teamMembers;
  }

  @Override public String toString()
  {
    return "teamMembers: " + teamMembers;
  }
}
