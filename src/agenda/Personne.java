package agenda;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personne {

    // champs

    private String nom;
    private LocalDate dateNaiss;
    private double salaire;
    private double solde = 0;
    private ArrayList<Produit> listPossession = new ArrayList<>();

    // constructeurs

    public Personne(String nom, LocalDate dateNaiss, double salaire) {
        this.nom = nom;
        this.dateNaiss = dateNaiss;
        this.salaire = salaire;
    }

    // methodes

    public void acheter(Produit produit)
    {
        try {
            setSolde(getSolde() - produit.getPrix());
            listPossession.add( produit );
            System.out.println(this.getNom() + " a acheté : "+ produit.getType());
        }
        catch( IllegalArgumentException iae)
        {
            System.out.println("Solde insuffisant.");
        }
    }

    public void visiter(Personne aVisiter)
    {
        if( aVisiter == null || this == aVisiter )
            System.out.println("La personne ne peut pas être visité");

        System.out.println(this.getNom() + " rend visite à " + aVisiter.getNom());
    }


    public void travailler()
    {
        System.out.println( this.getNom() + " travaille." );
        this.setSolde( this.getSolde() + this.getSalaire() );
        System.out.println("cette personne gagne "+ this.getSalaire() + "euro.");
    }

    public void seFormer()
    {
        System.out.println( this.getNom() + " se forme." );
        setSalaire( this.getSalaire() + 100 );
        System.out.println("Son salaire est augmenté de 100roubles");
    }

    // get/set

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    private void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public double getSalaire() {
        return salaire;
    }

    private void setSalaire(double salaire) {
        if( salaire < 0 )
            throw  new IllegalArgumentException("le salaire ne peut pas être négatif");

        this.salaire = salaire;
    }

    public double getSolde() {
        return solde;
    }

    private void setSolde(double solde) {
        if( solde < 0 )
            throw  new IllegalArgumentException("le solde ne peut pas être négatif");

        this.solde = solde;
    }


}
