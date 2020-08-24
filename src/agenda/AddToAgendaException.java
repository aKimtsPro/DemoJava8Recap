package agenda;

public class AddToAgendaException extends RuntimeException {

    public AddToAgendaException() {
        super("La tache ajoutée devrait être antécédente à la gestion.temps.date du jour actuel et ne devrait pas se superposer à une autre.");
    }
}
