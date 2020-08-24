package threads.prodCons.exo;

public class StockFullException extends RuntimeException{

    public StockFullException() {
    }

    public StockFullException(String message) {
        super(message);
    }

    public StockFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockFullException(Throwable cause) {
        super(cause);
    }

    public StockFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
