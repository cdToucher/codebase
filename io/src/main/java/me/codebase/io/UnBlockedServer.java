package me.codebase.io;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by chendong on 2017/12/21.
 */
public class UnBlockedServer implements Constants {

    public static void main(String[] args) throws IOException {
        System.out.println(SelectionKey.OP_ACCEPT);
        server();
    }

    private static void server() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(blockedIOPort));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            SocketChannel channel = serverSocketChannel.accept();
            Socket socket = channel.socket();
            System.out.println(IOUtils.toString(socket.getInputStream()));
        }
        serverSocketChannel.close();
        selector.close();
    }

}
