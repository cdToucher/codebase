package me.codebase.utilFramework.guava;

import com.google.common.io.Files;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringBufferInputStream;

public class FileTest {

    public static void main(String[] args) throws IOException {
        String content = "This is a testdfdfdffd for most1";
        File file = new File("Test.txt");
        StringBufferInputStream stringBufferInputStream = new StringBufferInputStream(content);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        IOUtils.copy(stringBufferInputStream, fileOutputStream);
        Files.touch(file);
    }
}
