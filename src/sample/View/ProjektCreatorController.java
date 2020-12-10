package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;
import sample.Model.MyDate;
import sample.Model.Project;
import sample.Model.TeamMember;

import java.io.IOException;

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
  {
    this.viewHandler = viewHandler;
    this.model = model;
    this.root = root;
  }

  public Region getRoot()
  {
    return root;
  }

  public void setCreateProject()
  {
    int ID = Integer.parseInt(inputProjectID.getText());
    int day = Integer.parseInt(inputDay.getText());
    int month = Integer.parseInt(inputMonth.getText());
    int year = Integer.parseInt(inputYear.getText());

    model.getProjectList().addProject(new Project(inputProjectName.getText(),ID, new MyDate(day,month,year)));
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

  public void setAccept() throws IOException
  {
    model.saveProject(inputProjectName.getText());
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
