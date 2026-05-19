package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Week;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static cs112.ud2.models.Singleton.week;

public class NewWorkoutController {
    private WeekController weekController;

    public void setWeekController(WeekController weekController){
        this.weekController = weekController;
    }
    //passing in which day the user clicked on to add the workout
    public void dayIndexData(int index){
        dayIndex = index;
        System.out.println("week index passing to swim or weights controller: " + dayIndex);
    }

    private int dayIndex;




    @FXML
    private TextField workoutNameEntry;








    @FXML
//    protected void onSwimButtonClick(ActionEvent actionEvent) throws IOException {
//
//        //
//        createNewWorkoutWithName();
//
//        //get swim view as a scene
//        FXMLLoader loader = new FXMLLoader();
//        Parent swimView = FXMLLoader.load(MainApplication.class.getResource("swim-view.fxml"));
//
//        Scene swimViewScene = new Scene(swimView);
//
//
//        // get stage
//        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
//        //set scene to swim
//        window.setScene(swimViewScene);
//        //show the stage
//        window.show();
//    }
    protected void onSwimButtonClick(ActionEvent actionEvent) throws IOException {

        createNewWorkoutWithName();

        // get Fmxl file
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("swim-view.fxml"));

        //Load parent
        Parent swimView = loader.load();

        //Get swimcontroller
        SwimController swimController = loader.getController();

        swimController.setWeekController(this.weekController);

        //pass the data from this class to swim
        swimController.dayIndexData(dayIndex);

        // change to swim scene
        Scene swimViewScene = new Scene(swimView);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(swimViewScene);
        window.show();
    }

    @FXML
    protected void onWeightsButtonClick(ActionEvent actionEvent) throws IOException {
        createNewWorkoutWithName();

        // get Fmxl file
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("weights-view.fxml"));

        //Load parent
        Parent weightsView = loader.load();

        //Get weightscontroller
        WeightsController weightsController = loader.getController();

        weightsController.setWeekController(this.weekController);

        //pass the data from this class to swim
        weightsController.dayIndexData(dayIndex);

        // change to swim scene
        Scene swimViewScene = new Scene(weightsView);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(swimViewScene);
        window.show();
    }
    private void createNewWorkoutWithName(){
        week.addWorkout(dayIndex);
        week.workouts[dayIndex].setName(workoutNameEntry.getText());
        System.out.println(week.workouts[dayIndex].getName());
    }


}
