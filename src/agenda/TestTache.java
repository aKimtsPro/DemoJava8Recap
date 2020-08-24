package agenda;

import java.time.Duration;
import java.time.LocalDate;

public class TestTache {

    public static void main(String[] args) {

        Tache test1 = new TacheSimple(() -> System.out.println("in test1"), LocalDate.now().atStartOfDay().minusHours(8), null, Duration.ofHours(13));
        Tache test2 = new TacheSimple(() -> System.out.println("in test2"), LocalDate.now().atStartOfDay().plusHours(11), null, Duration.ofDays(2));

        System.out.println( Duration.between( test1.getDebut(), test1.getFin()).compareTo(Duration.ZERO) );

        Agenda a = Agenda.getInstance();

        Personne p = new Personne("luc", LocalDate.now(), 0);
        a.setProprietaire(p);

        a.add(test1);
        a.add(test2);

        System.out.println( test1.getTimeSpentOnDay(LocalDate.now()) );
        System.out.println( test2.getTimeSpentOnDay(LocalDate.now()) );

        System.out.println( OutilDate.format( a.getFreeTimeOn(LocalDate.now()) ) );

    }

}
