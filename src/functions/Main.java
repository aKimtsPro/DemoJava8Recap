package functions;

import data.Personne;

import java.time.LocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        // package java.util.function

        // Consumer
        // methode prenant un paramètre et sans type de retour

        System.out.println("\n---- consumer ----\n");

        Consumer<Personne> consumer = System.out::println;

        consumer.andThen( personne -> personne.setNom("Min") ) // aggregation
                .andThen( System.out::println )
                .accept( new Personne("Max", LocalDate.now()) ); // executer


        // Supplier
        // methode sans paramètre générant des objets d'un certain type

        System.out.println("\n---- supplier ----\n");

        Supplier<Personne> supplier = () -> new Personne("Middle", LocalDate.now());

        Personne generee = supplier.get(); // executer
        System.out.println(generee);


        // Function
        // méthode avec un paramètre et un type de retour

        System.out.println("\n---- function ----\n");

        Function<Personne, String> function = Personne::getNom;


        //            A->B  + B->C => A->C
        Function<String, Integer> sequel = String::length;
        int count = function.andThen( sequel ).apply( generee ); // aggregation après la function

        //    Z->A +  A->B         => Z->B
        Function<LocalDate, Personne> prequel = (date) -> new Personne("Datee", date);
        String nom = function.compose( prequel ).apply(LocalDate.now()); // aggregation avant la function


        System.out.println( function.andThen(sequel).compose(prequel).apply(LocalDate.now()) );


        // BiFunction

        System.out.println("\n---- BiFunction ----\n");

        BiFunction<String, LocalDate, Personne> biFunc = Personne::new;
        long days = biFunc.andThen( personne -> personne.getDateNaiss().toEpochDay() )
                .apply("par biFunc", LocalDate.now());

        System.out.println(days);


        // (A,B)->C + C->D ==   (A,B) -> D
        // (String, LocalDate)->Personne + Personne->Long == (String,LocalDate)->Long


        // Predicate
        // Méthodes avec un paramètre et renvoyant un boolean

        System.out.println("\n---- predicate ----\n");

        Predicate<Personne> verifTaille = personne -> personne.getNom().length() >= 5;
        Predicate<Personne> verifAge = personne -> personne.getDateNaiss().getYear() >= 1990;

        boolean verif = verifTaille.test( generee ); // exécuter le Predicate

        Predicate<Personne> verifTaille_AND_Age = verifAge.and( verifTaille );
        Predicate<Personne> verifTaille_OR_Age =  verifAge.or( verifTaille );
        Predicate<Personne> verif_NOT_Taille = verifTaille.negate();


        // Les Operator

        // UnaryOperator
        // Methode prenant un paramètre et renvoyant un element de même type

        // UnaryOperator<T> extends Function<T, T>
        UnaryOperator<Personne> unaryOperator = personne -> {
            personne.setDateNaiss( LocalDate.now().minus(5, ChronoUnit.YEARS));
            return personne;
        };
        // un UnaryOperator peut faire tout ce qu'une Function peut faire.


        // BinaryOperator

        // BinaryOperator<T> extends BiFunction<T,T,T>
        BinaryOperator<Personne> binaryOperator = (pers1, pers2) -> new Personne(pers1.getNom(), pers2.getDateNaiss());
        // un BinaryOperator peut faire tout ce qu'une BiFunction peut faire.





    }

}
