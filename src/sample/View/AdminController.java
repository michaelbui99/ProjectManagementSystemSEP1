package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.EmployeeList;
import sample.Model.ManagementSystemModel;
import sample.Model.TeamMember;

import java.util.ArrayList;

public class AdminController
{
  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;
  private EmployeeList employeeList;
  @FXML private Button cancel;
  @FXML private TextField inputName;
  @FXML private TextField inputTeamMemberName;
  @FXML private TextField inputID;
  @FXML private ToggleGroup jaNej;
  @FXML private Button add;
  @FXML private Button remove;
  @FXML private Button approve;
  @FXML private Label Status;



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
/*
  public void setName(String name)
  {
    ArrayList<EmployeeList> employeeLists1 = new ArrayList<>();

    for (int i = 0; i < employeeLists1.size(); i++)
    {
      employeeLists1.get(i).a
    }
  }
*/
  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }
}
