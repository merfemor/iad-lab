package graphics;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {
    @Id
    @GeneratedValue
    @Expose
    private Long id;

    @Column
    @Expose
    private Double x;

    @Column
    @Expose
    private Double y;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User owner;


    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Point(Double x, Double y, User owner) {
        this.x = x;
        this.y = y;
        this.owner = owner;
    }

    public Point() {
    }
}