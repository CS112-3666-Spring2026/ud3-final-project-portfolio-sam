package cs112.ud2;

import cs112.ud2.models.Week;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("week-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 920, 350);
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("event-view.fxml"));
//        Scene scene = new Scene(f   xmlLoader.load(), 600, 400);
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("map-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 700, 465);
        stage.setTitle("WORKOUT PLANNER");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
