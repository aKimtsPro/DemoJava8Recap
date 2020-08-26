package demoLayeredArchitecture.business.model;

public class ChienDTO {

    private int id;
    private String nom;
    private PersonneDTO proprio;

    public ChienDTO(int id, String nom, PersonneDTO proprio) {
        this.id = id;
        this.nom = nom;
        this.proprio = proprio;
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

    public PersonneDTO getProprio() {
        return proprio;
    }

    public void setProprio(PersonneDTO proprio) {
        this.proprio = proprio;
    }

    @Override
    public String toString() {
        return "id : "+id
                +"\nnom:"+nom
                +"\nproprio:"+ proprio.getNom();
    }
}
