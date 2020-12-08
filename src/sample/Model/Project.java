import java.util.Date;

public class Project
{
  //Fields
  private String projectName;
  private int projectID;
  private String status; //Kan antage følgende statusser {'Ikke afsluttet', 'Afsluttet'}
  private Date creationDate;
  private Date deadline;
  private RequirementList requirementList;
  private EmployeeList employeeList; //vi har denne variabel, så vi kan gemme medarbejderne under projektet


  //Constructors
  public Project(String projectName, int projectID, Date deadline)
  {
    this.projectName = projectName;
    this.projectID = projectID;
    this.deadline = deadline;
    creationDate = new Date();
    requirementList = new RequirementList();
    employeeList = new EmployeeList();
  }


  //Getters

  public String getProjectName()
  {
    return projectName;
  }

  public int getProjectID()
  {
    return projectID;
  }

  public String getStatus()
  {
    return status;
  }

  public Date getCreationDate()
  {
    return new Date(creationDate.getDay(), creationDate.getMonth(), creationDate.getYear());
  }

  public Date getDeadline()
  {
    return new Date(deadline.getDay(), deadline.getMonth(), creationDate.getYear());
  }

  public EmployeeList getEmployeeList()
  {
    return employeeList;
  }

  public RequirementList getRequirementList()
  {
    return requirementList;
  }

  //Setters
  public void addRequirement(String requirementName, int requirementID, TeamMember responsibleTeamMember, String status, String priority, Date deadline)
  {
    requirementList.addRequirement(new Requirement(requirementName,requirementID, responsibleTeamMember, status,priority, deadline));
  }

  public void removeRequirement(int requirementID)
  {
    requirementList.removeRequirement(requirementID);
  }

  public void setDeadline(Date date)
  {
    deadline = new Date(date.getDay(), date.getMonth(), date.getYear());
  }

  public void setStatus(String status)
  {
    switch (status)
    {
      case "Afsluttet":
        boolean endAble = true; //Holder styr på om vi gerne må afsluttet projektet.
        for (Requirement requirement : requirementList.getAllRequirements())
        {
          if (!requirement.getStatus().equals("Afsluttet")) //Tester om der findes et krav, som ikke er afsltutet.
          {
            endAble = false; //Hvis der findes et krav der ikke er afsluttet, så kan vi ikke afslutte projektet.
            break;
          }

          if (endAble) //Hvis alle krav er afsluttet ændres projektets status til 'Afsluttet'.
          {
            status = status;
            break;
          }
        }

      case "Ikke afsluttet":
        this.status = status;
        break;

      default:
        throw new IllegalArgumentException("Illegal status");
    }
  }


  public void addEmployee(TeamMember teamMember)
  {
    this.employeeList.addEmployee(teamMember);
  }

  public void removeEmployee(TeamMember teamMember)
  {
    this.employeeList.removeEmployee(teamMember.getEmployeeID());
  }
}
