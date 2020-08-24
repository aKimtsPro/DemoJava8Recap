package threads.exo.factories;

public class Run {

    public static void main(String[] args) {

        CarcasseFactory cf = new CarcasseFactory();
        MoteurFactory mf = new MoteurFactory();

        Voiture v = new Voiture(cf, mf, "marque de voiture");

        System.out.println(v);
    }

}
