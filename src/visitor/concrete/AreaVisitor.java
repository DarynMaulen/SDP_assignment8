package visitor.concrete;

import element.Shape;
import element.concrete.*;
import visitor.ShapeVisitor;

// AreaVisitor - computes area for shapes. Result stores the computed value.
public class AreaVisitor implements ShapeVisitor {
    private double result = 0.0;

    // Reset stored result to reuse the visitor instance.
    public void reset(){
        result = 0.0;
    }

    // Returns the last computed result
    public double getResult(){
        return result;
    }

    // Compute area of the circle: pi * r^2
    @Override
    public void visit(Circle circle) {
        result = Math.PI * circle.getRadius() * circle.getRadius();
    }

    // Compute area of the rectangle: width * height
    @Override
    public void visit(Rectangle rectangle) {
        result = rectangle.getWidth() * rectangle.getHeight();
    }

    // Compute area of the triangle: 0.5 * base * height
    @Override
    public void visit(Triangle triangle) {
        result = 0.5 * triangle.getBase() * triangle.getHeight();
    }

    // Compute total area of all child shapes in the composite.
    // The visitor visits each child and accumulates their areas.
    @Override
    public void visit(CompositeShape compositeShape) {
        double sum = 0.0;
        for (Shape shape : compositeShape.getShapes()) {
            shape.accept(this);
            sum += this.result;
        }
        this.result = sum;
    }
}
