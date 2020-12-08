package sample.Model;

import java.io.*;

public class ProjectFile
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
    fis = new FileInputStream(fileName) //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Project) //Checker om objektet vi læser er et Project object inden vi caster.
      {
        projectList.add((Project) in.readObject());
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
      * Vi Checker hvilken class vi prøver at læse, og caster afhængig af hvilken subclass.
      * */
      {
        employeeList.add((TeamMember) in.readObject());
      }
      else if(in.readObject()instanceof Admin)
      {
        employeeList.add((Admin) in.readObject());
      }
      else if (in.readObject() instanceof ScrumMaster)
      {
        employeeList.add((ScrumMaster) in.readObject());
      }
      else if (in.readObject() instanceof ProductOwner)
      {
        employeeList.add((ProductOwner) in.readObject());
      }
      else if (in.readObject() instanceof ProjectCreator)
      {
        employeeList.add((ProjectCreator) in.readObject());
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
    fis = new FileInputStream(fileName) //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Task) //Checker om objektet vi læser er et Task object inden vi caster.
      {
        projectList.add((Task) in.readObject());
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
    fis = new FileInputStream(fileName) //Angiver path til filen
    in = new ObjectInputStream(fis);
    int counter = in.readInt();
    for (int i = 0; i < counter; i++)
    {
      if (in.readObject() instanceof Project) //Checker om objektet vi læser er et Project object inden vi caster.
      {
        projectList.add((Project) in.readObject());
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
    out.writeInt(projectList.size());
    for (int i = 0; i < projectList.size(); i++)
    {
      out.writeObject(projectList.get(i));
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
    out.writeInt(employeeList.size());
    for (int i = 0; i < employeeList.size(); i++)
    {
      out.writeObject(employeeList.get(i));
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
    out.writeInt(taskList.size());
    for (int i = 0; i < taskList.size(); i++)
    {
      out.writeObject(taskList.get(i));
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
    out.writeInt(requirementList.size());
    for (int i = 0; i < requirementList.size(); i++)
    {
      out.writeObject(requirementList.get(i));
      out.flush();
    }

    out.close();
  }





  public void setFile(String fileName)
  {
    this.fileName = fileName;
  }

}

