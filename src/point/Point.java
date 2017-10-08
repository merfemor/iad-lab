package point;

public class Point {
    public final double x;
    public final double y;
    public final double radius;
    public final boolean isInRegion;

    public Point(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isInRegion = isInRegion();
    }

    private boolean isInRegion() {
        return x <= 0 && y >= 0 && x >= -radius && y <= radius ||
                x >= 0 && y <= 0 && (x * x + y * y <= (radius / 2) * (radius / 2)) ||
                x <= 0 && y <= 0 && (y >= -x - radius / 2);
    }
}
