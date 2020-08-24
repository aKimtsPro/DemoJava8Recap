package threads.exo.factories;

public class Voiture {

    private String marque;
    private Carcasse carcasse;
    private Moteur moteur;

    @Override
    public String toString() {
        return "Voiture de marque : " + marque +
                "\n\t- moteur : " + moteur.getMarque() +
                "\n\t- carcasse : " + carcasse.getMarque();
    }

    public Voiture(CarcasseFactory carcasseFactory, MoteurFactory moteurFactory, String marque) {

        this.marque = marque;

        System.out.println("construction des pieces : \n");
        Thread tC = carcasseFactory.build();
        Thread tM = moteurFactory.build();

        try{
            tC.join();
            tM.join();

            System.out.println("\nconstruction des pieces terminée \n");

            this.carcasse = carcasseFactory.getCarcasse();
            this.moteur = moteurFactory.getMoteur();
        }
        catch (InterruptedException ie)
        {
            System.out.println("construction interrompue");
        }
    }


}
