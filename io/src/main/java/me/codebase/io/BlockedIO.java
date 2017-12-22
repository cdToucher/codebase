package me.codebase.io;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chendong on 2017/12/21.
 */
public class BlockedIO implements Constants {


    public static void main(String[] args) throws IOException {

        server();
//        ThreadPoolServer();

    }

    private static void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress socketAddress = new InetSocketAddress(blockedIOPort);
        serverSocket.bind(socketAddress);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            System.out.println(IOUtils.toString(inputStream));
//       BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            IOUtils.closeQuietly(inputStream);
        }

    }

    private static void ThreadPoolServer() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(blockedIOPort));
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                executorService.submit(() -> {
                    try {
                        InputStream inputstream = socket.getInputStream();
                        System.out.println(IOUtils.toString(new InputStreamReader(inputstream)));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
            }
        } catch (IOException ex) {
            try {
                serverSocket.close();
            } catch (IOException ignored) {
            }
            ex.printStackTrace();
        }
    }


}
