package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

public class ScrumMasterController
{
  @FXML
  private TextField responsibleMember;

  @FXML
  private TextField projectName;

  @FXML
  private Button chooseProjectBtn;

  @FXML
  private TextField reqID;

  @FXML
  private Button chooseReqBtn;

  @FXML
  private Button approveChangesBtn;

  @FXML
  private ToggleGroup reqPriority;

  @FXML
  private ToggleGroup reqStatus;

  @FXML
  private TextField taskName;

  @FXML
  private Button addTaskBtn;

  @FXML
  private TextField taskID;

  @FXML
  private Label responsibleError;

  @FXML
  private ToggleGroup taskPriority;

  @FXML
  private TextField deadlineDay;

  @FXML
  private TextField deadlineYear;

  @FXML
  private TextField deadlineMonth;


  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  private Requirement chosenRequirement;
  private Project chosenProject;


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


  public void chooseProject()
  {
    if (projectName.getText() != null || projectName.getText()!= "")
    {
      chosenProject = model.getProjectList().getProject(projectName.getText());
    }
    else
    projectName.setPromptText("ERROR TRY AGAIN");
  }

  public void chooseRequirement()
  {
    chosenRequirement = chosenProject.getRequirementList().getRequirement(Integer.parseInt(reqID.getText()));
  }

  public void editRequirement()
  {
    RadioButton selectedReqPriority = (RadioButton) reqPriority.getSelectedToggle();
    chosenRequirement.setPriority(selectedReqPriority.getText());

    RadioButton selectedReqStatus = (RadioButton) reqStatus.getSelectedToggle();
    chosenRequirement.setStatus(selectedReqStatus.getText());
  }

  public void addTask()
  {
    RadioButton selectedTaskPrio = (RadioButton) taskPriority.getSelectedToggle();
    String responsibleName = responsibleMember.getText();
    TeamMember responsibleMember = chosenRequirement.getEmployees().getEmployee(responsibleName);
    chosenRequirement.getTaskList().addTask(new Task(taskName.getText(),Integer.parseInt(taskID.getText()),"Ikke påbegyndt",responsibleMember,selectedTaskPrio.getText(),new MyDate(Integer.parseInt(deadlineDay.getText()),Integer.parseInt(deadlineMonth.getText()),Integer.parseInt(deadlineYear.getText()))));
  }


  public void saveRequirementList()
  {

  }



}
