package graphics;

public abstract class Area {
    protected final Double radius;

    public Area(Double radius) {
        this.radius = radius;
    }

    public abstract boolean isInArea(Point p);
}
