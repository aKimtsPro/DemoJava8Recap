package listeners.exo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChatBox extends JFrame implements ConversationListener, ActionListener {

    private User user;
    private Conversation conversation;
    private Font usedFont = new Font("Helvetica", Font.PLAIN, 30);

    private JPanel messagePanel = new JPanel();
    private List<JLabel> labels = new ArrayList<>();

    private JPanel writerPanel = new JPanel();
    private JTextField messageField = new JTextField(25);
    private JButton sendButton = new JButton("SEND");

    public ChatBox(User user, Conversation conversation) throws HeadlessException {
        this.user = user;
        this.conversation = conversation;
        conversation.getMessages().forEach((message) -> labels.add(setupLabel( message )));
        conversation.addConversationListener(this);
        setup();
    }

    private void setup()
    {
        this.setTitle(user.getNom() + "'s chatbox");
        this.setSize(400, 800);

        this.getContentPane().setLayout(new BorderLayout());

        writerPanel.setLayout(new FlowLayout());
        writerPanel.add(messageField);
        writerPanel.add(sendButton);
        writerPanel.setBackground(user.getColor());

        sendButton.setActionCommand("send");
        sendButton.addActionListener(this);

        this.getContentPane().add(writerPanel, BorderLayout.SOUTH);

        messagePanel.setLayout( new BoxLayout(messagePanel, BoxLayout.Y_AXIS) );
        labels.forEach((label) -> messagePanel.add(label, Component.CENTER_ALIGNMENT));

        this.getContentPane().add(messagePanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void send(){
        conversation.addMessage(new Message(user, messageField.getText()));
        messageField.setText("");
    }

    @Override
    public void onMessageAdded(Message added) {
        messagePanel.add( setupLabel(added) );
        this.setVisible(true);
    }

    private JLabel setupLabel(Message message){
        JLabel label = new JLabel("<html>"+ message.getUser().getNom() + " - " + message.getText()+"</html>" );
        label.setBackground(message.getUser().getColor());
        label.setOpaque(true);
        label.setFont(usedFont);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "send":
                send();
                break;
        }
    }
}
