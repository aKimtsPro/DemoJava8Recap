package threads.exo.factories;

import java.util.Random;

public class MoteurFactory implements  Runnable {

    private Moteur moteur;

    public MoteurFactory(){}

    public Moteur getMoteur() {

        Moteur recup = moteur;
        moteur = null;
        return recup;
    }

    public Thread build()
    {
        Thread rslt = new Thread(this);
        rslt.start();
        return rslt;
    }

    @Override
    public void run() {
        try {
            int randomized = new Random().nextInt(4) + 3;
            System.out.println("Building à Moteur("+randomized+"s)");
            Thread.sleep(randomized * 1000);
            moteur = new Moteur("marque de moteur");
            System.out.println("moteur built");
        }
        catch(InterruptedException ie)
        {
            System.out.println("interrupted");
        }
    }
}
