package me.codebase.utilFramework.guava;

import com.google.common.collect.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.LinkedList;

/**
 * Created by chendong on 2017/2/10.
 * <p>
 * immutable collection test
 */
public class GuavaCollectionTest {

    public static void main(String[] args) throws IOException {
/*        File file = new File("E/phoneNum.txt");
        Random random = new Random(System.currentTimeMillis());
        List<Long> longs = random.longs(12).boxed().map(l-> Files.isWritable())*/
        LinkedList<BitSet> sets = new LinkedList<>();
        long minNum = 13000000000L;
        long maxNum = 19000000000L;
        long initialCapacity = 10000000;
        BitSet bitSet = new BitSet();
        BitSet bitSet2 = new BitSet();
        int aa =1;
        System.out.println(bitSet.cardinality());
        bitSet.set(4);
        bitSet.set(5);
        bitSet.set(9);
        System.out.println(bitSet.get(4));
        System.out.println(bitSet.cardinality());
        System.out.println((maxNum - minNum) / initialCapacity);
        System.out.println((double) (maxNum - minNum) / 8 / 1024 / 1024);
        System.out.println((double) bitSet.toByteArray().length/1024/1024);
        System.out.println((double) bitSet2.toByteArray().length);
        System.out.println(aa);
    }

    private static void test2() throws IOException {
//        BufferedReader reader2 = new BufferedReader(new FileReader(new File("")));
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (new FileInputStream(new File("")), Charset.defaultCharset()));
        long max = 0;
        long min = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            long phoneNum = Long.valueOf(line.trim());

        }
    }

    private static void test1() {
        ImmutableList immutableList = ImmutableList.builder().add("A").build();
        ImmutableList.copyOf(immutableList);
        ImmutableList.of("A");
        BiMap<String, String> map = HashBiMap.create(1);
        map.put("A", "B");
        map.inverse().get("A");
        Table<String, String, Integer> table = HashBasedTable.create(1, 2);
    }
}

