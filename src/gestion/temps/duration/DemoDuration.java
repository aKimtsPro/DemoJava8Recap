package gestion.temps.duration;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DemoDuration {

    public static void main(String[] args) {

        // ChronoUnit valides :
        //• NANOS
        //• MICROS
        //• MILLIS
        //• SECONDS
        //• MINUTES
        //• HOURS
        //• HALF_DAYS
        //• DAYS

        Duration duration = Duration.of(50, ChronoUnit.HOURS);
        duration = Duration.ofDays(1);
        duration = Duration.ofHours(2);
        duration = Duration.ofMinutes(3);
        duration = Duration.ofSeconds(4);
        duration = Duration.ofSeconds(5, 4578);
        duration = Duration.ofMillis(6);
        duration = Duration.ofNanos(7);

        duration = Duration.between(LocalTime.MIDNIGHT, LocalTime.now());
        System.out.println(duration);
        // get

        long toWrite;

        // 2 valeurs valides de ChronoUnit
        // - SECONDS
        // - NANO

        toWrite = duration.get(ChronoUnit.SECONDS);
        toWrite = duration.get(ChronoUnit.NANOS);
        toWrite = duration.getSeconds();
        toWrite = duration.getNano();

        for (TemporalUnit unit :
                duration.getUnits()) {
            System.out.println(unit);
        }

        // with

        duration = duration.withNanos(7000);
        duration = duration.withSeconds(7);

        // plus/minus

        duration = duration.plusDays(1);
        duration = duration.plusHours(2);
        duration = duration.plusMillis(3);
        duration = duration.plusMinutes(4);
        duration = duration.plusNanos(5);
        duration = duration.plusSeconds(6);

        duration = duration.minus(Duration.of(5, ChronoUnit.DAYS));
        duration = duration.minus(5, ChronoUnit.MINUTES);

        // autres opérations

        duration = duration.abs(); // valeur absolue
        duration = duration.dividedBy(2);
        duration = duration.multipliedBy(2);

        // verifications et comparaison

        duration.compareTo(Duration.ZERO);
        duration.isNegative();
        duration.isZero();


        System.out.println(duration);

    }

}
