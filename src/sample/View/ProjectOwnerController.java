package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.IOException;
import java.util.InputMismatchException;

public class ProjectOwnerController
{
  @FXML private Button cancel;
  @FXML private Button search;
  @FXML private Button approve;
  @FXML private Button notApprove;
  @FXML private Button add;
  @FXML private Button remove;
  @FXML private Button accept;
  @FXML private TextField inputAddProjectName;
  @FXML private TextField inputApprovalRequirementID;
  @FXML private TextField inputAddRequirementID;
  @FXML private TextField inputAddRequirementName;
  @FXML private TextField inputResponsibleTeamMember;
  @FXML private TextField day;
  @FXML private TextField month;
  @FXML private TextField year;
  @FXML private TextField inputRemoveRequirementID;
  @FXML private TableView tableView;
  @FXML private Label status;

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

  public void getProject()
  {
    try
    {
      model.getProjectInfo(inputAddProjectName.getText());
    }
    catch (Exception e)
    {
      status.setText("Bruge igen!");
    }
  }

  public void setApprove()
  {
    int ID = Integer.parseInt(inputApprovalRequirementID.getText());
    model.getRequirementList(inputAddProjectName.getText()).getRequirement(ID).setApprovement(true);
  }

  public void setNotApprove()
  {
    int ID = Integer.parseInt(inputApprovalRequirementID.getText());
    model.getRequirementList(inputAddProjectName.getText()).getRequirement(ID).setApprovement(false);
  }

  public void setAddRequirement()
  {
    int ID = Integer.parseInt(inputAddRequirementID.getText());
    int d = Integer.parseInt(day.getText());
    int m = Integer.parseInt(month.getText());
    int y = Integer.parseInt(year.getText());

    model.getProjectList().getProject(inputAddProjectName.getText()).
        getRequirementList().addRequirement(new Requirement(inputAddRequirementName.
        getText(), ID));

    model.assignTeamMemberToRequirement(ID, model.getProjectList().
        getProject(inputAddProjectName.getText()).getEmployeeList().
        getEmployee(inputResponsibleTeamMember.getText()));

    model.getProjectList().getProject(inputAddProjectName.getText()).getRequirementList().getRequirement(ID).setDeadline(new MyDate(d,m,y));
  }

  public void setRemoveRequirement()
  {
    int ID = Integer.parseInt(inputAddRequirementID.getText());
    model.getProjectList().getProject(inputAddProjectName.getText()).getRequirementList().removeRequirement(ID);
  }

  public void setAccept() throws IOException
  {
    model.saveProject(inputAddProjectName.getText());
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
