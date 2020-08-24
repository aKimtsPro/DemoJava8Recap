package threads.prodCons.exo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Stock extends JFrame implements ActionListener {

    private Stack<Product> productList = new Stack<>();
    private JLabel label = new JLabel(""+productList.size());
    private JButton[] btns = new JButton[2];
    private int capacity;

    public Stock(int capacity) throws HeadlessException {
        this.setCapacity(capacity);
        setup();
    }

    // access

    public int getCapacity() {
        return capacity;
    }

    private void setCapacity(int capacity) {
        if(capacity < 0)
            throw new IllegalArgumentException("Capacity cannot be negative.");

        this.capacity = capacity;
    }

    // private methods

    private void setup()
    {
        this.setTitle("stock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setPreferredSize(new Dimension(200,200));
        label.setFont(new Font("comic sans ms", Font.PLAIN, 30));
        this.getContentPane().setLayout(new FlowLayout());
        this.getContentPane().add(label);

        btns[0] = new JButton("add consumer");
        btns[0].setActionCommand("cons");
        btns[0].addActionListener(this);

        btns[1] = new JButton("add producer");
        btns[1].setActionCommand("prod");
        btns[1].addActionListener(this);

        for (JButton j :
                btns) {
            this.getContentPane().add(j);
        }

        this.setVisible(true);

        this.pack();

    }

    // public methods

    public synchronized void add(Product product){
        if( isAtCapacity() )
            throw new StockFullException();

        productList.push(product);
        label.setText(""+productList.size());
        this.repaint();
    }

    public synchronized void consume(){
        productList.pop();

        label.setText(""+productList.size());
        this.repaint();
    }

    public boolean isAtCapacity()
    {
        return capacity == productList.size();
    }

    public boolean isEmpty()
    {
        return productList.size() == 0;
    }

    private void startNewConsumer(){
        new Consumer(this).start();
    }

    private void startNewProducer(){
        new Producer(this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "prod":
                startNewProducer();
                break;
            case "cons":
                startNewConsumer();
                break;
        }
    }
}
