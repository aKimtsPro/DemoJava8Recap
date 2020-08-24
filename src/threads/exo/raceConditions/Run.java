package threads.exo.raceConditions;

public class Run {

    public static void main(String[] args) throws InterruptedException {

        for (int k = 0; k < 50; k++) {

            Entreprise e = new Entreprise();

            Thread t1 = new Thread( () -> {
                for(int i = 0; i < 1_000; i++)
                    e.construire();
            });
            Thread t2 = new Thread( () -> {
                for (int i = 0; i < 800; i++)
                    e.vendre();
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("Nombre de verre restant : " + e.getStockVerre());
        }

    }
}
