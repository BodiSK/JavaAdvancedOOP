package PolymorphismLab.Task2Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
        setArea(this.calculateArea());
        setPerimeter(this.calculatePerimeter());
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        if(perimeter==null)
            perimeter = 2 * Math.PI * radius;

        return perimeter;
    }

    @Override
    public double calculateArea() {
        if(area == null)
            area = Math.PI*radius*radius;
        return area;
    }
}
