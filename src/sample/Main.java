package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("UPN/RPN Calculator");
            primaryStage.setScene(new Scene(root, 800, 400));
            primaryStage.show();
        }
        catch(Exception ex){
            System.err.println("Error!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
