import org.junit.Assert;
import org.junit.Test;


public class CheckerTest {
    @Test
    public void setExpressions() throws InterruptedException {
        int N=3;
        int Interval=60000;
        int pause=500, count=0;
        long currentTime=System.currentTimeMillis();
        FrequencyChecker frequencyChecker= new MessageFilter(N,Interval);
        for(;count<N;count++)
        {
            currentTime += pause;
            if(!frequencyChecker.isAllowed(currentTime)){
                Assert.assertTrue(false);
            }
        }
        for(;count<Interval/pause;count++)
        {
            currentTime += pause;
            if(frequencyChecker.isAllowed(currentTime)) {
                Assert.assertTrue(false);
            }
        }
        for(;count<Interval/pause+N;count++)
        {
            currentTime += pause;
            if(!frequencyChecker.isAllowed(currentTime)){
                Assert.assertTrue(false);
            }
        }
        Assert.assertTrue(true);
    }

}
