public class Main {

    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        int Interval=60000;
        int pause=500;
        FrequencyChecker frequencyChecker = new MessageFilter(N,Interval);
        while (true) {
            Thread.sleep(pause);
            System.out.println(frequencyChecker.isAllowed());

        }
    }
}

