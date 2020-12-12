package sample.Model;

import java.io.*;


public class ProjectFile implements Serializable
{
  //Fields
  private String fileName;

  //Constructors
  public ProjectFile(String fileName)
  {
    this.fileName = fileName;
  }

  //Getters
  public String getFileName;
/*
  public ArrayList<Project> readProjectListFile(String fileName)
      throws IOException, ClassNotFoundException
  {
    File file = new File(fileName);
    ArrayList<Project> projectList = new ArrayList<>(); //Bruges som return for metoden.
    FileInputStream fis = null;
    ObjectInputStream in = null;
    fis = new FileInputStream(file); //Angiver path til filen
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

 */

  public ProjectList readProjectListFile(String fileName)
      throws IOException, ClassNotFoundException
  {
    File file = new File(fileName);
    ProjectList projectList = null;
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream in = new ObjectInputStream(fis);
    int counter = in.readInt();
    projectList = (ProjectList) in.readObject();
    in.close();
    return projectList;

  }

  public EmployeeList readEmployeeListFile(String fileName)
      throws IOException, ClassNotFoundException
  {
    File file = new File(this.fileName);
    EmployeeList employeeList = null;
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream in = new ObjectInputStream(fis);
    int counter = in.readInt();
    employeeList = (EmployeeList) in.readObject();
    in.close();
    return employeeList;
  }

/*
//TODO: Delete these methods, because we only read projectListFiles and EmployeeListFiles
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
*/


  //Setters



  public void writeProjectListFile(String fileName, ProjectList projectList)
      throws IOException
  {
    /*
    * Method writes the entire ProjectListFile with all projects + requirementLists + TaskLists.
    * */
    File file = new File(fileName);
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream out = new ObjectOutputStream(fos);
    out.writeInt(1);
    out.writeObject(projectList);
    out.flush();
    out.close();
  }

  public void writeEmployeeListFile(String fileName, EmployeeList employeeList) throws IOException
  {
    /*
    * Method writes all the employees registered in the system to file.
    * */
    File file = new File(fileName);
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream out = new ObjectOutputStream(fos);
    out.writeInt(1);
    out.writeObject(employeeList);
    out.flush();
    out.close();
  }

  /*

  //TODO: Delete these methods, because writeProjectListFile will save all projects
  public void writeTaskListFile(TaskList taskList, String fileName) throws IOException
  {
    File file = new File(fileName + ".bin"); //Angiver path til filen.
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



*/

  public void setFile(String fileName)
  {
    this.fileName = fileName;
  }

}

