package listeners;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Text {

    private String monTexte = "";

    private List<TextListener> listeners = new ArrayList<>();

    public String getMonTexte() {
        return monTexte;
    }

    public void setMonTexte(String monTexte) {

        this.monTexte = monTexte;
        notifyMonTexteChanged();

    }

    public void notifyMonTexteChanged(){
        listeners.forEach( listeners -> listeners.onTextChanged( monTexte ) );
    }

    public void addListener(TextListener listener){
        if(listener == null)
            throw new IllegalArgumentException("listener cannot be null");

        listeners.add(listener);
    }
}
