package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;

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

  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }
}
