import java.util.concurrent.locks.*;
/**
 * Calculates the sum from 1 to N
 *
 * @Seth Malin
 * @version (a version number or a date)
 */

public class Summation implements Runnable
{
    private long upper;
    private long startFrom;
    private Sum sumValue;
    private ReentrantLock lock = new ReentrantLock();
    public Summation  (long upper, long startFrom, Sum sumValue)
    {
        this.upper = upper;
        this.startFrom = startFrom;
        this.sumValue = sumValue;
    }

    public void run()
    {
        long sum = sumValue.getSum();
        long newSum = 0;
        if (startFrom == 0)
        {
            try
            {
                newSum = sum;
                lock.lock();
                for (long i = 0; i <= upper; i++)
                {
                    newSum +=i;
                }
                sumValue.setSum(newSum + sum);
            }
            finally
            {
                lock.unlock();
            }
        }
        else
        {
            try

            {
                lock.lock();
                newSum = startFrom;
                for (long i = newSum+1; i <= upper; i++)
                {
                    newSum +=i;
                }
                sumValue.setSum(newSum + sum);
            }
            finally
            {
                lock.unlock();
            }
        }
    }

}