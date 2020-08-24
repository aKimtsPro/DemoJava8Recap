package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class OutilDate {

    public static DateTimeFormatter getDateFormat()
    {
        return DateTimeFormatter.ofPattern("dd MMMM yyyy");
    }

    public static String format(LocalDate date){
        return date.format( getDateFormat() );
    }

    public static String format(Duration duration){

        long nanos = duration.getNano();
        long secondes = duration.getSeconds();
        long minutes = secondes / 60;
        secondes %= 60;
        long heures = minutes / 60;
        minutes %= 60;
        long jours = heures / 24;
        heures %= 24;

        return String.format("j: %d\th: %d\tm: %d\ts: %d\tn: %d", jours, heures, minutes, secondes, nanos);
    }
}
