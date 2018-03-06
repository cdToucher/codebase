import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SyncTest {

    private final Object object1 = new Object();

    private final Object object2 = new Object();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        SyncTest test = new SyncTest();
        IntStream.range(0, 5).forEach(i -> {
        });
    }

    private void synchronized1(Object object1) {
        synchronized (object1) {
            System.out.println(object1);
        }
    }

    private void synchronized2(Object object1) {
        synchronized (object1) {
            System.out.println(object1);
        }
    }
}
