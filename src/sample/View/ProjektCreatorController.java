package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class ProjektCreatorController
{
  @FXML private Button cancel;
  @FXML private Button accept;
  @FXML private Button create;
  @FXML private Button add;
  @FXML private Button remove;
  @FXML private TextField inputProjectName;
  @FXML private TextField inputProjectID;
  @FXML private TextField inputDay;
  @FXML private TextField inputMonth;
  @FXML private TextField inputYear;
  @FXML private TextField inputTeamMemberName;
  @FXML private TextField inputTeamMemberRole;
  @FXML private TextField inputAssignTeamMemberToProject;
  @FXML private TextField inputAssignTeamMemberToAssignment;
  @FXML private TextField inputRemovalTeamMemberFromProject;
  @FXML private TextField inputProjectForTeamMemberRemoval;
  @FXML private ComboBox<TeamMember> teamMemberComboBox;
  @FXML private ComboBox<TeamMember> removeTeamMemberComboBox;
  @FXML private ComboBox<Project> projectComboBox;
  @FXML private ComboBox<Project> removeProjectComboBox;
  @FXML private ComboBox<Requirement> requirementComboBox;
  @FXML  private ToggleGroup role;

  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;


  public void setModel( ManagementSystemModel model)
  {
    this.model = model;
  }

  public void setViewHandler(ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
  }

  public void init(ViewHandler viewHandler, ManagementSystemModel model, Region root)
      throws IOException, ClassNotFoundException
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;

    //Setting the most recent saved ProjectList file as projectList for model on init.
    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList);

  }

  public Region getRoot()
  {
    return root;
  }

  public void setCreateProject() throws IOException, ClassNotFoundException
  {
    int ID = Integer.parseInt(inputProjectID.getText());
    int day = Integer.parseInt(inputDay.getText());
    int month = Integer.parseInt(inputMonth.getText());
    int year = Integer.parseInt(inputYear.getText());

    //Try to load existing ProjectList file else create a file if no file is found.
    try
    {
      ProjectList loadedList = model.readProjectList("ProjectList.bin");
      model.setProjectList(loadedList);
      model.getProjectList().addProject(new Project(inputProjectName.getText(),model.getProjectList().getIdGenerator().generateProjectID(), new MyDate(day,month,year)));
      model.saveProjectList();
    }
    catch (IOException | ClassNotFoundException e)
    {
      model.getProjectList().addProject(new Project(inputProjectName.getText(),model.getProjectList().getIdGenerator().generateProjectID(), new MyDate(day,month,year)));
      model.saveProjectList();
    }
  }

  public void initializeComboBoxes() throws IOException, ClassNotFoundException
  {
    ArrayList<Project> systemProjects = model.readProjectList("ProjectList.bin").getAllProjects();
    projectComboBox.getItems().addAll(systemProjects);

    ArrayList<Project> systemProjectsRemove = model.readProjectList("ProjectList.bin").getAllProjects();
    removeProjectComboBox.getItems().addAll(systemProjects);

    ArrayList<TeamMember> systemEmployees = model.readEmployeeList("EmployeeList.bin").getAllEmployees();
    teamMemberComboBox.getItems().addAll(systemEmployees);

    ArrayList<TeamMember> systemEmployeesRemove = model.readEmployeeList("EmployeeList.bin").getAllEmployees();
    removeTeamMemberComboBox.getItems().addAll(systemEmployees);

    ArrayList<Requirement> projectRequirement = model.readProjectList("ProjectList.bin").getProject(projectComboBox.getValue().getProjectName()).getRequirementList().getAllRequirements();
    requirementComboBox.getItems().addAll(projectRequirement);
  }

  public void serAddTeamMemberToProject()
  {
    int ID = Integer.parseInt(inputAssignTeamMemberToAssignment.getText());

    model.getProjectList().getProject(inputProjectName.getText()).addEmployee(new TeamMember(inputAssignTeamMemberToProject.getText(),inputTeamMemberRole.getText()));
    model.assignTeamMemberToRequirement(ID, new TeamMember(inputTeamMemberName.getText(),inputTeamMemberRole.getText()));
  }

  public void setRemoveTeamMemberFromProject()
  {
    int ID = Integer.parseInt(inputRemovalTeamMemberFromProject.getText());
    model.removeTeamMemberFromProject(inputProjectForTeamMemberRemoval.getText(), ID);
  }



  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }

  public void logOut()
  {
    viewHandler.openView("main");
  }
}
