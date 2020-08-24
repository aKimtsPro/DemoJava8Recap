package agenda;

public class Produit {

    private String type;
    private double prix;

    public Produit(String type, double prix) {
        this.type = type;
        this.setPrix(prix);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    private void setPrix(double prix) {
        if( prix < 0 )
            throw  new IllegalArgumentException("le prix ne peut pas être négatif");

        this.prix = prix;
    }
}
