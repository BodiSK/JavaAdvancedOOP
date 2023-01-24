package PolymorphismLab.Task2Shapes;

public class Rectangle extends Shape {
    private final Double width;
    private final Double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
        setArea(this.calculateArea());
        setPerimeter(this.calculatePerimeter());
    }

    public final Double getWidth() {
        return width;
    }

    public final Double getHeight() {
        return height;
    }

    @Override
    public double calculatePerimeter() {
        if(perimeter==null)
            perimeter = 2*width + 2*height;
        return perimeter;
    }

    @Override
    public double calculateArea() {
        if(area == null)
            area = width*height;
        return area;
    }
}
