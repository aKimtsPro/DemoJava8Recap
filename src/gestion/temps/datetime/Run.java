package gestion.temps.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class Run {


    public static void main(String[] args) {

        // Creer un LocalDateTime :

        LocalDateTime datetime = LocalDateTime.now();

        datetime = LocalDateTime.of(14, Month.OCTOBER, 15, 8, 37);
        datetime = LocalDateTime.of(14, 10, 15, 8, 37);

        datetime = LocalDateTime.of(14, Month.OCTOBER, 15, 8, 37, 52);
        datetime = LocalDateTime.of(14, 10, 15, 8, 37, 52);

        datetime = LocalDateTime.of(14, Month.OCTOBER, 15, 8, 37, 52, 897);
        datetime = LocalDateTime.of(14, 10, 15, 8, 37, 52, 89);

        datetime = LocalDateTime.ofEpochSecond(78451236, 87546, ZoneOffset.ofHours(1));

        datetime = LocalDateTime.MIN;//         -999999999-01-01T00:00:00.000000000
        datetime = LocalDateTime.MAX;//         +999999999-12-31T23:59:59.999999999

        datetime = LocalDateTime.from( LocalDateTime.now() );

        // Recuperer des infos

        // On a acces à toutes les méthodes 'get' déjà présentes dans LocalDate et LocalTime

        int toWrite = datetime.getYear();
        toWrite = datetime.getSecond();

        // pour les méthodes get et getLong, touts les valeurs de ChronoField sont valides:

        //      ALIGNED_DAY_OF_WEEK_IN_MONTH
        //      ALIGNED_DAY_OF_WEEK_IN_YEAR
        //      DAY_OF_WEEK
        //      DAY_OF_MONTH
        //      DAY_OF_YEAR
        //      EPOCH_DAY
        //      ALIGNED_WEEK_OF_MONTH
        //      ALIGNED_WEEK_OF_YEAR
        //      MONTH_OF_YEAR
        //      PROLEPTIC_MONTH
        //      YEAR_OF_ERA
        //      YEAR
        //      ERA
        // - NANO_OF_DAY
        // - NANO_OF_SECOND
        // - MICRO_OF_DAY
        // - MICRO_OF_SECOND
        // - MILLI_OF_DAY
        // - MILLI_OF_SECOND
        // - SECOND_OF_DAY
        // - SECOND_OF_MINUTE
        // - MINUTE_OF_DAY
        // - MINUTE_OF_HOUR
        // - HOUR_OF_AMPM
        // - CLOCK_HOUR_OF_DAY
        // - AMPM_OF_DAY
        // - HOUR_OF_DAY
        // - CLOCK_HOUR_OF_DAY

        datetime.get(ChronoField.AMPM_OF_DAY);
        datetime.getLong(ChronoField.EPOCH_DAY); // attention à la valeurs récupérée
//        datetime.get(ChronoField.NANO_OF_DAY); ->UnsupportedTemporalTypeException

        // Comparaison

        boolean test = datetime.isAfter(LocalDateTime.now());
        test = datetime.isBefore(LocalDateTime.now());
        test = datetime.isEqual(LocalDateTime.now());


        // Modification
        // Les with de LocalDate et LocalTime sont aussi défini dans un LocalDateTime

        datetime = datetime.withMonth(8);
        datetime = datetime.withMinute(55);

        // attention aux DateTimeException / voir LocalTime|LocalDate

        datetime = datetime.with(ChronoField.ERA, 0);


        // Addition/Soustraction
        // Les méthodes plus et minus sont les mêmes que dans LocalDate/LocalTime

        datetime = datetime.plusWeeks(7);
        datetime = datetime.minusMinutes(13);

        // Les valeurs de ChronoUnit sont toutes valides SAUF ChronoUnit.FOREVER:

        //  - DAYS
        //  - WEEKS
        //  - MONTHS
        //  - YEARS
        //  - DECADES
        //  - CENTURIES
        //  - MILLENNIA
        //  - ERAS
        // - NANOS
        // - MICROS
        // - MILLIS
        // - SECONDS
        // - MINUTES
        // - HOURS
        // - HALF_DAYS

        datetime = datetime.plus(45487, ChronoUnit.CENTURIES);
        System.out.println(datetime);

        // formattage
        // https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
        // le formattage peut se faire avec tout le tableau sans problème de valeurs non supportées (SAUF timezone)

        System.out.println(LocalDateTime.now());
        System.out.println( LocalDateTime.now().format(DateTimeFormatter.ofPattern( " HH'h'mm 'et' s 'secondes le ' EE dd MMMM yyyy" )) );

    }

}
