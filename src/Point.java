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
        return false;
    }
}
