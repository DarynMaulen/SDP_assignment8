package element.concrete;

import element.Shape;
import visitor.ShapeVisitor;

// Circle - concrete Shape representing a circle defined by its radius.
public class Circle implements Shape {
    private final double radius;

    // Construct a Circle with the given radius.
    public Circle(double radius) {
        this.radius = radius;
    }

    // Returns the radius of the circle.
    public double getRadius(){
        return radius;
    }

    // Accept a visitor and dispatch to visitor.visit(this).
    @Override
    public void accept(ShapeVisitor visitor){
        visitor.visit(this);
    }
}
