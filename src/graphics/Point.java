package graphics;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Double x;

    @Column
    private Double y;

    @ManyToOne
    private User owner;

    public Point(Double x, Double y, User owner) {
        this.x = x;
        this.y = y;
        this.owner = owner;
    }

    public Point() {
    }
}