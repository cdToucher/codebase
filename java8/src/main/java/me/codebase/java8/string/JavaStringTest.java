package me.codebase.java8.string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chendong on 2017/5/17.
 */
public class JavaStringTest {

    public static void main(String[] args) throws Exception {
        String str = String.join(",", "a", "b", "b");
        System.out.println(str);
        String str2 = "foobar:foo:bar"
                .chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.joining());

    }

    private static void findFilePaths() {
        Path start = Paths.get("");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.find(start, maxDepth, (path, basicFileAttributes) -> String.valueOf(path).endsWith(".js"))) {
            String joined = stream
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining("; \n"));
            System.out.println("Found: \n" + joined);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
