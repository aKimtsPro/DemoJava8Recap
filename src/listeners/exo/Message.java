package listeners.exo;

import java.time.LocalDateTime;

public class Message {

    private User user;
    private String text;
    private LocalDateTime dateEnvoie;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        dateEnvoie = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
}
