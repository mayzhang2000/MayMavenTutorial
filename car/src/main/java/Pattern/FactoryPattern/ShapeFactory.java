package Pattern.FactoryPattern;

import Pattern.DecoratorPattern.RoundShape;
import Pattern.DecoratorPattern.Shape;

/**
 * Created by mayz985 on 9/9/16.
 */
public class ShapeFactory {
    Shape getShape(String shapeName) {
        if (shapeName == null) return null;

        if (shapeName.equalsIgnoreCase("round") ){
            return new RoundShape();
        }
        return null;
    }
}
