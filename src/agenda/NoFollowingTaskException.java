package agenda;

public class NoFollowingTaskException extends RuntimeException {

    public NoFollowingTaskException() {
        super("Il n'y a pas de tâches suivantes à exécuter.");
    }
}
