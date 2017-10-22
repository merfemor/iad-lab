import graphics.Point;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "pointsbean", eager = true)
@SessionScoped
public class PointsBean {
    private Double x, y, radius;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public List<Point> getPreviousPoints() {
        List<Point> points = new LinkedList<>();
        /* TODO: select from database */
        return points;
    }
}
