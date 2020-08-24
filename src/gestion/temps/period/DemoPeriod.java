package gestion.temps.period;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

public class DemoPeriod {

    public static void main(String[] args) {

        // Creer une une peri

        Period p = Period.between(LocalDate.now(), LocalDate.ofEpochDay(0) );
        p = Period.of(12, 50, 79);
        p = Period.ofDays(42);
        p = Period.ofWeeks(89);
        p = Period.ofMonths(1);
        p = Period.ofYears(12);
        p = Period.from( Period.ZERO );
        p = Period.parse("P20Y54D");

        // récuperer des infos

        long toWrite = p.getDays();
        toWrite = p.getMonths();
        toWrite = p.getYears();

        toWrite = p.get(ChronoUnit.MONTHS);

        System.out.println(toWrite);

        for (TemporalUnit unit: p.getUnits() ) {
            System.out.println(" - "+unit);
        }

        // Valeurs valides de ChronoUnit:
        //• DAYS
        //• MONTHS
        //• YEARS

//        p.get(ChronoUnit.DECADES); ->UnsupportedTemporalTypeException

        // modification
        p = p.withDays(1);
        p = p.withMonths(1);
        p = p.withYears(1);

        System.out.println( p );

        // plus/minus

        p = p.plusDays(1);
        p = p.plusMonths(2);
        p = p.plusYears(3);

        p.minus( Period.of(1,1,1) );

        p = p.multipliedBy(3);

        // verifications

        p.isNegative();
        p.isZero();

    }
}
