import graphics.Point;

public class Result {
    private final Point point;
    private final boolean isInArea;

    public Result(Point point, boolean isInArea) {
        this.point = point;
        this.isInArea = isInArea;
    }

    public Point getPoint() {
        return point;
    }

    public boolean isInArea() {
        return isInArea;
    }
}
