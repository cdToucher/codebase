import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chendong on 2017/7/24.
 */
public class Test {

    private static final int foo = 1;
    private static final Map<String, String> fooMap = new HashMap<>();

    private static String fooStr = "2";

    static {
        fooMap.put("3", "3");
        System.out.println(foo);
        System.out.println(fooMap.get("3"));
        System.out.println(fooStr);
    }

    public static void main(String[] args) throws InterruptedException {
      /*  Test obj1 = new Test();
        obj1.setName("1");
        obj1.setTime(1000);
        Test obj2 = new Test();
        obj2.setName("2");
        obj2.setTime(500);

        new Thread(new DeadLock(obj1, obj2)).start();
        new Thread(new DeadLock(obj2, obj1)).start();*/
      Test test = new Test();
    }

    public Test() {
        System.out.println("6");
    }

    @PostConstruct
    @PreDestroy
    public void init(){
        System.out.println("5");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    private long time;

    public static class DeadLock implements Runnable {

        private Test obj1;
        private Test obj2;

        DeadLock(Test obj1, Test obj2) {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        @Override
        public void run() {
            synchronized (obj1) {
                try {
                    System.out.println(obj1.getName());
                    Thread.sleep(obj1.getTime());
                    synchronized (obj2) {
                        System.out.println(obj2.getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void test() throws InterruptedException {
        Test test = new Test();
        ExecutorService s = Executors.newSingleThreadExecutor();
        s.submit(() -> {
            System.out.println("0");
            synchronized (test) {
                System.out.println("3");
                test.notify();
            }
        });
        synchronized (test) {
            System.out.println("1");
            test.wait(1000);
            System.out.println("2");
        }
        s.shutdown();
    }

    static final int hash(Object key) {

        //        Collections.synchronizedMap()
        //与（&）、非（~）、或|、异或（^）

        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
