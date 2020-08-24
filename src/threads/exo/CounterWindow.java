package threads.exo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CounterWindow extends JFrame implements ActionListener {

    private int counter = 0;
    private JButton[] buttons = new JButton[2];
    private JLabel label = new JLabel("Pour lancer le counter, appuyez sur 'commencer'", JLabel.CENTER);
    private JPanel btnContainer = new JPanel();
    private Thread countingThread;

    public CounterWindow() {
        buttons[0] = new JButton("commencer");
        buttons[1] = new JButton("interrompre");
        buttons[1].setEnabled(false);

        List<Object> l = new ArrayList();

        setup();
    }

    public void setup()
    {
        this.setTitle("exo counter");
        this.setSize(350,200);

        this.getContentPane().setLayout(new BorderLayout());

        btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        for (JButton btn : buttons) {
            btnContainer.add(btn);
        }

        this.getContentPane().add(label, BorderLayout.CENTER);
        this.getContentPane().add(btnContainer, BorderLayout.SOUTH);

        buttons[0].setActionCommand("begin");
        buttons[0].addActionListener(this);
        buttons[1].setActionCommand("stop");
        buttons[1].addActionListener(this);

    }

    public void begin()
    {
        buttons[0].setEnabled(false);
        buttons[0].setText("resume");

        countingThread = new Thread(
            ()->{

                try {
                    while(true)
                    {
                            label.setText("" + ++counter);
                            Thread.sleep(1000);
                    }
                }
                catch (InterruptedException ie)
                {
                    System.out.println("erreur d'interruption");
                }
            }
        );

        label.setText(""+counter);
        countingThread.start();

        buttons[1].setEnabled(true);
    }

    public void stop(){
        countingThread.interrupt();
        buttons[0].setEnabled(true);
        buttons[1].setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "begin":
                begin();
                break;
            case "stop":
                stop();
                break;
        }
    }
}
