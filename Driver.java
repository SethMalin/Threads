/**
 * Driver class
 *
 * @Seth Malin
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main (String[] args)

    {
        long start = System.nanoTime();
        Sum sumObject = new Sum();
        Sum sumObject2 = new Sum();
        long n = 100000000;
        long upper = n/2; //first sum goes up to
        long lower = upper + 1; //second sum starts from
        Thread thrd1 = new Thread (new Summation(upper, 0, sumObject));
        Thread thrd2 = new Thread (new Summation(n, lower, sumObject2));
        thrd1.start();
        thrd2.start();
        try 
        {
            thrd1.join();
            thrd2.join();
            long totalSum = sumObject.getSum() + sumObject2.getSum();
            System.out.println ("The sum of " + n +" is "+ totalSum);
        } 
        catch (InterruptedException ie) 
        {
        }

        {
            long finish = System.nanoTime();
            long duration = finish - start;
            System.out.println("It took " + duration +" nano seconds to execute the summation");
        }
    }
}

