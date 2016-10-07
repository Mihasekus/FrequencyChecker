import java.util.ArrayList;

public class MessageFilter implements FrequencyChecker {
    private int maxMessagesAmount;
    private ArrayList<Long> messageTimestamps;
    public MessageFilter(int N) {
        if (N < 0) {
            throw new IllegalArgumentException("Message amount can`t be negative");
        }
        maxMessagesAmount = N;
        messageTimestamps = new ArrayList<Long>(N);
    }

    public boolean isAllowed() {
        while (messageTimestamps.size() > 0) {
            if (System.currentTimeMillis() - messageTimestamps.get(0) > 60000) {
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
