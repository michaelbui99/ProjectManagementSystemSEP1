package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class TeamMemberController
{
  @FXML private Button cancel;
  @FXML private Button accept;
  @FXML private Button search;
  @FXML private Button save;
  @FXML private Button showAllProjects;
  @FXML private TextField inputTime;
  @FXML private TableView<Requirement> requirementTable;
  @FXML private TableView<Task> taskTable;
  @FXML private TableView<TeamMember> memberTableView;
  @FXML private ComboBox<TeamMember> teamMemberComboBox;
  @FXML private ComboBox<Project> comboBoxProjects;


  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  private Project chosenProject;
  private Requirement chosenRequirement;
  private Task chosenTask;


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

    initializeComboBoxes();
  }

  public Region getRoot()
  {
    return root;
  }



  public void setSave()
  {
    setChosenTask();
    int reqID = chosenRequirement.getRequirementID();
    int taskID = chosenTask.getID();
    int time = Integer.parseInt(inputTime.getText());

    model.registerTaskTime(time,reqID,taskID);
  }



  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }

  public void initializeComboBoxes() throws IOException, ClassNotFoundException
  {
  /*
  * Method initializes all ComboBoxes.
  * */
    ArrayList<Project> systemProjects = model.readProjectList("ProjectList.bin").getAllProjects();
    comboBoxProjects.getItems().addAll(systemProjects);
    ArrayList<TeamMember> systemEmployees = model.readEmployeeList("EmployeeList.bin").getAllEmployees();

  }


  public void setChosenProject() throws IOException, ClassNotFoundException
  {
    /*
    * Method sets the current Project the user is editing/viewing.
    * */
    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList); //Makes sure the projectList for model is the saved version.
    chosenProject = model.getProjectList().getProject(comboBoxProjects.getValue().getProjectName());
  }

  public ObservableList<Requirement> getAllRequirements()
      throws IOException, ClassNotFoundException
  {
    /*
     * Method used for loading Requirements to the tableView.
     * */

    ObservableList<Requirement> requirements = FXCollections.observableArrayList();
    //Reading projectList file and getting requirements of chosen project
    ArrayList<Requirement> projectRequirements = model.readProjectList("ProjectList.bin")
        .getProject(chosenProject.getProjectName()).getRequirementList().getAllRequirements();

    //Adding all requirements to observable list.
    requirements.addAll(projectRequirements);
    return requirements;
  }

  public ObservableList<Task> getAllTasks()
      throws IOException, ClassNotFoundException
  {
    /*
     * Method used for loading Requirements to the tableView.
     * */

    ObservableList<Task> tasks = FXCollections.observableArrayList();
    //Reading projectList file and getting requirements of chosen project
    ArrayList<Task> projectTasks = model.readProjectList("ProjectList.bin")
        .getProject(chosenProject.getProjectName()).getRequirementList().getRequirement(requirementTable
            .getSelectionModel().getSelectedItem().getRequirementID()).getTaskList().getAllTasks();

    //Adding all requirements to observable list.
    tasks.addAll(projectTasks);
    return tasks;
  }

  public void populateTableViewRequirement() throws IOException, ClassNotFoundException
  {
    /*
     * Method populates the tableView with all requirements
     * */
    setChosenProject();


    //Resets table to prevent adding new columns on refresh
    requirementTable.getItems().clear();
    requirementTable.getColumns().clear();

    //Name column
    TableColumn<Requirement,String> nameColumn = new TableColumn<>("Navn");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    //ID column
    TableColumn<Requirement,Integer> IDColumn = new TableColumn<>("ID");
    IDColumn.setCellValueFactory(new PropertyValueFactory<>("requirementID"));

    //responsible TeamMember column
    TableColumn<Requirement,TeamMember> responsibleMemberColumn = new TableColumn<>("Ansvarlig Teammedlem");
    responsibleMemberColumn.setCellValueFactory(new PropertyValueFactory<>("responsibleTeamMember"));

    //Status column
    TableColumn<Requirement,String> statusColumn = new TableColumn<>("Status");
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    //Priority column
    TableColumn<Requirement,String> priorityColumn = new TableColumn<>("Prioritet");
    priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));

    //Time spent column
    TableColumn<Requirement,Integer> timeSpentColumn = new TableColumn<>("Tid Brugt");
    timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpendInHours"));

    //Deadline column
    TableColumn<Requirement,MyDate> deadlineColumn = new TableColumn<>("Deadline");
    deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    //Creation Date column
    TableColumn<Requirement,MyDate> creationDateColumn = new TableColumn<>("Oprettelsesdato");
    creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));

    //Estimated completion time column
    TableColumn<Requirement,Double> estimatedCompletionTimeColumn = new TableColumn<>("Estimeret afslutningstid");
    estimatedCompletionTimeColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedCompletionTimeInHours"));

    //User Story column
    TableColumn<Requirement, String> userStoryColumn = new TableColumn<>("User Story");
    userStoryColumn.setCellValueFactory(new PropertyValueFactory<>("userStory"));



    requirementTable.setItems(getAllRequirements());
    requirementTable.getColumns().addAll(nameColumn, IDColumn,responsibleMemberColumn,statusColumn,
        priorityColumn, timeSpentColumn, deadlineColumn, creationDateColumn, estimatedCompletionTimeColumn, userStoryColumn);
  }

  public void populateTableViewTask() throws IOException, ClassNotFoundException
  {
    setChosenProject();
    setChosenRequirement();

    //Resets TableView to prevent adding new columns on refresh
    //Name column
    TableColumn<Task,String> nameColumn = new TableColumn<>("Navn");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    //ID column
    TableColumn<Task,Integer> IDColumn = new TableColumn<>("ID");
    IDColumn.setCellValueFactory(new PropertyValueFactory<>("taskID"));

    //responsible TeamMember column
    TableColumn<Task,TeamMember> responsibleMemberColumn = new TableColumn<>("Ansvarlig Teammedlem");
    responsibleMemberColumn.setCellValueFactory(new PropertyValueFactory<>("responsibleTeamMember"));

    //Status column
    TableColumn<Task,String> statusColumn = new TableColumn<>("Status");
    statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    //Priority column
    TableColumn<Task,String> priorityColumn = new TableColumn<>("Prioritet");
    priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));

    //Time spent column
    TableColumn<Task,Integer> timeSpentColumn = new TableColumn<>("Tid Brugt");
    timeSpentColumn.setCellValueFactory(new PropertyValueFactory<>("timeSpendInHours"));

    //Deadline column
    TableColumn<Task,MyDate> deadlineColumn = new TableColumn<>("Deadline");
    deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

    //Creation Date column
    TableColumn<Task,MyDate> creationDateColumn = new TableColumn<>("Oprettelsesdato");
    creationDateColumn.setCellValueFactory(new PropertyValueFactory<>("creationDate"));

    //Estimated completion time column
    TableColumn<Task,Double> estimatedCompletionTimeColumn = new TableColumn<>("Estimeret afslutningstid");
    estimatedCompletionTimeColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedCompletionTimeInHours"));

    taskTable.setItems(getAllTasks());
    taskTable.getColumns().addAll(nameColumn, IDColumn,responsibleMemberColumn,statusColumn,
        priorityColumn, timeSpentColumn, deadlineColumn, creationDateColumn, estimatedCompletionTimeColumn);
  }

  public void setChosenRequirement()
  {
    chosenRequirement = requirementTable.getSelectionModel().getSelectedItem();
  }

  public void setChosenTask()
  {
    chosenTask = taskTable.getSelectionModel().getSelectedItem();

  }


  public void logOut()
  {
    /*
    * Method returns the user to Main menu, where the user can choose a new role.
    * */
    viewHandler.openView("main");
  }
}
