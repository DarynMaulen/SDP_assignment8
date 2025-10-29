package element.concrete;

import element.Shape;
import visitor.ShapeVisitor;

// Rectangle - concrete Shape representing an axis-aligned rectangle.
public class Rectangle implements Shape {
    private final double width;
    private final double height;

    // Construct a Rectangle with the given width and height.
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Returns the rectangle width.
    public double getWidth() {
        return width;
    }

    // Returns the rectangle height.
    public double getHeight() {
        return height;
    }

    // Accept a visitor and dispatch to visitor.visit(this).
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
