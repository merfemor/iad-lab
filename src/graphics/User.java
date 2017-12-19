package graphics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String login;
    @Column
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
