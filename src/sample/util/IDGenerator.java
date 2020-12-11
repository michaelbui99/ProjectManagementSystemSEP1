package sample.util;

import sample.Model.Requirement;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.ArrayList;
import java.util.Random;

public class IDGenerator
{
  //Fields
  /*
  * Lists to keep track of ID's to make sure every ID is unique;
  * */
  private ArrayList<Integer> taskIDList;
  private ArrayList<Integer> requirementIDList;
  private ArrayList<Integer> projectIDList;

  //Constructors
  public IDGenerator()
  {
    taskIDList = new ArrayList<>();
    requirementIDList = new ArrayList<>();
    projectIDList = new ArrayList<>();
  }


  //Getters
  public int generateTaskID()
  {
    Random rand = new Random();
    int returnID = rand.nextInt(10000) + 1;
    if (!taskIDList.contains(returnID))
    {
      taskIDList.add(returnID);
      return returnID;
    }
    else
    {
      throw new KeyAlreadyExistsException("Task ID already exists");
    }
  }

  public int generateRequirementID()
  {
    Random rand = new Random();
    int returnID = rand.nextInt(10000) + 1;
    if (!requirementIDList.contains(returnID))
    {
      requirementIDList.add(returnID);
      return returnID;
    }
    else
    {
      throw new KeyAlreadyExistsException("Task ID already exists");
    }
  }


  public int generateProjectID()
  {
    Random rand = new Random();
    int returnID = rand.nextInt(1000) + 1;
    if (!projectIDList.contains(returnID))
    {
      projectIDList.add(returnID);
      return returnID;
    }
    else
    {
      throw new KeyAlreadyExistsException("Task ID already exists");
    }
  }

  public ArrayList<Integer> getTaskIDList()
  {
    return taskIDList;
  }

  public ArrayList<Integer> getRequirementIDList()
  {
    return requirementIDList;
  }

  public ArrayList<Integer> getProjectIDList()
  {
    return projectIDList;
  }
}
