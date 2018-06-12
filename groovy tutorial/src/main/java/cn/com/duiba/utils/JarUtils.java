package cn.com.duiba.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by gyf .
 * 2017/12/12 .
 */
public class JarUtils {

    private JarUtils() {
    }

    /**
     * 获取一个jar中的所有 .class 文件
     * @param jarPath jar在硬盘中的绝对路径
     * @return
     */
    public static List<String> getJarClasses(String jarPath) {
        JarFile jf = null;
        List<String> reuslt = new ArrayList<>();
        try {
            jf = new JarFile(jarPath);
            Enumeration<JarEntry> enumeration = jf.entries();
            while (enumeration.hasMoreElements()) {
                JarEntry entry = enumeration.nextElement();
                String entryName = entry.getName();
                if (entryName.endsWith(".class")) {
                    reuslt.add(entry.getName());
                }
            }
        } catch (IOException e) {
            System.out.println(String.format("%s 文件不存在。", jarPath));
            return Collections.emptyList();
        } finally {
            if (jf != null) {
                try {
                    jf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return reuslt;
    }
}
