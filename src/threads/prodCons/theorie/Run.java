package threads.prodCons.theorie;

public class Run {

    public static void main(String[] args) {

        PC prodCons = new PC();

        Thread producer = new Thread( () ->
        {
            try{
                prodCons.produce();
            }
            catch (InterruptedException ie)
            {
                System.out.println("production interrupted");
            }
        } );

        Thread consumer = new Thread( () ->
        {
            try{
                prodCons.consume();
            }
            catch (InterruptedException ie)
            {
                System.out.println("production interrupted");
            }
        } );


        producer.start();
        consumer.start();



    }

}
