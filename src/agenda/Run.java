package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Run {

    public static void main(String[] args) {

        Personne proprietaire = new Personne("luc", LocalDate.of(2000,1,1), 1700000);

        Agenda a = Agenda.getInstance();
        a.setProprietaire(proprietaire);

        a.add(
            new TacheSimple(
                () -> a.getProprietaire().seFormer(),
                LocalDateTime.now().plusDays(3), // 15
                a
            )
        );

        a.add(
            new TacheDependante<>(
                new Personne("marie", LocalDate.of(1990, 10,10), 88000),
                (personne) -> a.getProprietaire().visiter(personne),
                LocalDateTime.now().plusDays(4), // 16
                a
            )
        );

        a.add(
            new TacheSimple(
                () -> a.getProprietaire().travailler(),
                LocalDateTime.now().plusDays(9), // 21 -> 26
                a
            )
        );

        a.add(
            new TacheDependante<>(
                new Produit("tele", 700000000),
                (produit) -> a.getProprietaire().acheter(produit),
                (produit -> produit.getPrix() <= a.getProprietaire().getSolde()),
                LocalDateTime.now().plusDays(15), // 27 -> 1
                a
            )
        );


        while( a.tachesFutures().size() > 0 )
        {
            a.executerNext();
        }


    }

}
