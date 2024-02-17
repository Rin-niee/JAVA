import java.util.Arrays;
import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        reset();
    }

    public void reset() {
        startTime = System.currentTimeMillis();
    }

    public void start() {
        reset();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100000];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Arrays.sort(numbers);

        stopWatch.stop();

        System.out.println("Время выполнения сортировки: " + stopWatch.getElapsedTime() + " миллисекунд");
    }
}
