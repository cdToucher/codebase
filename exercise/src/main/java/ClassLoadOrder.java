public class ClassLoadOrder {


    private int a = 10;

    private static int b = new Integer(10);

    private static int c = 10;

    static {

    }

    ClassLoadOrder() {

    }

    public static void main(String[] args) {
        ClassLoadOrder order = new ClassLoadOrder();


    }
}
