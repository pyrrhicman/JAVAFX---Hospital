package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.getStylesheets().add(Controller.class.getResource("/sample.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.show();*/


        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();

        InputStream inputStream = getClass().getResource("/sample/sample.fxml").openStream();
        Pane pane = (Pane) loader.load(inputStream);

        Controller controller = (Controller) loader.getController();

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        scene.getStylesheets().add(Controller.class.getResource("/sample.css").toExternalForm());
        stage.setTitle("New Patient");
        stage.setResizable(true);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
