package visitor;

import element.concrete.*;

// ShapeVisitor - Visitor interface declaring visit methods for each concrete Shape.
// Add new visit(X) methods when new Shape types are added.
public interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Triangle triangle);
    void visit(CompositeShape compositeShape);
}
