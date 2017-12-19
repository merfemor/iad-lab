package graphics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.FormParam;

@Entity
public class Point {
    @Id
    @GeneratedValue
    @FormParam("id")
    private Long id;
    @Column
    @FormParam("x")
    private Double x;
    @Column
    @FormParam("y")
    private Double y;
    @Column
    @FormParam("owner")
    private String owner;

    public Point(Double x, Double y, String owner) {
        this.x = x;
        this.y = y;
        this.owner = owner;
    }

    public Point() {
    }

    public Double getX() {
        return x;
    }


    public Double getY() {
        return y;
    }


    public String getOwner() {
        return owner;
    }

}
