package visitor.concrete;

import element.Shape;
import element.concrete.*;
import visitor.ShapeVisitor;

// PerimeterVisitor - computes perimeter for shapes.
public class PerimeterVisitor implements ShapeVisitor {
    private double result = 0.0;

    // Reset stored result to reuse the visitor instance.
    public void reset(){
        result = 0.0;
    }

    // Returns the last computed perimeter
    public double getResult(){
        return result;
    }

    // Compute circle perimeter: 2 * pi * r
    @Override
    public void visit(Circle circle) {
        result = 2 * Math.PI * circle.getRadius();
    }

    // Compute rectangle perimeter: 2 * (width + height)
    @Override
    public void visit(Rectangle rectangle) {
        result = 2 * (rectangle.getWidth() + rectangle.getHeight());
    }

    // Compute triangle perimeter assuming a right triangle: base + height + hypotenuse
    @Override
    public void visit(Triangle triangle) {
        result = triangle.getBase() + triangle.getHeight()
                + Math.hypot(triangle.getBase(), triangle.getHeight());
    }

    // Compute total perimeter of child shapes in the composite by visiting each child.
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
