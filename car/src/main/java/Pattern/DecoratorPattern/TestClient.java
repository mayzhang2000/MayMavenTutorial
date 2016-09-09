package Pattern.DecoratorPattern;

/**
 * Created by mayz985 on 9/9/16.
 */
public class TestClient {
    public static void main(String[] args) {
        new ShapeDecorator(new RoundShape()).draw();
    }
}
