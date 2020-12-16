package sample.util;

import parser.ParserException;
import parser.XmlJsonParser;
import sample.Model.EmployeeList;
import sample.Model.ProjectList;

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
    File file = new File(fileName);
    EmployeeList employeeList = null;
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream in = new ObjectInputStream(fis);
    int counter = in.readInt();
    employeeList = (EmployeeList) in.readObject();
    in.close();
    return employeeList;
  }

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


  public static void save(ProjectList list)
  {
    saveToXml(list);
  }

  public static void saveToXml(ProjectList list)
  {

    /*
    * Method saves ProjectList to XML file.
    * */
    XmlJsonParser parser = new XmlJsonParser();
    try
    {
      parser.toXml(list, "ProjectList.xml");
    }
    catch (ParserException e)
    {
      e.printStackTrace();
    }
  }

  public void setFile(String fileName)
  {
    this.fileName = fileName;
  }

}

