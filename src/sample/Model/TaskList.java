package sample.Model;
import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
  //Fields
  private ArrayList<Task> tasks;

  //Constructors
  public TaskList()
  {
    tasks = new ArrayList<>();
  }


  //Getters
  public ArrayList<Task> getAllTasks()
  {
    return tasks;
  }

  public Task getTask(int taskID)
  {
    for (Task task : tasks)
    {
      if (task.getID()==(taskID))
      {
        return task;
      }
    }

    return null;
  }



  //Setters

  public void addTask(Task task)
  {
    if (!tasks.contains(tasks))
    {
      tasks.add(task); //Can't add duplicate tasks.
    }
  }

  public void removeTask(int taskID)
  {
    for (Task task: tasks)
    {
      if (task.getID()==(taskID))
      {
        tasks.remove(task);
      }
    }
  }

}

