package sample.View;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;

import javax.swing.text.TableView;
import java.io.IOException;
import java.util.Locale;

public class ColourITMainController
{
  @FXML private Button next;
  @FXML private Button cancel;
  @FXML private ToggleGroup role;
  private ManagementSystemModel model;
  private ViewHandler viewHandler;
  private Region root;


  public void setModel(ManagementSystemModel model)
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

  public void setRole()
  {
    RadioButton selectRadio = (RadioButton) role.getSelectedToggle();
    model.setUser(selectRadio.getText());

    if (model.getUser().toLowerCase().equals("admin"))
    {
      viewHandler.openView("admin");
    }
    else if (model.getUser().toLowerCase().equals("projectowner"))
    {
      viewHandler.openView("projectOwner");
    }
    else if (model.getUser().toLowerCase().equals("projektcreator"))
    {
      viewHandler.openView("projektCreator");
    }
    else if (model.getUser().toLowerCase().equals("scrummaster"))
    {
      viewHandler.openView("scrumMaster");
    }
    else if (model.getUser().toLowerCase().equals("teammemberview"))
    {
      viewHandler.openView("teamMemberView");
    }
  }

  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }


}
