package sample.View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;
import sample.util.ProjectFile;

import java.io.IOException;
import java.util.*;

public class ProjectOwnerController
{
  @FXML private Button cancel;
  @FXML private Button search;
  @FXML private Button approve;
  @FXML private Button notApprove;
  @FXML private Button add;
  @FXML private Button remove;
  @FXML private TextField inputAddRequirementName;
  @FXML private TextField day;
  @FXML private TextField month;
  @FXML private TextField year;
  @FXML private TableView<Requirement> requirementTable;
  @FXML private ComboBox<String> requirementPriority;
  @FXML private ComboBox<String> createRequirementPriority;
  @FXML private ComboBox<TeamMember> comboBoxResponsibleMember;
  @FXML private ComboBox<Project> comboBoxProjects;
  @FXML private TextArea createRequirementUserStory;

  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  private Project chosenProject; //Keeps track of which project we will add requirements to.


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

    initializeComboBoxes(); //Initializes the ComboBoxes on load;
  }

  public Region getRoot()
  {
    return root;
  }


  public void setApprove() throws IOException, ClassNotFoundException
  {

    int ID = requirementTable.getSelectionModel().getSelectedItem().getRequirementID();
    model.getRequirementList(chosenProject.getProjectName()).getRequirement(ID).setApprovement(true);
    //model.getRequirementList(chosenProject.getProjectName()).getRequirement(ID).setStatus("Godkendt");
    model.getProjectList().getProject(chosenProject.getProjectName())
        .getRequirementList().getRequirement(requirementTable.getSelectionModel().getSelectedItem().getRequirementID())
        .setStatus("Godkendt");
    model.saveProjectList();
    ProjectFile.save(model.getProjectList());
    //Refreshes the tableview, such that the new changes gets displayed
    populateTableView();
  }

  public void setNotApprove() throws IOException, ClassNotFoundException
  {
    int ID = requirementTable.getSelectionModel().getSelectedItem().getRequirementID();
    model.getRequirementList(chosenProject.getProjectName()).getRequirement(ID).setApprovement(false);
    model.getRequirementList(chosenProject.getProjectName()).getRequirement(ID).setStatus("Ikke godkendt");
    ProjectFile.save(model.getProjectList());
    //Refreshes the tableview, such that the new changes gets displayed
    populateTableView();

  }



  public void removeRequirement() throws IOException, ClassNotFoundException
  {
    int ID = requirementTable.getSelectionModel().getSelectedItem().getRequirementID();
    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList); //Makes sure the projectList for model is the saved version.
    model.getProjectList().getProject(chosenProject.getProjectName()).getRequirementList().removeRequirement(ID);
    model.saveProjectList();
    ProjectFile.save(model.getProjectList());
    //Refreshes the tableview, such that the new changes gets displayed
    populateTableView();
  }


  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }

  public void setChosenProject() throws IOException, ClassNotFoundException
  {
    //Loads all saved projects and set the inputted project as current project.

    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList); //Makes sure the projectList for model is the saved version.
    chosenProject = model.getProjectList().getProject(comboBoxProjects.getSelectionModel().getSelectedItem().getProjectName());

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

  public void populateTableView() throws IOException, ClassNotFoundException
  {
    /*
    * Method populates the tableView with all requirements
    * */


    //Resets table

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

  public void initializeComboBoxes() throws IOException, ClassNotFoundException
  {
    createRequirementPriority.getItems().addAll(
        "Lav","Normal","Høj","Kritisk"
    );

    requirementPriority.getItems().addAll(
        "Lav","Normal","Høj","Kritisk"
    );


    ArrayList<Project> systemProjects = model.readProjectList("ProjectList.bin").getAllProjects();
    comboBoxProjects.getItems().addAll(systemProjects);
  }

  public void initializeTeamMemberComboBox()
      throws IOException, ClassNotFoundException
  {
    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList);
    ArrayList<TeamMember> projectEmployees = model.getProjectList().getProject(comboBoxProjects.getValue().getProjectName()).getEmployeeList().getAllEmployees();
    comboBoxResponsibleMember.getItems().addAll(projectEmployees);
  }

  public void addRequirement() throws IOException, ClassNotFoundException
  {
    //Deadline data parsed to ints
    int d = Integer.parseInt(day.getText());
    int m = Integer.parseInt(month.getText());
    int y = Integer.parseInt(year.getText());

    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList);

    EmployeeList loadedEmployeeList = model.readEmployeeList("EmployeeList.bin");
    model.setEmployeeList(loadedEmployeeList);

    model.getProjectList().getProject(chosenProject.getProjectName()).addRequirement(
        inputAddRequirementName.getText(), model.getProjectList().getIdGenerator().generateRequirementID(), comboBoxResponsibleMember.getValue()
        ,"Ikke påbegyndt", createRequirementPriority.getValue(),new MyDate(d,m,y), createRequirementUserStory.getText());

    model.saveProjectList();
    model.saveEmployeeList();
    //Clears all textfields after adding requirement
    inputAddRequirementName.clear();
    day.clear();
    month.clear();
    year.clear();
    createRequirementUserStory.clear();
    //Refreshes the tableview, such that the new changes gets displayed
    populateTableView();
  }

  public void setRequirementPriority()
      throws IOException, ClassNotFoundException
  {
    int priorityChangeTargetID = requirementTable.getSelectionModel().getSelectedItem().getRequirementID();
    ProjectList loadedList = model.readProjectList("ProjectList.bin");
    model.setProjectList(loadedList);
    model.getProjectList().getProject(chosenProject.getProjectName()).getRequirementList()
        .getRequirement(priorityChangeTargetID).setPriority(requirementPriority.getValue());
    model.saveProjectList();
    model.saveEmployeeList();
    ProjectFile.save(model.getProjectList());

    //Refreshes the tableview, such that the new changes gets displayed
    populateTableView();
  }


  public void logOut()
  {
    viewHandler.openView("main");
  }

}
