package cs112.ud2.models;

public class Singleton {
    private static Singleton instance;
// static block initionalization. Creates instance immediatly and checks for exception.
    static{
        try{
            instance = new Singleton();
        } catch (Exception e){
            throw new RuntimeException("Exception when creating the Singleton");
        }
    }
    public static Singleton getInstance(){
        return instance;
    }

    public static final Week week = new Week();
}
