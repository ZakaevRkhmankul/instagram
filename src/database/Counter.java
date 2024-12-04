package database;

public class Counter {
    public static Long userId= 0L;
    public static Long getUserId(){
        return ++userId;
    }
}
