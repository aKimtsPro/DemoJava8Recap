package listeners;

import java.io.Closeable;
import java.util.Scanner;

public class InterfaceConsole implements Closeable, TextListener {

    Scanner scanner = new Scanner(System.in);
    Text text;

    public InterfaceConsole(Text text) {
        this.text = text;
        text.addListener(this);
    }

    public String askString(){
        System.out.println("Veuillez entrer la prochaine valeur du text.");
        return scanner.nextLine();
    }

    public void start(){
        while (true)
            text.setMonTexte( askString() );
    }

    public void close(){
        scanner.close();
    }

    @Override
    public void onTextChanged(String text) {
        System.out.println( text );
    }
}
