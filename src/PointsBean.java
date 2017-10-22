import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

import graphics.*;

@ManagedBean(name = "pointsbean", eager = true)
@SessionScoped
public class PointsBean {
    private Double x, y, radius;
    private List<Point> previousPoints;
    private Lab3Area area;

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
}
