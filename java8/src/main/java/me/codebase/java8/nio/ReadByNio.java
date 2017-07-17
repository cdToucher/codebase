package me.codebase.java8.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by chendong on 2017/2/15.
 * <p>
 * test io by java nio
 *
 * @since jdk 1.4
 */
public class ReadByNio {

    public static void main(String[] args) throws IOException {
//        RandomAccessFile raf = new RandomAccessFile( "E:\\test22.txt", "rw" );
        final String path = "E:/8.txt";
        FileInputStream stream = new FileInputStream(new File(path));
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // get channel
        FileChannel fileChannel = stream.getChannel();
        fileChannel.read(buffer);

        buffer.flip();
//        System.out.write(buffer.array());

        CharBuffer charBuffer = buffer.asCharBuffer();
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
        fileChannel.close();
    }
}
