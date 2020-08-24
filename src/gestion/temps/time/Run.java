package gestion.temps.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Run {

    public static void main(String[] args) {

        // Construire un LocalTime
        LocalTime time = LocalTime.now();

        time = LocalTime.of(12,52);
        time = LocalTime.of(12,52, 34);
        time = LocalTime.of(12,52, 34, 897);

//        time = LocalTime.ofSecondOfDay(85432); // 0 - 86_399
//        time = LocalTime.ofNanoOfDay(86787655); // 0 - 86_399_999_999_999

//        time = LocalTime.MIN;
//        time = LocalTime.MAX;

        // Recupérer des infos

        long toWrite;

        toWrite = time.getHour();
        toWrite = time.getMinute();
        toWrite = time.getSecond();
        toWrite = time.getNano();

        toWrite = time.get(ChronoField.SECOND_OF_DAY);
        toWrite = time.getLong(ChronoField.NANO_OF_DAY);

        // valeurs valides de ChronoField
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
        // Pour verifier qu'un ChronoField est supporté:
        time.isSupported(ChronoField.EPOCH_DAY); // -> false

//        System.out.println( time.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)); -> UnsupportedTemporalTypeException

        // Comparer mon LocalTime

        boolean test = time.isAfter(LocalTime.now());
        test = time.isBefore(LocalTime.now());
        test = time.equals(LocalTime.now());

        // "Modifier" mon LocalTime

        time = time.withHour(1);
        time = time.withMinute(59);
        time = time.withSecond(7);
        time = time.withNano(98613);

        time = time.with(ChronoField.SECOND_OF_DAY, 83984);
        System.out.println(time);

        // plus/minus

        time = time.plusHours(1);
        time = time.plusMinutes(3);
        time = time.plusSeconds(25);
        time = time.plusNanos(10700000);

        time = time.minus(500, ChronoUnit.SECONDS);

        // valeurs valides pour ChronoUnit:
        // - NANOS
        // - MICROS
        // - MILLIS
        // - SECONDS
        // - MINUTES
        // - HOURS
        // - HALF_DAYS

//        time.minus(8, ChronoUnit.CENTURIES); ->UnsupportedTemporalTypeException

        System.out.println( time );

        // Formattage

        // format par defaut : [HH:mm] -> 12:52
        //                      [HH:mm:ss] -> 12:52:34
        //                      [HH:mm:ss.SSSSSSSSS] -> 12:52:34.000000897
        // doc : https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html


        System.out.println( time.format( DateTimeFormatter.ofPattern("'heure':HH\n'minute':mm\n'seconde':ss\n'nano':SSSSSSSSS") ) );

    }
}
