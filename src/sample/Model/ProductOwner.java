package sample.Model;
import java.util.Date;

public class ProductOwner extends TeamMember
{

  //Product owner kan tilføje og slet krav så vi skulle finde en forbindelse til krav class, og vi kan har den forbindelse fra kravlist class.
  private Project project;
  //Constructor

  ProductOwner(String name, int employeeID, String role)
  {
    super(name,employeeID,role);
    ProjectList pl = new ProjectList(); //forbindelse til kravList

    for (int i = 0; i < pl.getAllProjects().size(); i++)
    {
      if (pl.getAllProjects().get(i).getEmployeeList().getEmployee(name)!=null)
        this.project=pl.getAllProjects().get(i);
    }
  }


  //Field

  public void addRequirement(String name, int requirementID, TeamMember responsibleTeamMember, String status,String priority,
      Date deadline)
  {
  project.addRequirement(name,requirementID,responsibleTeamMember,status,priority,deadline);
  }

  public void removeRequirement(int requirementID)
  {
    project.removeRequirement(requirementID);
  }

  public void approveRequirement(int requirementID)
  {
   project.getRequirementList().getRequirement(requirementID).setApprovement(true);
  }

  @Override public String toString()
  {
    return "project: " + project;
  }
}
