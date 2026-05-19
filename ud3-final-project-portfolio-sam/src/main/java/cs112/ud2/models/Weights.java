package cs112.ud2.models;

public class Weights extends Exercise{
    public static final int DEFAULT_REPS = 0;
    public static final int DEFAULT_WEIGHTS = 0;

    private int reps;
    private int weight;
    //default constructor
    Weights() {
        super(DEFAULT_NAME,DEFAULT_SETS);
        this.reps = DEFAULT_REPS;
        this.weight = DEFAULT_SETS;
    }
    //regular constructor
    public Weights(String name,int sets, int reps, int weight) {
        super(name,sets);
        this.reps = reps;
        this.weight = weight;
    }
    //copy constructor
    public Weights(Weights other) {
        super(other.getName(),other.getSets());
        this.reps = other.reps;
        this.weight = other.weight;
    }
    //accessors
    public int getReps() {
        return this.reps;
    }

    public int getWeight() {
        return this.weight;
    }
    //mutators
    public void setReps(int reps) {
        this.reps = reps;
    }

    public boolean setWeight(int weight) {
        if (weight < 0) {
            return false;
        }
        this.weight = weight;
        return true;
    }

    public boolean equals(Object other) {
        //return false if the compare object is null or isn't the same type.
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Weights that = (Weights) other;
        //compares the variables
        return this.reps == ((Weights) other).reps && this.weight == that.weight;
    }

    public String toString() {
        return String.format("Name: %s Sets: %d Reps: %d Weight: %d", super.getName(), super.getSets(),this.reps,this.weight);
    }
}
