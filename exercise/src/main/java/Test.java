/**
 * Created by chendong on 2017/7/24.
 */
public class Test {


    public static void main(String[] args) {
        Test test = new Test();
        ClassLoader classLoader = test.getClass().getClassLoader();

        System.out.println(classLoader);                           // Application ClassLoader  -> Customer ClassLoader  (User application jars/classes)
        System.out.println(classLoader.getParent());               // Ext ClassLoader          -> ext     or -Djava.ext.dirs jars/classes
        System.out.println(classLoader.getParent().getParent());   // BootStrap ClassLoader    -> jre/lib or -Xbootclasspath  jars/classes
        //last class loader is written by 'c';
    }
}
