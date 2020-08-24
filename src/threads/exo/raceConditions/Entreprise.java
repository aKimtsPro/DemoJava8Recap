package threads.exo.raceConditions;

public class Entreprise {

    private int stockVerre;

    public int getStockVerre() {
        return stockVerre;
    }

    public synchronized void construire() {

        try {
            Thread.sleep(10);
            stockVerre += 10;
        }
        catch (InterruptedException ie)
        {
            System.out.println("construction interrompue");
        }
    }

    public synchronized void vendre(){

        try{
            Thread.sleep(20);
            stockVerre -= 10;
        }
        catch (InterruptedException ie)
        {
            System.out.println("vente interrompue.");
        }
    }

}
