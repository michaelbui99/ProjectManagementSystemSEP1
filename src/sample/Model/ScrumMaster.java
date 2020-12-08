package sample.Model;
public class ScrumMaster extends TeamMember
{

  //fields
  private TaskList taskList; // ScrumMaster har adgang til at tilføje og slet task så vi finder forbindelse til den med taskList.


  //Constructor
  public ScrumMaster(String name, int employeeID, String role)
  {
    super(name,employeeID,role);
  }


  //Methods

  public void addTask(Task task)
  {
    this.taskList.addTask(task);
  }

  public void removeTask(int taskID)
  {

    this.taskList.removeTask(taskID);
  }


  public void editTaskStatus(String status, int taskID)
  {
    this.taskList.getTask(taskID).setStatus(status);
  }

  @Override public String toString()
  {
    return "ScrumMaster{" + "taskList=" + taskList + '}';
  }
}
