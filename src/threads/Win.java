package threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame implements ActionListener {

    JLabel label = new JLabel("go");
    JButton btn = new JButton("go");
    int counter = 0;
    boolean onOff = false;

    public Win() throws HeadlessException {
        this.setTitle("go");
        this.setSize(400,400);
        btn.setActionCommand("go");
        btn.addActionListener(this);

        this.getContentPane().setLayout(new FlowLayout());

        this.getContentPane().add(label);
        this.getContentPane().add(btn);
    }

    private void go(){
        onOff = true;
        while(onOff)
        {
            try {
                Thread.sleep(1000);
                label.setText(""+ ++counter);
            }
            catch (InterruptedException ie)
            {
                System.out.println("problem");
            }
        }

        btn.setText("stop");
        btn.setActionCommand("stop");
    }

    private void stop(){
        onOff = false;
        btn.setText("go");
        btn.setActionCommand("go");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "go":
                go();
                break;
            case "stop":
                stop();
                break;
        }
    }
}
