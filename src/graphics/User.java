package graphics;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Expose
    private Long id;

    @Lob
    @Expose
    private String login;

    @Lob
    @Expose
    private String password_hash;

    @OneToMany
    private List<Point> points = new LinkedList<>();

    public User(String login, String password_hash) {
        this.login = login;
        this.password_hash = password_hash;
    }

    public User() {
    }
}