package cs112.ud2.controllers;

import cs112.ud2.MainApplication;
import cs112.ud2.models.Exercise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static cs112.ud2.models.Singleton.week;

public class WeekController {

    public static final int MONDAY_INDEX_VAL = 0;
    public static final int TUESDAY_INDEX_VAL = 1;
    public static final int WEDNESDAY_INDEX_VAL = 2;
    public static final int THURSDAY_INDEX_VAL = 3;
    public static final int FRIDAY_INDEX_VAL = 4;
    public static final int SATURDAY_INDEX_VAL = 5;
    public static final int SUNDAY_INDEX_VAL = 6;

    @FXML
    private ListView<String> listViewMonday;

    @FXML
    private ListView<String> listViewTuesday;

    @FXML
    private ListView<String> listViewWednesday;
    @FXML
    private ListView<String> listViewThursday;
    @FXML
    private ListView<String> listViewFriday;
    @FXML
    private ListView<String> listViewSaturday;
    @FXML
    private ListView<String> listViewSunday;




    public void dayIndexData(int index){
        dayIndex = index;
        System.out.println("week index passing to workout controller: " + dayIndex);
    }
    private int dayIndex;




    @FXML
    protected void onEditButtonMondayClick() throws IOException{

        workoutOpener(MONDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonTuesdayClick() throws IOException{
        workoutOpener(TUESDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonWednesdayClick() throws IOException{
        workoutOpener(WEDNESDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonThursdayClick() throws IOException{
        workoutOpener(THURSDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonFridayClick()throws IOException {
        workoutOpener(FRIDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonSaturdayClick()throws IOException {
        workoutOpener(SATURDAY_INDEX_VAL);
    }
    @FXML
    protected void onEditButtonSundayClick()throws IOException {
        workoutOpener(SUNDAY_INDEX_VAL);
    }

    @FXML
    protected void workoutOpener(int dayIndex)throws IOException{
        System.out.println("workoutOpener");

        //get FMXL file for popup
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("newWorkout-view.fxml"));
        Parent newWorkoutViewParent = loader.load();


        //pass info to the other controllers.
        //new workout
        NewWorkoutController newWorkoutController = loader.getController();
        newWorkoutController.setWeekController(this);

        newWorkoutController.dayIndexData(dayIndex);


        //create new stage for popup
        Stage popupStage = new Stage();
        //extra step: change modality, appmodal means it is the only window to interact with
        popupStage.initModality(Modality.APPLICATION_MODAL);
        //set scene
        popupStage.setScene(new Scene(newWorkoutViewParent));
        //show scene
        popupStage.show();
    }
    public void addFromWorkoutWindow(ObservableList<String> items){
        System.out.println("dddd"+dayIndex);
        switch (dayIndex) {
            case 0:

                listViewMonday.setItems(items);
                break;

            case 1:
                listViewTuesday.setItems(items);
                break;
            case 2:
                listViewWednesday.setItems(items);
                break;
            case 3:
                listViewThursday.setItems(items);
                break;
            case 4:
                listViewFriday.setItems(items);
                break;
            case 5:
                listViewSaturday.setItems(items);
                break;
            case 6:
                listViewSunday.setItems(items);
                break;
        }
    }



}
