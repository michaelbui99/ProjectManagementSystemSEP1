package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;
import sample.View.ViewHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ManagementSystemModel model = new ManagementSystemModel();
        ViewHandler viewHandler = new ViewHandler(model);
        viewHandler.start(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

