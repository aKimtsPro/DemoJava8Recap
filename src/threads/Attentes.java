package threads;

import threads.exo.ToRun;

public class Attentes {
    public static void main(String[] args) throws InterruptedException {


        Thread t0 = new Thread( new ToRun() );

        System.out.println("Starting t0");
        t0.start();

        t0.join();
        System.out.println("t0 finished or 3sec passed");

    }
}
