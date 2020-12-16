package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AdminController
{
  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  @FXML private Button cancel;
  @FXML private TextField inputName;
  @FXML private TextField inputID;
  @FXML private ToggleGroup jaNej;
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
    try
    {
    RadioButton selectRadio = (RadioButton) jaNej.getSelectedToggle();
    EmployeeList loadedList = model.readEmployeeList("EmployeeList.bin");
    model.setEmployeeList(loadedList);
    ProjectList loadedProjectList = model.readProjectList("ProjectList.bin");


      if (selectRadio.getText().equals("Ja"))
      {
        model.addEmployeeToSystem(inputName.getText(), model.getProjectList().getIdGenerator().generateTeamMemberID(), "projectcreator");

      }
      else
      {
        model.addEmployeeToSystem(inputName.getText(), model.getProjectList().getIdGenerator().generateTeamMemberID(), "teammember");

      }
    } catch(FileNotFoundException e)
    {
      model.getEmployeeList().addEmployee(new TeamMember(inputName.getText(), model.getProjectList().getIdGenerator().generateProjectID(),"teammember"));
    }



      model.saveEmployeeList();

      memberCreatedLabel.setVisible(true);
      inputName.clear();
    }

  public void removeEmployee() throws IOException, ClassNotFoundException
  {
    EmployeeList loadedList = model.readEmployeeList("EmployeeList.bin");
    model.setEmployeeList(loadedList);

    for (TeamMember teamMember : model.getEmployeeList().getAllEmployees())
    {
      if (teamMember.getEmployeeID() == Integer.parseInt(inputID.getText()))
      {
        model.getEmployeeList().removeEmployee(teamMember.getEmployeeID());
      }
    }
    model.saveEmployeeList();
    memberRemovedLabel.setVisible(true);
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
