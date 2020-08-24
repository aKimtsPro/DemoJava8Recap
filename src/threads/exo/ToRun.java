package threads.exo;

public class ToRun implements Runnable {
    @Override
    public void run() {

        try{
            System.out.println("\t--- debut attente");
            Thread.sleep(5000);
            System.out.println("\t--- attente terminée");
        }
        catch(InterruptedException ie)
        {
            System.out.println("\t--- Thread interrompu");
        }

    }
}
