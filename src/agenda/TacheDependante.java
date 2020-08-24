package agenda;

import java.time.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TacheDependante<T> extends Tache {

    private T dependance;
    private Consumer<T> consumer;
    private Predicate<T> predicat;

    public TacheDependante(T dependance, Consumer<T> consumer, LocalDateTime date, Agenda agenda) {
        this.dependance = dependance;
        this.consumer = consumer;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(Duration.ofDays(1));
    }

    public TacheDependante(T dependance, Consumer<T> consumer, Predicate<T> predicat, LocalDateTime date, Agenda agenda) {
        this.dependance = dependance;
        this.consumer = consumer;
        this.predicat = predicat;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(Duration.ofDays(1));
    }

    public TacheDependante(T dependance, Consumer<T> consumer, LocalDateTime date, Agenda agenda, Duration duree) {
        this.dependance = dependance;
        this.consumer = consumer;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(duree);
    }

    public TacheDependante(T dependance, Consumer<T> consumer, Predicate<T> predicat, LocalDateTime date, Agenda agenda, Duration duree) {
        this.dependance = dependance;
        this.consumer = consumer;
        this.predicat = predicat;
        this.setDebut(date);
        this.setAjouteDans(agenda);
        this.setDuree(duree);
    }

    public T getDependance() {
        return dependance;
    }

    public Consumer<T> getConsumer() {
        return consumer;
    }

    @Override
    public void executer() {
        if( predicat != null && predicat.test(dependance) )
            consumer.accept( getDependance() );
        else
            System.out.println("Tache dépendante du " + this.getDebut().format( OutilDate.getDateFormat() )+ " est annulée.");
    }
}
