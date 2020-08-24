package threads.race_conition;

public class Personne {

    private String nom;
    private int age;

    public Personne(String nom) {
        this.nom = nom;
    }

    public void vieillir(int nbrAnnee)
    {
        for (int i = 0; i < nbrAnnee; i++) {
            synchronized (this){
                ++age;
            }
        }
    }

    public void vieillirDouble(int nbrAnnee)
    {
        for (int i = 0; i < nbrAnnee; i++) {
            synchronized (this){
                age += 2;
            }
        }
    }

    public void vieillirSync(int nbrAnnee)
    {

        for (int i = 0; i < nbrAnnee; i++) {
            incrementAge();
        }

    }



    private synchronized void incrementAge()
    {
        ++age;
    }

    public int getAge() {
        return age;
    }
}
