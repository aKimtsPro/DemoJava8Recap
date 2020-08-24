package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public abstract class Tache implements Comparable<Tache>{

    private LocalDateTime debut;
    private Agenda ajouteDans;
    private Duration duree;

    public abstract void executer();

    public Duration getDuree() {
        return duree;
    }

    protected void setDuree(Duration duree) {
        this.duree = duree;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public Agenda getAjouteDans() {
        return ajouteDans;
    }

    public void setAjouteDans(Agenda ajouteDans) {
        this.ajouteDans = ajouteDans;
    }

    public LocalDateTime getFin()
    {
        return this.getDebut().plus(getDuree());
    }

    public boolean isFree(Tache tache)
    {
        return this.getDebut().isAfter(tache.getFin()) || this.getFin().isBefore(tache.getDebut());
    }


    public boolean isExecutedOn(LocalDate date)
    {
        LocalDateTime startOfDay = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(date, LocalTime.MAX);

        return !this.getDebut().isAfter( endOfDay ) && !this.getFin().isBefore( startOfDay );
    }

    public Duration getTimeSpentOnDay(LocalDate date)
    {
        LocalDateTime startOfDay = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        Duration rslt = this.getDuree();

        if( !this.isExecutedOn(date) )
            return Duration.ZERO;

        if( this.getDebut().isBefore(startOfDay) )
            rslt = rslt.minus(Duration.between( this.getDebut(), startOfDay ));

        if( this.getFin().isAfter(endOfDay) )
            rslt = rslt.minus(Duration.between( endOfDay, this.getFin() ));

        return rslt;
    }

    @Override
    public int compareTo(Tache o) {
        return this.getDebut().compareTo(o.getDebut());
    }
}
