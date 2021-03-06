package sample.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;

import java.io.IOException;

public class ViewHandler
{

  private Scene currentScene;
  private Stage primaryStage;

  private AdminController adminController;
  private ColourITMainController colourITMainController;
  private ProjectOwnerController projectOwnerController;
  private ProjektCreatorController projektCreatorController;
  private ScrumMasterController scrumMasterController;
  private TeamMemberController teamMemberController;
  private ManagementSystemModel model;

  public ViewHandler(ManagementSystemModel model)
  {
    this.model = model;
    currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("main");
  }

  public void openView(String role)
  {
    Region root = null;
    switch (role)
    {
      case "admin":
        root = loadAdminView();
        break;
      case "main":
        root = loadMainView();
        break;
      case "projectowner":
        root = loadProjectOwnerView();
        break;
      case "projektcreator":
        root = loadProjektCreatorView();
        break;
      case "scrummaster":
        root = loadScrumMasterView();
        break;
      case "teammember":
        root = loadTeamMemberView();
        break;
      default:
        System.out.println("None role set yet.");
        break;
    }
    currentScene.setRoot(root);
    primaryStage.setTitle((String) root.getUserData());
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadAdminView()
  {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Admin.fxml"));
        Region root = loader.load();
        adminController = loader.getController();
        adminController.init(this, model, root);
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }

    return adminController.getRoot();

  }

  private Region loadMainView()
  {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ColourITMain.fxml"));
        Region root = loader.load();
        colourITMainController = loader.getController();
        colourITMainController.init(this, model, root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

    return colourITMainController.getRoot();
  }

  private Region loadProjectOwnerView()
  {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjectOwner.fxml"));
        Region root = loader.load();
        projectOwnerController = loader.getController();
        projectOwnerController.init(this, model, root);
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }

    return projectOwnerController.getRoot();
  }

  private Region loadProjektCreatorView()
  {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ProjektCreator.fxml"));
        Region root = loader.load();
        projektCreatorController = loader.getController();
        projektCreatorController.init(this, model, root);
      }
      catch (IOException | ClassNotFoundException e)
      {
        e.printStackTrace();
      }

    return projektCreatorController.getRoot();
  }


    private Region loadScrumMasterView ()
    {
        try
        {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("ScrumMaster.fxml"));
          Region root = loader.load();
          scrumMasterController = loader.getController();
          scrumMasterController.init(this, model, root);
        }
        catch (IOException | ClassNotFoundException e)
        {
          e.printStackTrace();
        }

      return scrumMasterController.getRoot();
    }

    private Region loadTeamMemberView ()
    {
        try
        {
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("TeamMemberGUI.fxml"));
          Region root = loader.load();
          teamMemberController = loader.getController();
          teamMemberController.init(this, model, root);
        }
        catch (IOException | ClassNotFoundException e)
        {
          e.printStackTrace();
        }

      return teamMemberController.getRoot();
    }

  }

