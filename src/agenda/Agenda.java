package agenda;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Agenda {

    // singleton

    private static Agenda instance = null;

    public static Agenda getInstance() {

        if(instance == null)
            instance = new Agenda(null);

        return instance;
    }

    // champs

    private Personne proprietaire;
    private ArrayList<Tache> taches = new ArrayList<>();
    private LocalDateTime momentActuel;

    // constructeurs

    private Agenda(Personne proprietaire) {
        this.proprietaire = proprietaire;
        this.momentActuel = LocalDateTime.now().minusYears(1);
    }

    // methodes

    public ArrayList<Tache> tachesPassees()
    {
        return taches.stream()
                .filter(tache -> !tache.getFin().isAfter(momentActuel))
                .collect( Collectors.toCollection( ArrayList::new ) );
    }

    public ArrayList<Tache> tachesFutures()
    {
        return taches.stream()
                .filter(tache -> tache.getDebut().isAfter(momentActuel))
                .collect( Collectors.toCollection( ArrayList::new ) );
    }

    public Optional<Tache> prochaineTache()
    {
        return tachesFutures().stream()
                .min( Tache::compareTo );
    }

    public boolean add(Tache toAdd)
    {
        boolean test = tachesFutures().stream()
                .allMatch(toAdd::isFree);

        if( !momentActuel.isBefore(toAdd.getDebut()) || !test)
            throw new AddToAgendaException();


        System.out.println("Tache ajoutée le " + toAdd.getDebut().format(OutilDate.getDateFormat()));
        return taches.add(toAdd);
    }

    public void deplacerTachesFutures(int nbrJour)
    {
        Optional<Tache> prochain = prochaineTache();
        if( nbrJour < 0 )
            throw  new IllegalArgumentException("Impossible de déplacer les Tache dans le passé");

        tachesFutures().forEach(
                tache -> tache.setDebut( tache.getDebut().plusDays( nbrJour ) )
        );
        System.out.println("\nTache futures déplacées de " + nbrJour + " jours.");
    }

    // Execute la prochaine Tache
    public void executerNext()
    {
        Tache tache = prochaineTache().orElseThrow( NoFollowingTaskException::new );
        setMomentActuel( tache.getFin() );
        tache.executer();
        System.out.println("\nNous sommes désormais le " +  momentActuel.format( OutilDate.getDateFormat() ) + "\n");
    }

    // Récupère la durée du temps libre
    public Duration getFreeTimeOn(LocalDate date)
    {
        Optional<Duration> optBusyTime = instance.taches.stream()
                .filter( tache -> tache.isExecutedOn(date) )
                .map( tache -> tache.getTimeSpentOnDay(date) )
                .reduce( Duration::plus );

       return Duration.ofDays(1).minus( optBusyTime.orElse(Duration.ZERO) );
    }

    // get/set

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public LocalDateTime getMomentActuel() {
        return momentActuel;
    }

    private void setMomentActuel(LocalDateTime momentActuel) {
        this.momentActuel = momentActuel;
    }
}
