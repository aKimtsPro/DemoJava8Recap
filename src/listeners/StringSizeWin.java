package listeners;

import javax.swing.*;
import java.awt.*;

public class StringSizeWin extends JFrame implements TextListener {

    private Text text;
    private JLabel label;

    public StringSizeWin(Text text) throws HeadlessException {
        this.text = text;
        label = new JLabel(""+ text.getMonTexte().length());

        text.addListener(this);

        setup();
    }

    public void setup(){

        this.setTitle("Taille de ma string");
        this.setSize(200,200);

        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(label);
        label.setFont(new Font("Helvetica", Font.PLAIN, 30));
        this.setVisible(true);
    }

    @Override
    public void onTextChanged(String text) {
        label.setText( ""+text.length() ) ;
    }
}
