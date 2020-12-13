package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.IOException;

public class TeamMemberController
{
  @FXML private Button cancel;
  @FXML private Button accept;
  @FXML private Button search;
  @FXML private Button save;
  @FXML private Button showAllProjects;
  @FXML private TextField inputProjectName;
  @FXML private TextField inputRequirementID;
  @FXML private TextField inputTaskID;
  @FXML private TextField inputTime;
  @FXML private TableView tableView;
  @FXML private ComboBox<Requirement> requirementComboBox;
  @FXML private ComboBox<Task> taskComboBox;
  @FXML private ComboBox<TeamMember> teamMemberComboBox;

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

  public void setSearchForProject()
  {
    model.getProjectList().getProject(inputProjectName.getText());
  }

  public void setShowAllProjects()
  {
    model.getProjectList();
  }

  public void setSave()
  {
    int reqID = Integer.parseInt(inputRequirementID.getText());
    int taskID = Integer.parseInt(inputTaskID.getText());
    int time = Integer.parseInt(inputTime.getText());

    model.registerTaskTime(time,reqID,taskID);
  }



  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }

  public void setTableView()
  {
  }

  public void logOut()
  {
    viewHandler.openView("main");
  }
}
