package threads.prodCons.exo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Consumer extends JFrame implements Runnable {

    private final String NOT_RUNNING = "not running";
    private final String RUNNING = "running";

    private Thread thread = new Thread(this);

    private final Stock s;
    private JLabel label = new JLabel(NOT_RUNNING);

    public Consumer(Stock s) throws HeadlessException {
        this.s = s;
        this.setup();
    }

    public void setup()
    {
        this.setTitle("consumer");
        this.setPreferredSize(new Dimension(200,200));
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(label);
        this.setLocation(300,100);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thread.interrupt();
                e.getWindow().dispose();
            }
        });

        this.pack();
    }

    @Override
    public void run() {
        try{
            while(true)
            {
                synchronized (s) {
                    if (s.isEmpty()) {
                        turnOff();
                        s.wait();
                        turnOn();
                    }

                    s.consume();
                    s.notify();

                }
                Thread.sleep(700);

            }
        }
        catch(InterruptedException ie)
        {
            System.out.println("consumption stopped");
        }
    }


    private void turnOff(){
        label.setText(NOT_RUNNING);
        this.getContentPane().setBackground(Color.RED);
        this.repaint();
    }

    private void turnOn(){
        label.setText(RUNNING);
        this.getContentPane().setBackground(Color.GREEN);
        this.repaint();
    }

    public void start(){
        turnOn();
        this.setVisible(true);
        thread.start();
    }


}
