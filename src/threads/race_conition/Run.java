package threads.race_conition;

public class Run {

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 50; i++) {

            Personne p = new Personne("Luc");

            Thread t1 = new Thread(() -> p.vieillirDouble(25_000));
            Thread t2 = new Thread(() -> p.vieillir(50_000));

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            System.out.println("La personne a au final un age de :" + p.getAge());
        }




    }
}
