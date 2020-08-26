package demoLayeredArchitecture.business.model;

public class PersonneDTO {

    private int id;
    private String nom;

    public PersonneDTO(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

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

    @Override
    public String toString() {
        return "id : "+id
                +"\nnom : "+nom;
    }
}
