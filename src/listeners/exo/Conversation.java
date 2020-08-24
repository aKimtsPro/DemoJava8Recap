package listeners.exo;

import java.util.ArrayList;
import java.util.List;

public class Conversation {

    private List<ConversationListener> listeners = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message message){
        if(message == null)
            throw new IllegalArgumentException("message can (not) be null.");

        messages.add(message);
        notifyMessageAdded(message);
    }

    public void notifyMessageAdded(Message messageAdded)
    {
        listeners.forEach(listener -> listener.onMessageAdded(messageAdded));
    }

    public void addConversationListener(ConversationListener listener){
        if(listener == null)
            throw new IllegalArgumentException("listener can (not) be null.");

        listeners.add(listener);
    }

    public List<Message> getMessages() {
        return messages;
    }
}
