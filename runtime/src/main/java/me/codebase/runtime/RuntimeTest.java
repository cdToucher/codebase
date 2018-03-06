package me.codebase.runtime;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

/**
 * Created by chendong on 2018/1/18.
 */
public class RuntimeTest {


    public static void main(String[] args) throws IOException {

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());

        Process process = Runtime.getRuntime().exec("java -version");
        System.out.println(IOUtils.toString(process.getErrorStream()));
    }
}
