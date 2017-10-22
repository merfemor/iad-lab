import graphics.Area;
import graphics.Lab3Area;
import graphics.Point;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

@ManagedBean(name = "pointsbean", eager = true)
@SessionScoped
public class PointsBean {
    private Double x, y, radius;
    private Area area;

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
        if (this.radius.equals(radius))
            return;
        this.radius = radius;
        area = new Lab3Area(radius);
    }

    public List<Result> getPreviousResults() {
        List<Result> resultList = new LinkedList<>();
        /* TODO: select from database */
        return resultList;
    }

    public boolean isInArea() {
        return area.isInArea(new Point(this.x, this.y));
    }
}
