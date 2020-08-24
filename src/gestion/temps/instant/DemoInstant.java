package gestion.temps.instant;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DemoInstant {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        instant = Instant.ofEpochMilli(48722445);
        instant = Instant.ofEpochSecond(4875421);
        instant = Instant.ofEpochSecond(888888, 333333);
        instant = Instant.from( Instant.now() );



        // recuperer

        long toWrite = instant.getNano();
        toWrite = instant.getEpochSecond();


        // Aucune des valeurs de ChronoField n'accepte un get
        toWrite = instant.getLong(ChronoField.INSTANT_SECONDS);
        toWrite = instant.getLong(ChronoField.NANO_OF_SECOND);

        // Valeurs valides de ChronoField:
        //• NANO_OF_SECOND
        //• MICRO_OF_SECOND
        //• MILLI_OF_SECOND
        //• INSTANT_SECONDS

//        toWrite = instant.get(ChronoField.MILLI_OF_SECOND); -> DateTimeException
//        toWrite = instant.getLong(ChronoField.MONTH_OF_YEAR); -> UnsupportedTemporalTypeException

        instant.isSupported(ChronoField.MONTH_OF_YEAR);// -> false
        instant.isSupported(ChronoField.MICRO_OF_SECOND);// -> true

        // Les compaisons

        boolean compared = instant.isAfter(Instant.now());
        compared = instant.isBefore(Instant.now());
        compared = instant.equals(Instant.now());

        // with

        instant = instant.with(ChronoField.NANO_OF_SECOND, 44444);

        // plus/minus

        instant = instant.plusNanos(100);
        instant = instant.plusMillis(100);
        instant = instant.plusSeconds(100);

        instant = instant.minus(9000, ChronoUnit.HALF_DAYS);

        // valeurs valides de ChronoUnit:
        //• NANOS
        //• MICROS
        //• MILLIS
        //• SECONDS
        //• MINUTES
        //• HOURS
        //• HALF_DAYS
        //• DAYS

//        instant = instant.plus(78, ChronoUnit.CENTURIES);-> UnsupportedTemporalTypeException

        // formattage
        // Pas de formattage pour Instant. Ilexiste juste un toString()
        System.out.println(instant);

    }
}
