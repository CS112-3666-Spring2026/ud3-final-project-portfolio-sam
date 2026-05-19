package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Exercise;
import cs112.ud2.models.Weights;
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

public class WeightsController {
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
    private TextField weightsNameTextField;
    @FXML
    private TextField weightsRepsTextField;
    @FXML
    private TextField weightsWeightTextField;

    @FXML
    private TextField weightsSetsTextField;

    @FXML
    private ListView<String> weightsTextField;




    @FXML
    protected void onWeightsAddButtonClick() {



        Exercise weights = new Weights(weightsNameTextField.getText(), Integer.parseInt(weightsSetsTextField.getText()),Integer.parseInt(weightsRepsTextField.getText()),Integer.parseInt(weightsWeightTextField.getText()));
        week.workouts[dayIndex].addExercise(weights);

        ObservableList<String> observableExercises = FXCollections.observableArrayList();
        for (Exercise exercise : week.workouts[dayIndex].getExercises()){
            observableExercises.add(exercise.toString());
        }


        weightsTextField.setItems(observableExercises);

//        System.out.println(weights.toString());
    }

    @FXML
    protected void onWeightsSaveButtonClick() throws IOException {
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


        //pass the data from this class to weights
        weekController.dayIndexData(dayIndex);

        ObservableList<String> observableExercises = FXCollections.observableArrayList();
        for (Exercise exercise : week.workouts[dayIndex].getExercises()){
            observableExercises.add(exercise.toString());
        }



        weekController.addFromWorkoutWindow(observableExercises);
    }
    @FXML
    protected void onWeightsBackClick(){
        System.out.println("weights back button clicked");
    }

}
