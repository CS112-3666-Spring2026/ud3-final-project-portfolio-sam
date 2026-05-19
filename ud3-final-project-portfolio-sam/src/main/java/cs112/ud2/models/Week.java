package cs112.ud2.models;

import java.util.ArrayList;

public class Week {

    public Workout[] workouts;

    public Week(){
        this.workouts = new Workout[7];
    }


    public void addWorkout(int i){

        this.workouts[i] = new Workout();

    }

//    public void setWorkout(int i){
//        workouts[i].setName("");
//    }
    public class Workout extends Exercise{
        private String name;

        private ArrayList<Exercise> exercises;
        Workout(){
            this.exercises = new ArrayList<>();
        }
        Workout(String name){
            this.name = name;
            this.exercises = new ArrayList<>();
        }

        Workout(Workout other){
            this.exercises = other.exercises;
        }


        public void addExercise(Exercise exercise){
            this.exercises.add(exercise);
        }

        public ArrayList<Exercise> getExercises(){
            return exercises;
        }

        @Override
        public String toString(){

            return this.exercises.toString();
        }
    }
}
