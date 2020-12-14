package sample.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable
{
  //Fields
  private String name;
  private EmployeeList employees;
  private int taskID;
  private String status; //Kan antage følgende statusser {'Ikke påbegyndt', 'Påbegyndt', 'Afsluttet'}
  private TeamMember responsibleTeamMember;
  private String priority; //Kan antage følgende prioriteter {'Lav', 'Normal, 'Høj', 'Kritisk'}
  private int timeSpendInHours;
  private MyDate creationDate;
  private MyDate deadline;
  private double estimatedCompletionTimeInHours;
  private static final long serialVersionUID = 374347049712624210L;

  //Constructors
  public Task(String name, int taskID, String status, TeamMember responsibleTeamMember, String priority, MyDate deadline)
  {
    this.name = name;
    this.taskID = taskID;
    this.status = status;
    this.responsibleTeamMember = responsibleTeamMember;
    setPriority(priority);
    employees = new EmployeeList();
    this.deadline = new MyDate(deadline.getDay(),deadline.getMonth(),deadline.getYear());
    creationDate = MyDate.now();
    timeSpendInHours = 0; //Defaultes til 0, når projektet oprettes, da der ikke er blevet brugt til på projektet ved oprettelse.
  }

  public Task(String name, int taskID, String status, TeamMember responsibleTeamMember, String priority, MyDate deadline, double estimatedCompletionTimeInHours)
  {
    this.name = name;
    this.taskID = taskID;
    this.status = status;
    this.responsibleTeamMember = responsibleTeamMember;
    setPriority(priority);
    employees = new EmployeeList();
    creationDate = MyDate.now();
    this.deadline = new MyDate(deadline.getDay(),deadline.getMonth(),deadline.getYear());
    timeSpendInHours = 0; //Defaultes til 0, når projektet oprettes, da der ikke er blevet brugt til på projektet ved oprettelse.
    this.estimatedCompletionTimeInHours = estimatedCompletionTimeInHours;
  }

  //Getters
  public String getName()
  {
    return name;
  }

  public int getTaskID()
  {
    return taskID;
  }

  public String getStatus()
  {
    return status;
  }

  public TeamMember getResponsibleTeamMember()
  {
    return responsibleTeamMember;
  }

  public int getTimeSpendInHours()
  {
    return timeSpendInHours;
  }

  public MyDate getDeadline()
  {
    return deadline;
  }

  public MyDate getCreationDate()
  {
    return creationDate;
  }

  public ArrayList<TeamMember> getAllTaskEmployees()
  {
    return employees.getAllEmployees();
  }

  public Task Copy()
  {
    return new Task(name, taskID, status,responsibleTeamMember, priority, deadline);
  }

  public double getEstimatedCompletionTimeInHours()
  {
    return estimatedCompletionTimeInHours;
  }

  public String getPriority()
  {
    return priority;
  }

  //Setters
  public void setTimeSpendInHours(int hours)
  {
    this.timeSpendInHours = hours;
  }

  public void setPriority(String priority)
  {
    switch (priority)
    {
      case "Lav":case "Normal": case "Høj": case "Kritisk":
      this.priority = priority;
      break;
      default:
        throw new IllegalArgumentException("Illegal status");
    }
  }

  public void setStatus(String status)
  {
    switch(status)
    {

      case "Ikke påbegyndt": case "Påbegyndt" : case "Afsluttet":
    {
      this.status = status;
      break;
    }
      default:
        throw new IllegalArgumentException("Illegal priority");
    }

  }

  public void registerTimeSpent(int hours)
  {
    if (hours > 0)
    {
      timeSpendInHours += hours;
    }
    else
    {
      throw new IllegalArgumentException("Illegal input, Less than 0 hours was entered.");
    }
  }

}




