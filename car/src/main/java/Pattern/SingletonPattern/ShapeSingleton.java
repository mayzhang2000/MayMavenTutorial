package Pattern.SingletonPattern;

/**
 * Created by mayz985 on 9/9/16.
 */
public class ShapeSingleton {
    private static ShapeSingleton myObject;
    private ShapeSingleton() {}

    public static ShapeSingleton getShapeSingleton() {
        if(myObject == null) {
            myObject = new ShapeSingleton();
        }
        return myObject;

    }

    public static void main(String[] strings) {
        ShapeSingleton.getShapeSingleton();
    }

}
