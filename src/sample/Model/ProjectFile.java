package sample.Model;

import java.io.*;

public class ProjectFile implements Serializable
{
  //Fields
  private String fileName;

  //Constructors
  private ProjectFile(String fileName)
  {
    this.fileName = fileName;
  }

  //Getters
  public ProjectList readProjectListFile()
      throws IOException, ClassNotFoundException
  {
    ProjectList projectList = new ProjectList(); //Bruges som return for metoden.
    FileInputStream fis = null;
    ObjectInputStream in = null;
    fis = new FileInputStream(fileName); //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Project) //Checker om objektet vi læser er et Project object inden vi caster.
      {
        projectList.addProject((Project) in.readObject());
      }
    }
    in.close();

    return projectList;
  }

  public EmployeeList readEmployeeListFile()
      throws IOException, ClassNotFoundException
  {
    EmployeeList employeeList = new EmployeeList(); //Bruges som return for metoden.
    FileInputStream fis = null;
    ObjectInputStream in = null;
    fis = new FileInputStream(fileName); //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof TeamMember)
      /*
      * Vi Checker om vi prøver at læse et TeamMember object før vi caster.
      * */
      {
        employeeList.addEmployee((TeamMember) in.readObject());
      }
    }

    in.close();

    return employeeList;
  }


  public TaskList readTaskListFile() throws IOException, ClassNotFoundException
  {
    TaskList taskList = new TaskList(); //Bruges som return for metoden.
    FileInputStream fis = null;
    ObjectInputStream in = null;
    fis = new FileInputStream(fileName); //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Task) //Checker om objektet vi læser er et Task object inden vi caster.
      {
        taskList.addTask((Task) in.readObject());
      }
    }
    in.close();

    return taskList;

  }

  public RequirementList readRequirementListFile()
      throws IOException, ClassNotFoundException
  {
    RequirementList requirementList = new RequirementList(); //Bruges som return for metoden.
    FileInputStream fis = null;
    ObjectInputStream in = null;
    fis = new FileInputStream(fileName); //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Requirement) //Checker om objektet vi læser er et Requirement object inden vi caster.
      {
        requirementList.addRequirement((Requirement) in.readObject());
      }
    }
    in.close();

    return requirementList;
  }



  //Setters




  public void writeProjectListFile(ProjectList projectList) throws IOException

  {
    File file = new File(fileName); //Angiver path til filen.
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    fos = new FileOutputStream(file);
    out = new ObjectOutputStream(fos);
    out.writeInt(projectList.getAllProjects().size());
    for (int i = 0; i < projectList.getAllProjects().size(); i++)
    {
      out.writeObject(projectList.getAllProjects().get(i));
      out.flush();
    }

    out.close();

  }

  public void writeEmployeeListFile(EmployeeList employeeList) throws IOException
  {
    File file = new File(fileName); //Angiver path til filen.
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    fos = new FileOutputStream(file);
    out = new ObjectOutputStream(fos);
    out.writeInt(employeeList.getAllEmployees().size());
    for (int i = 0; i < employeeList.getAllEmployees().size(); i++)
    {
      out.writeObject(employeeList.getEmployee(i));
      out.flush();
    }

    out.close();
  }

  public void writeTaskListFile(TaskList taskList) throws IOException
  {
    File file = new File(fileName); //Angiver path til filen.
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    fos = new FileOutputStream(file);
    out = new ObjectOutputStream(fos);
    out.writeInt(taskList.getAllTasks().size());
    for (int i = 0; i < taskList.getAllTasks().size(); i++)
    {
      out.writeObject(taskList.getAllTasks().get(i));
      out.flush();
    }

    out.close();
  }

  public void writeRequirementListFile(RequirementList requirementList) throws IOException
  {
    File file = new File(fileName); //Angiver path til filen.
    FileOutputStream fos = null;
    ObjectOutputStream out = null;

    fos = new FileOutputStream(file);
    out = new ObjectOutputStream(fos);
    out.writeInt(requirementList.getAllRequirements().size());
    for (int i = 0; i < requirementList.getAllRequirements().size(); i++)
    {
      out.writeObject(requirementList.getAllRequirements().get(i));
      out.flush();
    }

    out.close();
  }





  public void setFile(String fileName)
  {
    this.fileName = fileName;
  }

}

