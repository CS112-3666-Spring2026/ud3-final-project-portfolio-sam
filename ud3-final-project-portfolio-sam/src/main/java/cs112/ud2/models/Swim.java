package cs112.ud2.models;

public class Swim extends Exercise{
    public static final int DEFAULT_LAPS = 0;
    public static final int DEFAULT_DISTANCE = 0;

    private int laps;
    private int distance;
    //default constructor
    Swim() {
        super(DEFAULT_NAME,DEFAULT_SETS);
        this.laps = DEFAULT_LAPS;
        this.distance = DEFAULT_SETS;
    }
    //regular constructor
    public Swim(String name,int sets, int laps, int distance) {
        super(name,sets);
        this.laps = laps;
        this.distance = distance;
    }
    //copy constructor
    public Swim(Swim other) {
        super(other.getName(),other.getSets());
        this.laps = other.laps;
        this.distance = other.distance;
    }
    //accessors
    public int getLaps() {
        return this.laps;
    }

    public int getDistance() {
        return this.distance;
    }
    //mutators
    public void setLaps(int laps) {
        this.laps = laps;
    }

    public boolean setDistance(int distance) {
        if (distance < 0) {
            return false;
        }
        this.distance = distance;
        return true;
    }

    public boolean equals(Object other) {
        //return false if the compare object is null or isn't the same type.
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Swim that = (Swim) other;
        //compares the variables
        return this.laps == ((Swim) other).laps && this.distance == that.distance;
    }

    public String toString() {
        return String.format("Name: %s  Sets: %d  Laps: %d  Distance: %d", super.getName(), super.getSets(),this.laps,this.distance);
    }
}
