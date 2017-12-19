package graphics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.FormParam;

@Entity
public class User {
    @Id
    @GeneratedValue
    @FormParam("id")
    private Long id;
    @Column
    @FormParam("login")
    private String login;
    @Column
    @FormParam("password_hash")
    private String password_hash;

    public User(String login, String password_hash) {
        this.login = login;
        this.password_hash = password_hash;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }


    public String getPassword_hash() {
        return password_hash;
    }

}
