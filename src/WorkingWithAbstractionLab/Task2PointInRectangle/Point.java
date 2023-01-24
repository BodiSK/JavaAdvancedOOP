package WorkingWithAbstractionLab.Task2PointInRectangle;

public class Point {
    private int X;
    private int Y;

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public boolean greaterOrEqual(Point other) {
        return this.X >= other.getX() && this.Y >= other.getY();
    }

    public boolean lessOrEqual(Point other) {
        return this.X <= other.X && this.Y <= other.getY();
    }
}
