import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.stream.IntStream;

public class BloomFilterTest {

    public static void main(String[] args) {
        BloomFilter<String> filter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), 10000, 0.1);
        IntStream.range(0, 10000).forEach(i -> filter.put(String.valueOf(i)));

        System.out.println(filter.approximateElementCount());
    }
}
