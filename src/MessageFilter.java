import java.util.LinkedList;

public class MessageFilter implements FrequencyChecker {
    private int maxMessagesAmount;
    private int timeInterval;
    private LinkedList<Long> messageTimestamps;

    public MessageFilter(int N,int Interval) {
        if (N < 0) {
            throw new IllegalArgumentException("Message amount can`t be negative");
        }
        if (Interval<0) {
            throw new IllegalArgumentException("Time interval can`t be negative");
        }
        maxMessagesAmount = N;
        timeInterval=Interval;
        messageTimestamps = new LinkedList<Long>();
    }

    public boolean isAllowed() {
        synchronized (this) {
            while (messageTimestamps.size() > 0) {
                if (System.currentTimeMillis() - messageTimestamps.get(0) > timeInterval) {
                    messageTimestamps.remove(0);
                } else {
                    break;
                }
            }

            if (messageTimestamps.size() < maxMessagesAmount) {
                messageTimestamps.add(System.currentTimeMillis());
                return true;
            }

            return false;
        }
    }
}
