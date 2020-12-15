package sample;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.Model.ManagementSystemModel;
import sample.View.ViewHandler;

        public class Main extends Application {
    private Image logo;

    @Override
    public void start(Stage primaryStage) throws Exception{
        ManagementSystemModel model = new ManagementSystemModel();
        ViewHandler viewHandler = new ViewHandler(model);
        viewHandler.start(primaryStage);
        primaryStage.setTitle("Colour-IT");
        primaryStage.getIcons().add(logo = new Image("file:img/colour_it_logo3.png"));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

