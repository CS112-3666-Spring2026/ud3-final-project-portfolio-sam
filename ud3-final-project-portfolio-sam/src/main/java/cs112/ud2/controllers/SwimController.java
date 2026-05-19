package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Exercise;
import cs112.ud2.models.Swim;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;

import static cs112.ud2.models.Singleton.week;

public class SwimController {
    private WeekController weekController;
    public void setWeekController(WeekController weekController){
        this.weekController = weekController;
    }


    public void dayIndexData(int index){
        dayIndex = index;
        System.out.println("week index passing to workout controller: " + dayIndex);
    }
    private int dayIndex;

    @FXML
    private TextField swimNameTextField;
    @FXML
    private TextField swimLapsTextField;
    @FXML
    private TextField swimDistanceTextField;

    @FXML
    private TextField swimSetsTextField;

    @FXML
    private ListView<String> swimListView;




    @FXML
    protected void onSwimAddButtonClick() {



        Exercise swim = new Swim(swimNameTextField.getText(), Integer.parseInt(swimSetsTextField.getText()),Integer.parseInt(swimLapsTextField.getText()),Integer.parseInt(swimDistanceTextField.getText()));
        week.workouts[dayIndex].addExercise(swim);

        ObservableList<String> observableExercises = FXCollections.observableArrayList();
        for (Exercise exercise : week.workouts[dayIndex].getExercises()){
            observableExercises.add(exercise.toString());
        }


        swimListView.setItems(observableExercises);

//        System.out.println(swim.toString());
    }

    @FXML
    protected void onSwimSaveButtonClick() throws IOException {
//        //get FMXL file for popup
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainApplication.class.getResource("week-view.fxml"));
//
//
//
//        //pass info to the other controllers.
//        //new workout
//        WeekController weekController = loader.getController();
//        weekController.dayIndexData(dayIndex);
        // get Fmxl file


        //pass the data from this class to swim
        weekController.dayIndexData(dayIndex);

        ObservableList<String> observableExercises = FXCollections.observableArrayList();
        for (Exercise exercise : week.workouts[dayIndex].getExercises()){
            observableExercises.add(exercise.toString());
        }



        weekController.addFromWorkoutWindow(observableExercises);
    }
    @FXML
    protected void onSwimBackClick(){
        System.out.println("swim back button clicked");
    }

}
