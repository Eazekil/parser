package entities;

public class NumberId {
    private static volatile long Id=0;

    public static long getId() {
        Id++;
        return Id;
    }

}
