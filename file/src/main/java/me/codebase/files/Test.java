package me.codebase.files;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Test {

    public static void main(String[] args) throws Exception {
        String[] arr = readStr("resource")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\n", "")
                .replaceAll("\r", "")
                .trim().split(",");
        Lists.partition(Stream.of(arr).map(String::trim).filter(s -> s != null && s.length() > 0).collect(Collectors.toList()), 10)
                .forEach(line -> {
                    line.forEach(str -> out.print(str + " ,"));
                    out.print("\n");
                });
    }

    private static String readStr(String fileName) throws IOException {
        URL url = Resources.getResource(fileName);
        return Resources.toString(url, Charset.defaultCharset());
    }

    private static List<String> readLines(String fileName) throws IOException {
        URL url = Resources.getResource(fileName);
        return Resources.readLines(url, Charset.defaultCharset());
    }

    private static <T> Collection<List<T>> partition(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }
}
