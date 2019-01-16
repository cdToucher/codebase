package me.codebase.netty.sample;


import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
/**
 * Created by chendong on 2017/5/8.
 * <p>
 * this is a begin of netty learning project;
 */
public class Simple {

    static final int port = 9000;
    static final String address = "localhost";

    public static void main(String[] args) throws IOException {
        run();
        socketClient();
    }

    private static void socketClient() {
        try {
            Socket socket = new Socket(address, port);
            DataInputStream in = new DataInputStream(socket
                    .getInputStream());
            DataOutputStream out = new DataOutputStream(socket
                    .getOutputStream());

            // 装饰标准输入流，用于从控制台输入
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String send = scanner.nextLine();
                String message = "clent " + send;
                System.out.println(message);
                // 把从控制台得到的信息传送给服务器
                out.writeUTF(message);
                // 读取来自服务器的信息
                String accpet = in.readUTF();
                System.out.println(accpet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run() {
        // Configure the server.
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()
        ));

        // Set up the pipeline factory.
        bootstrap.setPipelineFactory(() -> Channels.pipeline(new EchoServerHandler()));


        // Bind and start to accept incoming connections.
        bootstrap.bind(new InetSocketAddress(port));
    }

    public static class EchoServerHandler extends SimpleChannelUpstreamHandler {

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
            // Send back the received message to the remote peer.
            e.getChannel().write(e.getMessage());
        }
    }

}
