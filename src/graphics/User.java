package graphics;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String login;

    @Lob
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