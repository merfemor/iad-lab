package graphics;

public class Lab3Area implements Area {
    private final Double radius;

    public Lab3Area(Double radius) {
        this.radius = radius;
    }

    @Override
    public boolean isInArea(Point point) {
        Double x = point.getX();
        Double y = point.getY();
        return x <= 0 && y >= 0 && x >= -radius && y <= radius ||
                x >= 0 && y <= 0 && (x * x + y * y <= (radius / 2) * (radius / 2)) ||
                x <= 0 && y <= 0 && (y >= -x - radius / 2);
    }
}
