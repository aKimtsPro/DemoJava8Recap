package threads;

public class DemoThreads {

    public static void main(String[] args) throws InterruptedException{

        Thread.currentThread().setName("main thread");

        // Grâce à la classe Thread, il va désormais être possible de déléguer l'exécution de Runnable
        // en parallèle du thread principal

        Thread t1 = new Thread(() ->{

            System.out.println("Debut du Thread '"+ Thread.currentThread().getName()+"'");
            try {
                System.out.println(Thread.currentThread().getName() + "started wainting 5seconds");
                Thread.sleep(5000);
                System.out.println("salut de t1");
                System.out.println("Fin du Thread '"+ Thread.currentThread().getName()+"'");
            }
            catch( InterruptedException ie )
            {
                System.out.println("t1 interruped");
            }

        }, "t1" );



        Thread t2 = new Thread(() -> {

            System.out.println("Debut du Thread '"+ Thread.currentThread().getName()+"'");
            try {
                int i = 0;
                while( t1.isAlive() )
                {
                    Thread.sleep(1000);
                    System.out.println( ++i + "s passée");
                }
            }
            catch( InterruptedException ie )
            {
                System.out.println("t2 interruped");
            }
            System.out.println("Fin du Thread '"+ Thread.currentThread().getName()+"'");

        }, "t2");

        System.out.println("Dans le Thread de départ : '"+ Thread.currentThread().getName()+"'");

        t1.start();
        t2.start();

        System.out.println("Nombre de threads actifs : " + Thread.activeCount());

        try {
            System.out.println("en attente du Thread t1");
            t1.join();
            System.out.println("Thread t1 fini");
        }
        catch (InterruptedException ie)
        {
            System.out.println("shit stopped :(");
        }





    }

}
