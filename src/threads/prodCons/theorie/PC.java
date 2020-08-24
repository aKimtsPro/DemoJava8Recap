package threads.prodCons.theorie;

import java.util.ArrayList;
import java.util.List;

public class PC {

    List<Integer> list = new ArrayList<>();
    final int capacity = 3;

    public void consume() throws InterruptedException
    {

        while(true)
        {

            synchronized (this)
            {
                if( list.isEmpty() )
                {
                    this.wait();
                }

                System.out.println( " *** consumed = " + list.remove(0));

                this.notify();
            }

            Thread.sleep(1000);

        }

    }

    public void produce() throws InterruptedException
    {
        int value = 0;
        while(true)
        {

            synchronized (this)
            {
                if(list.size() == capacity)
                {
                    this.wait();
                }

                System.out.println( "produced = " + value );
                list.add( value++ );

                this.notify();
            }

            Thread.sleep(100);

        }

    }
}
