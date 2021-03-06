package graphics;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Expose
    private Long id;

    @Column(unique = true)
    @Expose
    private String login;

    @Column
    @Expose
    private String password;

    @OneToMany
    private List<Point> points = new LinkedList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }
}