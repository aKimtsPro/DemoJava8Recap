package threads.exo.factories;

import java.util.Random;

public class CarcasseFactory implements Runnable {

    private Carcasse carcasse;

    public CarcasseFactory(){}

    public Carcasse getCarcasse(){
        Carcasse recup = carcasse;
        carcasse = null;
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
            int randomized = new Random().nextInt(5) + 4;
            System.out.println("Building à Carcasse("+randomized+"s)");
            Thread.sleep(randomized * 1000);
            carcasse = new Carcasse("marque de carcasse");
            System.out.println("carcasse built");
        }
        catch(InterruptedException ie)
        {
            System.out.println("interrupted");
        }

    }
}
