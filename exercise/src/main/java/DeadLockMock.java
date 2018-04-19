public class DeadLockMock implements Runnable {

    private Object obj1;
    private Object obj2;

    DeadLockMock(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1) {
            try {
                System.out.println(obj1);
                Thread.sleep(500);
                synchronized (obj2) {
                    System.out.println(obj2);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        System.out.println("This is obj1 : "+ obj1);
        Object obj2 = new Object();
        System.out.println("This is obj2 : "+ obj2);
        Thread thread1 = new Thread(new DeadLockMock(obj1, obj2));
        Thread thread2 = new Thread(new DeadLockMock(obj2, obj1));
        thread1.start();
        thread2.start();
    }
}
