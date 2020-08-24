package data;

import java.time.LocalDate;

public class Employe extends Personne {

    private int salaire;

    public Employe(String nom, LocalDate dateNaiss, int salaire) {
        super(nom, dateNaiss);
        this.salaire = salaire;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\t salaire : " + this.salaire;
    }
}
