package listeners.exo;

import java.awt.*;

public class Run {

    public static void main(String[] args) {

        Conversation convo = new Conversation();

        User leo = new User("leo", Color.ORANGE);
        User lea = new User("lea", Color.CYAN);
        User lee = new User("lee", Color.PINK);

        convo.addMessage(new Message(leo, "message test"));

        ChatBox c1 = new ChatBox(leo, convo);
        ChatBox c2 = new ChatBox(lea, convo);
        ChatBox c3 = new ChatBox(lee, convo);




    }

}
