package Pattern.DecoratorPattern;

/**
 * Created by mayz985 on 9/9/16.
 */
public class ShapeDecorator implements ShapeInterface {
    ShapeInterface realShape;

    ShapeDecorator(ShapeInterface realShpae) {
        this.realShape = realShpae;
    }

    public void draw() {
        realShape.draw();
        colorIt();
    }

    public void colorIt() {
        System.out.println("add some color to it");
    }

}
