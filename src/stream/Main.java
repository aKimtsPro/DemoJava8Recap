package stream;

import data.Employe;
import data.Personne;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Personne luc = new Personne("luc", LocalDate.of(1990, 10, 10));

        ArrayList<Personne> listPers = new ArrayList<>(
                Arrays.asList(
                        luc,
                        new Personne("marie", LocalDate.of(1980, 10, 10)),
                        new Personne("dominique", LocalDate.of(2010, 10, 10)),
                        luc
                )
        );

        // Les opérations intermediaires
        // - Les opérations intermediaires renvoient un Stream
        //   qu'on va pouvoir continuer à utiliser.

        // Filtrer les elements

        System.out.println("\n---- filter ----\n");

        listPers.stream()
                .filter( personne -> personne.getDateNaiss().getYear() > 1985 )
                .forEach( System.out::println );

        // Obtenir les elements distincts

        System.out.println("\n---- distinct ----\n");

        listPers.stream()
                .distinct()
                .forEach( System.out::println );

        // transformer chaque objet en UN autre objet

        System.out.println("\n---- map ----\n");

        listPers.stream()
                .distinct()
                .map( personne -> new Employe( personne.getNom(), personne.getDateNaiss(),
                            (LocalDate.now().getYear() - personne.getDateNaiss().getYear())*300 ))
                .forEach(System.out::println );


        // transformer chaque objet en UN OU PLUSIEURS objets

        System.out.println("\n---- flatmap ----\n");

        ArrayList<String> phrases = new ArrayList<>( Arrays.asList(
                "Salut ca va?",
                "Bien et toi?",
                "Il fait beau"
        ));

        phrases.stream()
                .flatMap( phrase -> Arrays.asList( phrase.split(" ") ).stream() )
                .forEach( System.out::println );

        // peek - un forEach intermediaire (qui renvoie le Stream)

        System.out.println("\n---- peek ----\n");

        ArrayList<String> phrases2 = new ArrayList<>( Arrays.asList(
                "Salut ca va?",
                "Bien et toi?",
                "Il fait beau"
        ));

        List<String> mots = phrases2.stream()
                .peek( phrase -> System.out.println(phrase + " - nombre de lettres : " + phrase.length()) )
                .flatMap( phrase -> Arrays.asList( phrase.split(" ") ).stream() )
                .peek( System.out::println )
                .collect( Collectors.toList() );


        // Les methodes finales

        // forEach

        System.out.println("\n---- forEach ----\n");

        listPers.stream()
                .forEach( personne -> System.out.println(personne.getDateNaiss()) );


        // toArray

        Object[] tab = listPers.stream().toArray();



        // min et max et les comparator

        System.out.println("\n---- min/max ----\n");

        listPers = new ArrayList<>(
                Arrays.asList(
                        luc,
                        new Personne("marie", LocalDate.of(2010, 10, 10)),
                        new Personne("dominique", LocalDate.of(2010, 10, 10)),
                        luc
                )
        );

        Optional<Personne> opt = listPers.stream()
                                        .max( Personne::compareTo );

        opt.ifPresent( System.out::println );

        opt = listPers.stream()
                .min( Personne::compareTo );

        opt.ifPresent( System.out::println );


        // findFirst/findAny


        System.out.println("\n---- findAny/findFirst ----\n");

        opt = listPers.stream().findAny(); // généralement le premier mais aucune garantie
        opt.ifPresent( System.out::println );

        opt = listPers.stream().findFirst(); // tojours le premier
        opt.ifPresent( System.out::println );


        // count

        System.out.println("\n---- count ----\n");

        long count = listPers.stream()
                .filter( personne -> personne.getNom().length() >= 5 )
                .count();
        System.out.println( "nombre de personne ayant un nom de taille 5ou plus : " + count );


        // match

        System.out.println("\n---- les match ----\n");

        boolean match = listPers.stream()
                .anyMatch( personne -> personne.getNom().length() >= 5 );

        System.out.println(match);

        match = listPers.stream()
                .allMatch( personne -> personne.getNom().length() >= 5 );

        System.out.println(match);

        match = listPers.stream()
                .noneMatch( personne -> personne.getNom().length() >= 50 );

        System.out.println(match);

        // collect

        System.out.println("\n---- les match ----\n");

        ArrayList<Personne> list = listPers.stream()
                .filter( personne -> personne.getNom().length() >= 5 )
                .collect( Collectors.toCollection( ArrayList::new ));

        list.forEach( System.out::println );




    }
    // { Salut, ca , va? }
    // { Bien, et, toi? }
    // { Il, fait, beau }
}
