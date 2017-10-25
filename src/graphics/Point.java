package graphics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Point {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Double x;
    @Column
    private Double y;

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public Double getX() {
        return x;
    }


    public Double getY() {
        return y;
    }

}
