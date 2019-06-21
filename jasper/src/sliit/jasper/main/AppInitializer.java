package sliit.jasper.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/ijse/dep/jasper/view/MainView.fxml"));
//        Parent root = loader.load();

        Parent root = FXMLLoader.load(this.getClass().getResource("/sliit/jasper/view/MainView.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("report");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

}
