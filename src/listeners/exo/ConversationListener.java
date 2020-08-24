package listeners.exo;

import java.util.EventListener;

public interface ConversationListener extends EventListener {

    public void onMessageAdded(Message added);

}
