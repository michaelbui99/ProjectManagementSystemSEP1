package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;

public class TeamMemberController
{
  @FXML private Button cancel;

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
