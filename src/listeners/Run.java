package listeners;

public class Run {

    public static void main(String[] args) {

        Text t = new Text();
        StringSizeWin ssw = new StringSizeWin(t);
        try(InterfaceConsole ic = new InterfaceConsole(t))
        {
            ic.start();
        }

    }

}
