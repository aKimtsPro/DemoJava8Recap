package threads.prodCons.exo;

public class StockFullException extends RuntimeException{

    public StockFullException() {
        super("Stock is full");
    }

}
