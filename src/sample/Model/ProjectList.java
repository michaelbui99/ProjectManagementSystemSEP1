package sample.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectList implements Serializable
{
  //Fields
  private ArrayList<Project> projects;

  //Constructors
  public ProjectList()
  {
    projects = new ArrayList<>();
  }

  //Getters
  public Project getProject(String projectName)
  {
    for (Project project: projects)
    {
      if (project.getProjectName().equals(projectName))
      {
        return new Project(project.getProjectName(), project.getProjectID(), project.getDeadline());
      }
    }
    return null;
  }

  public ArrayList<Project> getAllProjects()
  {
    return projects;
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
