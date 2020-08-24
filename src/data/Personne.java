package data;

import java.time.LocalDate;
import java.util.function.Predicate;

public class Personne implements Comparable<Personne> {

    private String nom;
    private LocalDate dateNaiss;
    private Predicate<Personne> checkAttactive = personne -> LocalDate.now().getYear() - personne.getDateNaiss().getYear() >= 18;

    public Personne(String nom, LocalDate dateNaiss) {
        this.nom = nom;
        this.dateNaiss = dateNaiss;
    }

    public Personne(String nom, LocalDate dateNaiss, Predicate<Personne> checkAttactive) {
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.checkAttactive = checkAttactive;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public boolean checkAtt(Personne persone){
        return this.checkAttactive.test(persone);
    }

    @Override
    public String toString() {
        return "data.Personne : " +
                "\n\t nom : " + this.nom +
                "\n\t gestion.temps.date de naissance : " + this.dateNaiss;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof
                Personne && this.nom == ((Personne)obj).nom;
    }


    @Override
    public int compareTo(Personne o) {
        return  this.getNom().length() - o.getNom().length();
    }


}
