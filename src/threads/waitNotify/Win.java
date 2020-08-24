package threads.waitNotify;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame implements Runnable, ActionListener {

    private int counter;

    private JLabel label = new JLabel(""+ counter);
    private JButton button = new JButton("stop");

    Thread thread = new Thread(this);

    private boolean onOff = true;

    public Win() throws HeadlessException {
        setup();
    }

    private void setup()
    {
        this.setTitle("Wait demo");
        this.setSize(300,300);

        button.setActionCommand("stop");
        button.addActionListener(this);

        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(label);
        this.getContentPane().add(button);

        this.setVisible(true);

        thread.start();
    }

    @Override
    public void run() {
        try{

            while(true)
            {
                synchronized (this)
                {
                    if(!onOff)
                        this.wait();

                    label.setText(""+ ++counter);
                    repaint();
                }
            }
        }
        catch(InterruptedException ie)
        {
            System.out.println("counter interrupted.");
        }

    }

    private void stop(){
        onOff = false;
        button.setText("start");
        button.setActionCommand("start");
    }

    private synchronized void start(){
        onOff = true;
        this.notify();
        button.setText("stop");
        button.setActionCommand("stop");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "stop":
                stop();
                break;

            case "start":
                start();
                break;
        }
    }
}
