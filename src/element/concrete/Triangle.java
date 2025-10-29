package element.concrete;

import element.Shape;
import visitor.ShapeVisitor;

// Triangle - concrete Shape represented by base and height.
public class Triangle implements Shape {
    private final double base;
    private final double height;

    // Construct a Triangle with the given base and height.
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Returns the triangle base.
    public double getBase() {
        return base;
    }

    // Returns the triangle height.
    public double getHeight() {
        return height;
    }

    // Accept a visitor and dispatch to visitor.visit(this).
    @Override
    public void accept(ShapeVisitor visitor){
        visitor.visit(this);
    }
}
