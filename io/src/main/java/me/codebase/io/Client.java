package me.codebase.io;

import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by chendong on 2017/12/21.
 */
public class Client implements Constants {

    public static void main(String[] args) throws IOException {
        client();
    }

    private static void client() throws IOException {
        OutputStream outputStream;
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", blockedIOPort));
            outputStream = socket.getOutputStream();
            Resources.asByteSource(Resources.getResource(".gitignore")).copyTo(outputStream);
            IOUtils.closeQuietly(outputStream);
        }
    }
}
