package sample.Model;

import sample.util.IDGenerator;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
  //Fields
  private ArrayList<Project> projects;
  private IDGenerator idGenerator;

  //Constructors
  public ProjectList()
  {
    projects = new ArrayList<>();
    idGenerator = new IDGenerator();
  }

  //Getters
  public Project getProject(String projectName)
  {
    for (Project project: projects)
    {
      if (project.getProjectName().equals(projectName))
      {
        return  project;
      }
    }
    return null;
  }

  public ArrayList<Project> getAllProjects()
  {
    return projects;
  }

  public IDGenerator getIdGenerator()
  {
    return idGenerator;
  }



  //Setters
  public void addProject(Project project)
  {
    projects.add(new Project(project.getProjectName(),project.getProjectID(),project.getDeadline()));
  }

  public void removeProject(String projectName)
  {
    for (Project project : projects)
    {
      if (project.getProjectName().equals(projectName))
      {
        projects.remove(project);
      }
    }
  }

}
