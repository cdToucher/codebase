import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chendong on 2017/7/24.
 */
public class Test {

    public static void main(String[] args) {
        List<String> syncList= Collections.synchronizedList(new ArrayList<>());
    }
}
