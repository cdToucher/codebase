package me.codebase.utilFramework.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chendong on 2017/2/9.
 *
 * test collect ordering
 */
public class OrderingTest  {


    public static void main(String[] args) throws Exception{
        List<String> list = Lists.newArrayList("a","c","b");
        Ordering.natural().sortedCopy(list);

        System.out.println(list);
        System.out.println(Ordering.natural().max(3,5));
        System.out.println(Ordering.arbitrary().max(3,5));
        System.out.println(Ordering.allEqual().max(3,5));
    }

}
