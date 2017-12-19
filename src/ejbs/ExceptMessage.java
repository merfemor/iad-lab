package ejbs;

import javax.persistence.Entity;

@Entity
public class ExceptMessage {
    String message;

    public ExceptMessage(String message) {
        this.message = message;
    }

    public ExceptMessage() {
    }
}
