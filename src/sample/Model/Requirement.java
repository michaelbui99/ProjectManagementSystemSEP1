package sample.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Requirement implements
    Serializable //oprettelse af nyt krav, angiv værdier af:
{

  //Fields
  private static final long serialVersionUID = 1345606179531482449L;
  private String requirementName;
  private TaskList taskList;
  private String userStory;
  private MyDate requirementDeadline;
  private MyDate creationDate;
  private EmployeeList employees;
  private int requirementID;
  private TeamMember responsibleTeamMember;
  private String requirementStatus;//Statusser kan antage {‘Ikke påbegyndt, ‘Påbegyndt’, ‘Afsluttet’, ‘Godkendt’, ‘Ikke Godkendt’}
  private String priority;//Priority kan antage  {‘Lav’, ‘Normal’, ‘Høj’, ‘Kritisk’}
  private boolean isApproved;
  private int timeSpendInHours;
  private double estimatedCompletionTimeInHours;
  private ArrayList<String> priorityList;

  //Constructors

  Requirement(String name, int requirementID, TeamMember responsibleTeamMember,
      String status, String priority, MyDate deadline, String userStory)
  {
    this.requirementName = name;
    this.requirementID = requirementID;
    this.responsibleTeamMember = responsibleTeamMember;
    this.requirementStatus = status;
    this.priority = priority;
    timeSpendInHours = 0;
    isApproved = false;
    this.requirementDeadline = deadline;
    this.creationDate = MyDate.now();
    estimatedCompletionTimeInHours = calculateEstimatedTimeInHours();
    taskList = new TaskList();
    this.userStory = userStory;
    employees = new EmployeeList();
  }

  public Requirement(String name, int requirementID)
  {
    this.requirementName = name;
    this.requirementID = requirementID;
    employees = new EmployeeList();
  }

  //Getters

public String getPriority()
{
  return priority;
}

  public int getRequirementID()
  {
    return requirementID;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  public String getRequirementName()
  {
    return requirementName;
  }

  public String getRequirementStatus()
  {
    return requirementStatus;
  }

  public TaskList getTaskList()
  {
    return taskList;
  }

  public int getTimeSpendInHours()
  {
    timeSpendInHours = calculateTimeSpentInHours();
    return timeSpendInHours;
  }

  public MyDate getCreationDate()
  {
    return creationDate;
  }

  public MyDate getRequirementDeadline()
  {
    return requirementDeadline;
  }

  public boolean isApproved()
  {
      return isApproved;
  }

  public String getUserStory()
  {
    return userStory;
  }

  public EmployeeList getEmployees()
  {
    return employees;
  }

  public double calculateEstimatedTimeInHours()
  {
    double totalTime = 0; //Running total for calculating sum of task completion estimates.
    try
    {
      for (Task task : taskList.getAllTasks())
      {
        totalTime += task.getEstimatedCompletionTimeInHours();
      }
    }
    catch (NullPointerException e)
    {
      totalTime = 0;
    }
    return totalTime;
  }

  public double getEstimatedCompletionTimeInHours()
  {
    estimatedCompletionTimeInHours = calculateEstimatedTimeInHours(); //Calculate the estimated time total of all task, such that estimated time for requirement is up-to-date
    return estimatedCompletionTimeInHours;
  }

  public ArrayList<String> getPriorityList()
  {
    ArrayList<String> prioList = new ArrayList<>();
    prioList.add("Lav");
    prioList.add("Normal");
    prioList.add("Høj");
    prioList.add("Kritisk");
    return prioList;
  }

  public int calculateTimeSpentInHours()
  {
    int total = 0;
    for (Task task: taskList.getAllTasks())
    {
      total += task.getTimeSpendInHours();
    }
    return total;
  }

  //Setters

  public void setApprovement(boolean approvement)
  {
    if (approvement == true)
    {
      if (requirementStatus.equals("Godkendt"))
      {
        isApproved = approvement;
      }
    }
    else
    {
      isApproved = false;
    }
  }

  public void setRequirementStatus(String requirementStatus)
  {
    switch (requirementStatus)
    {
      case "Ikke påbegyndt":
        case "Påbegyndt" :
          case "Ikke Godkendt" :

      this.requirementStatus = requirementStatus;
      break;

      case "Afsluttet":
        boolean endAble = true;
        for(Task task : taskList.getAllTasks())
        {
          if (!task.getStatus().equals("Afsluttet"))
          {
            endAble = false;
            break;
          }
        }

        if (endAble)
        {
          this.requirementStatus = requirementStatus;
          break;
        }
        break;

      case "Godkendt":
        if (getRequirementStatus().equals("Afsluttet"))
        {
          this.requirementStatus = requirementStatus;
          break;
        }
    }



  }

  public void addEmployeeToRequirement(TeamMember teamMember)
  {
    employees.addEmployee(teamMember);
  }

  public void setResponsibleTeamMember(TeamMember responsibleTeamMember)
  {
    this.responsibleTeamMember = responsibleTeamMember;
  }

  public void setPriority(String priority)
  {
    this.priority = priority;
  }

  public void setTimeSpendInHours(int timeSpendInHours)
  {
    this.timeSpendInHours = timeSpendInHours;
  }

  public void setRequirementDeadline(MyDate requirementDeadline)
  {
    this.requirementDeadline = requirementDeadline;
  }

  @Override public String toString()
  {
    return "The requirement: " + "name: " + requirementName + ", taskList: " + taskList
        + ", deadline: " + requirementDeadline
        + ", creationDate: " + creationDate + ", employees: " + employees
        + ", requirementID: " + requirementID + ", responsibleTeamMember: "
        + responsibleTeamMember + ", status: '" + requirementStatus +  ", priority: "
        + priority + ", isApproved: " + isApproved + ", timeSpendInHours: "
        + timeSpendInHours;
  }

  public void setUserStory (String userStory)
  {
    this.userStory = userStory;
  }

  public void setEmployees(EmployeeList employees)
  {
    this.employees = employees;
  }

}
