package point;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {
    public double x;
    public double y;
    public double radius;
    public boolean isInRegion;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Point(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isInRegion = isInRegion();
    }

    public Point() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    private boolean isInRegion() {
        return x <= 0 && y >= 0 && x >= -radius && y <= radius ||
                x >= 0 && y <= 0 && (x * x + y * y <= (radius / 2) * (radius / 2)) ||
                x <= 0 && y <= 0 && (y >= -x - radius / 2);
    }
}
