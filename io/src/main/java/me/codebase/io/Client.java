package me.codebase.io;

import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by chendong on 2017/12/21.
 */
public class Client implements Constants {

    public static void main(String[] args) throws IOException {
        client();
    }


    private static void client() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(blockedIOPort));
        OutputStream outputStream = socket.getOutputStream();
        List<String> lines = Resources.readLines(Resources.getResource(".gitignore"), Charset.defaultCharset());
        for (String str : lines) {
            outputStream.write(str.getBytes());
        }
        outputStream.write(String.valueOf(Math.random()).getBytes());
        IOUtils.closeQuietly(outputStream);
    }
}
