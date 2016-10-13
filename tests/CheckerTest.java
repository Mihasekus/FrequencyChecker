import org.junit.Assert;
import org.junit.Test;


public class CheckerTest {
    @Test
    public void setExpressions() throws InterruptedException {
        int N=3;
        int Interval=60000;
        int pause=500;
        FrequencyChecker frequencyChecker= new MessageFilter(N,Interval);
        for(int i=0;i<N;i++)
        {
            Thread.sleep(pause);
            if(!frequencyChecker.isAllowed()){
                Assert.assertTrue(false);
            }
        }
        for(int i=0;i<Interval/pause-N;i++)
        {
            Thread.sleep(pause);
            if(frequencyChecker.isAllowed()) {
                Assert.assertTrue(false);
            }
        }
        for(int i=0;i<N;i++)
        {
            Thread.sleep(pause);
            if(!frequencyChecker.isAllowed()){
                Assert.assertTrue(false);
            }
        }
        Assert.assertTrue(true);
    }

}
