package element.concrete;

import element.Shape;
import visitor.ShapeVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// CompositeShape - a container shape that groups multiple Shape elements.
// Demonstrates Composite+Visitor composition: visitor will traverse children.
public class CompositeShape implements Shape {
    private final List<Shape> shapes = new ArrayList<>();

    // Add a child shape to the composite.
    public void add(Shape shape) {
        shapes.add(shape);
    }

    // Returns an unmodifiable view of child shapes.
    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    // Accept a visitor and dispatch to visitor.visit(this).
    // Visitors typically iterate children when handling composite.
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
