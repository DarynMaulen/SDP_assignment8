package element;

import visitor.ShapeVisitor;

// Shape interface - element in Visitor pattern.
// Each concrete shape implements accept() to allow visitors to operate on it.
public interface Shape {

    // Accept a ShapeVisitor so it can perform an operation on this shape.
    void accept(ShapeVisitor visitor);
}