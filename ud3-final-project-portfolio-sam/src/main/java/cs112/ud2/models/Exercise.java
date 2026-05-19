package cs112.ud2.models;

/***
 <<Abstract>>
 Exercise
 - name: String
 - sets: int
 + Exercise()
 + Exercise(name: String,sets: int)
 + Exercise(other: Exercise)
 + getName(): String
 + setName(name: String): void
 + getSets(): int
 + setSets(sets: int): void
 + setAll (name: String, muscle: String, sets: int): void
 + equals(obj: Object): boolean
 + toString(): String
 *
 */



//Abstract class, parent of both Weights and Swim

public abstract class Exercise {
    public static final String DEFAULT_NAME = "Squat";
    public static final int DEFAULT_SETS = 3;

    private String name;
    private int sets;
    //default constructor
    Exercise() {
        this.name = DEFAULT_NAME;
        this.sets = DEFAULT_SETS;
    }
    //regular constructor
    Exercise(String name, int sets) {
        this.name = name;
        this.sets = sets;
    }
    //copy constructor
    Exercise(Exercise other) {
        this.name = other.name;
        this.sets = other.sets;
    }
    //accessors
    public String getName() {
        return this.name;
    }

    public int getSets() {
        return this.sets;
    }
    //mutators
    public void setName(String name) {
        this.name = name;
    }

    public boolean setSets(int sets) {
        if (sets < 0) {
            return false;
        }
        this.sets = sets;
        return true;
    }

    public boolean equals(Object other) {
        //return false if the compare object is null or isn't the same type.
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Exercise that = (Exercise) other;
        //compares the variables
        return this.name.equals(that.name) && this.sets == that.sets;
    }

    public String toString() {
        return String.format("Name: %s\nSets: %d", this.name, this.sets);
    }
}