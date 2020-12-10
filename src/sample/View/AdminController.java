package sample.View;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.awt.*;

public class AdminController
{

  @FXML private Button cancel;

  public void setCancel()
  {
    Stage stage = (Stage) cancel.getScene().getWindow();
    stage.close();
  }
}

