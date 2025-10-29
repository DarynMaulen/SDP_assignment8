import element.concrete.*;
import visitor.concrete.*;

// Main - demo application showing AreaVisitor and PerimeterVisitor usage.
public class Main {
    public static void main(String[] args) {
        // Create some shapes
        Circle circle = new Circle(3.0); // radius 3
        Rectangle rect = new Rectangle(4.0, 5.0); // 4 x 5
        Triangle tri = new Triangle(3.0, 4.0); // base 3, height 4 (right triangle)


        // Composite group
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.add(circle);
        compositeShape.add(rect);
        compositeShape.add(tri);


        // Visitors
        AreaVisitor areaVisitor = new AreaVisitor();
        PerimeterVisitor perVisitor = new PerimeterVisitor();


        // Calculate individual areas
        System.out.println("--------- Individual areas ---------");
        circle.accept(areaVisitor);
        System.out.println("Circle area: " + areaVisitor.getResult() + "\n");

        rect.accept(areaVisitor);
        System.out.println("Rectangle area: " + areaVisitor.getResult() + "\n");

        tri.accept(areaVisitor);
        System.out.println("Triangle area: " + areaVisitor.getResult() + "\n");

        compositeShape.accept(areaVisitor);
        System.out.println("Composite shape area: " + areaVisitor.getResult() + "\n");

        perVisitor.reset();

        System.out.println("--------- Perimeter areas ---------");
        circle.accept(perVisitor);
        System.out.println("Circle perimeter: " + perVisitor.getResult() + "\n");

        rect.accept(perVisitor);
        System.out.println("Rectangle perimeter: " + perVisitor.getResult() + "\n");

        tri.accept(perVisitor);
        System.out.println("Triangle perimeter: " + perVisitor.getResult() + "\n");

        compositeShape.accept(perVisitor);
        System.out.println("Composite shape perimeter: " + perVisitor.getResult() + "\n");
    }
}