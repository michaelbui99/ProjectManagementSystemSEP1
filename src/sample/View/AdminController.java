package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.IOException;
import java.util.ArrayList;

public class AdminController
{
  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  private EmployeeList employeeList;
  @FXML private Button cancel;
  @FXML private TextField inputName;
  @FXML private TextField inputTeamMemberID;
  @FXML private TextField inputID;
  @FXML private ToggleGroup jaNej;
  @FXML private Button add;
  @FXML private Button remove;
  @FXML private Label memberCreatedLabel;
  @FXML private Label memberRemovedLabel;


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


  public void addTeamMember() throws IOException, ClassNotFoundException
  {
    RadioButton selectRadio = (RadioButton) jaNej.getSelectedToggle();
    EmployeeList loadedList = model.readEmployeeList("EmployeeList.bin");
    model.setEmployeeList(loadedList);

    //ArrayList<EmployeeList> employeeLists1 = new ArrayList<>();
    /*for (int i = 0; i < model.getEmployeeList().getAllEmployees().size(); i++)
    {*/
      if (selectRadio.getText().equals("Ja"))
      {
        model.addEmployeeToSystem(inputName.getText(), model.getProjectList().getIdGenerator().generateTeamMemberID(), "projectcreator");
        //model.getEmployeeList().addEmployee(teamMemberToAdd);

      }
      else
      {
        model.addEmployeeToSystem(inputName.getText(), model.getProjectList().getIdGenerator().generateTeamMemberID(), "teammember");

      }

      model.saveEmployeeList();

      memberCreatedLabel.setVisible(true);
      inputName.clear();
    }

  public void removeEmployee() throws IOException, ClassNotFoundException
  {
    EmployeeList loadedList = model.readEmployeeList("EmployeeList.bin");
    model.setEmployeeList(loadedList);

    for (TeamMember teamMember : employeeList.getAllEmployees())
    {
      if (teamMember.getEmployeeID() == Integer.parseInt(inputID.getText()))
      {
        employeeList.removeEmployee(teamMember.getEmployeeID());
      }
    }
    model.saveEmployeeList();
    memberRemovedLabel.setVisible(true);
    inputTeamMemberID.clear();
  }

  public void logOut()
  {
    viewHandler.openView("main");
  }

  public void setApprove() throws IOException
  {

    model.saveEmployeeList();
  }

  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }

}
