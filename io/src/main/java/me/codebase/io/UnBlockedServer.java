package me.codebase.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chendong on 2017/12/21.
 * <p>
 * reactor pattern | nio
 * <p>
 * single thread & one selector & several channels
 */
public class UnBlockedServer implements Constants {

    public static void main(String[] args) throws IOException {
        server();
    }


    /*
    * important class:
    *
    * ByteBuffer  非阻塞IO操作的核心类之一
    *
    * Channel 既可读又可写 ，同步非阻塞
    *
    * Selector
    * */
    private static void server() throws IOException {
        try (Selector selector = Selector.open()) {
            try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
                serverSocketChannel.bind(new InetSocketAddress(blockedIOPort));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

                while (selector.select() > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            ServerSocketChannel acceptServerSocketChannel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = acceptServerSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (key.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            int count = socketChannel.read(buffer);
                            if (count <= 0) {
                                socketChannel.close();
                                key.cancel();
                                continue;
                            }
                            // do something
                            System.out.print(new String(buffer.array(), Charset.defaultCharset()));
                        } else if (key.isWritable()){

                        }
                        keys.remove(key);
                    }
                }
            }
        }
    }

}
