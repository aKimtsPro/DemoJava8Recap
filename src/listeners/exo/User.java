package listeners.exo;

import java.awt.*;

public class User {

    private final String nom;
    private final Color color;

    public User(String nom, Color color) {
        this.nom = nom;
        this.color = color;
    }

    public String getNom() {
        return nom;
    }

    public Color getColor() {
        return color;
    }
}
