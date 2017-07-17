package me.codebase.designPattern.decorator;

import java.io.FileNotFoundException;

/**
 * Created by chendong on 2017/1/24.
 * <p>
 * java io 中即使用了常用的装饰器模式可阅读源码
 * <p>
 * 基础类 InputSteam
 * <p>
 * 功能类 FileInputStream ByteArrayInputStream StringBufferInputStream
 * <p>
 * 装饰器中间类 FilterInputStream
 * <p>
 * 对功能类的装饰类 BufferedInputStream DataInputStream LineNumberInputStream
 */
public class DecoratorTest {

    public static void main(String[] args) throws FileNotFoundException {

//        String path = "";
//        FileInputStream fileInputStream = new FileInputStream(path);
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(null);
//        StringBufferInputStream stringBufferInputStream = new StringBufferInputStream("");

//        FilterInputStream filterInputStream;
//        BufferedInputStream bufferedInputStream1 = new BufferedInputStream(byteArrayInputStream);
//        DataInputStream bufferedInputStream2 = new DataInputStream(fileInputStream);
//        LineNumberInputStream bufferedInputStream3 = new LineNumberInputStream(stringBufferInputStream);

        new CreatedComponent(new ComponentInstance()).doSomething();
    }
}
