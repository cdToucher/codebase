package me.codebase.files;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareUtil {

    public static void compareAndLeft(Function<String, String> mapper) throws IOException {
        List<String> oldLines = readAndTransform(mapper, "old");
        List<String> newLines = readAndTransform(mapper, "new");
        List<String> onlyExistInOld = oldLines.stream().filter(str -> !newLines.contains(str)).collect(Collectors.toList());
        List<String> onlyExistInNew = newLines.stream().filter(str -> !oldLines.contains(str)).collect(Collectors.toList());

        onlyExistInOld.forEach(System.out::println);
        System.out.println("_______________________________________________________________________________");
        onlyExistInNew.forEach(System.out::println);
    }

    public static List<String> readAndTransform(Function<String, String> mapper, String fileName) throws IOException {
        return Resources.readLines(Resources.getResource(fileName), Charset.defaultCharset())
                .stream()
                .filter(str -> str.trim().length() > 0)
                .map(mapper)
                .collect(Collectors.toList());
    }

}
