package gestion.temps.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        // Creer un LocalDate

        LocalDate date = LocalDate.of(2010, 10,10);
        date = LocalDate.of(2010, Month.OCTOBER, 10);

        date = LocalDate.now(); // La gestion.temps.date d'aujourd'hui

        // Epoch = 1 janvier 1970
        date = LocalDate.ofEpochDay(5000);

        date = LocalDate.ofYearDay(2020, 160);
//        gestion.temps.date = LocalDate.ofYearDay(2020, 669); -> DateTimeException

        date = LocalDate.parse("2000-01-01");
//        gestion.temps.date = LocalDate.parse("01-01-2000"); -> DateTimeParseException
        System.out.println( date );

        // valeurs limites:
        date = LocalDate.MAX; // 1/1/+999999999
        date = LocalDate.MIN; // 1/1/-999999999

        System.out.println(date);


        // Les gets nous permettent de récuperer des infos sur notre gestion.temps.date

        // Il y a des get servant à récuperer des valeurss particulières
        date.getYear();
        date.getDayOfWeek();
        date.getMonthValue();
        // ...

        // et d'autres plus versatiles utilisant un TemporalField(ChronoField)

        date.get(ChronoField.MONTH_OF_YEAR);
        date.getLong(ChronoField.EPOCH_DAY);

        // Seules certaines valeurs de ChronoField sont utilisables:
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

//      gestion.temps.date.get(ChronoField.SECOND_OF_DAY); -> UnsupportedTemporalTypeException (valeur de ChronoField invalide)
//      gestion.temps.date.get(ChronoField.MONTH_OF_YEAR); -> UnsupportedTemporalTypeException (necessite le getLong)


        // Les plus et minus nous permettent de modifier les infos de notre gestion.temps.date
        // Il y a des plus et minus servant à modifier des valeurs particulières


        date = date.plusDays(1);
        date = date.plusWeeks(1);
        date = date.plusMonths(1);
        date = date.plusYears(1);

        // et d'autres plus versatiles utilisant un TemporalUnit(ChronoUnit)

        date = date.plus(5, ChronoUnit.YEARS);
        date = date.minus(3, ChronoUnit.DAYS);

        date = date.plus( Period.of(2, 0, 5) );

        // Seules certaines valeurs de ChronoUnit sont valides:
        //  - DAYS
        //  - WEEKS
        //  - MONTHS
        //  - YEARS
        //  - DECADES
        //  - CENTURIES
        //  - MILLENNIA
        //  - ERAS

//        System.out.println( LocalDate.now().plus(1, ChronoUnit.ERAS) ); -> DateTimeException : valeur invalide
//        gestion.temps.date.plus(5, ChronoUnit.MINUTES); -> UnsupportedTemporalTypeException (valeur de ChronoUnit invalide)

        // Formattage

        // format par defaut : [yyyy-MM-dd] -> 2000-01-01
        // doc : https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern( "(dd ° MM ° yyyy)" );

        System.out.println( date.format( dtf ) ); // formatter
        date = LocalDate.parse( "(15 ° 10 ° 2005)", dtf ); // parser pour creer
        System.out.println(date);

        ChronoLocalDate.from(LocalDate.now());
    }

}
