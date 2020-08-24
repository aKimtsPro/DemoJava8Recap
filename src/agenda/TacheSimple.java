package agenda;

import java.time.Duration;
import java.time.LocalDateTime;

public class TacheSimple extends Tache {

    private Runnable action;

    public TacheSimple(Runnable action, LocalDateTime date, Agenda agenda) {
        this.action = action;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(Duration.ofDays(1));
    }
    public TacheSimple(Runnable action, LocalDateTime date, Agenda agenda, Duration duree) {
        this.action = action;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(duree);
    }

    @Override
    public void executer() {
        System.out.println("La tache simple du " + this.getDebut().format( OutilDate.getDateFormat() ) + " est exécutée.");
        action.run();
    }
}
