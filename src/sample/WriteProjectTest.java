package sample;

import sample.Model.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class WriteProjectTest
{
  public static void main(String[] args)
      throws IOException, ClassNotFoundException
  {
    ManagementSystemModel model = new ManagementSystemModel();
    model.addEmployeeToSystem("Michael", 2020,"teammember");
    model.createProject("Project1", 23, MyDate.now());
    model.setCurrentProject("Project1");
    model.createRequirement("TestReq", 2020, new TeamMember("Michael", 2020, "teammember"), "Ikke påbegyndt", "Høj", MyDate.now());
    Requirement req1 = new Requirement("Test", 201, new TeamMember("Michael", 2020, "teammember"),"Høj");
    model.getProjectList().getProject("Project1").getRequirementList().addRequirement(req1);

    

    ProjectList loadedList = model.readProjectList("ProjectListd11m12y2020.bin");

    System.out.println(loadedList.getProject("Project1").getRequirementList().getRequirement(201).getName());

  }





}
