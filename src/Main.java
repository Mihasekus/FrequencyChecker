public class Main {

    public static void main(String[] args) throws InterruptedException {
        int N = 5;
        FrequencyChecker frequencyChecker = new MessageFilter(N);
        while (true) {
            Thread.sleep(500);
            System.out.println(frequencyChecker.isAllowed());

        }
    }
}

