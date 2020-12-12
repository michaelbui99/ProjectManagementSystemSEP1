package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;
import sample.View.ViewHandler;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ManagementSystemModel model = new ManagementSystemModel();
        ViewHandler viewHandler = new ViewHandler(model);
        viewHandler.start(primaryStage);
        primaryStage.setTitle("Colour-IT");
    }


    public static void main(String[] args) {
        launch(args);
    }
}

