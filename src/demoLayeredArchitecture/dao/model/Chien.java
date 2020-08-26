package demoLayeredArchitecture.dao.model;

public class Chien {

    private int id;
    private String nom;
    private int proprioId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getProprioId() {
        return proprioId;
    }

    public void setProprioId(int proprioId) {
        this.proprioId = proprioId;
    }
}
