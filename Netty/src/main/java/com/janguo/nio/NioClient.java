package com.janguo.nio;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {
    public static void main(String[] args) throws Exception {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost", 8899));

            while (true) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    if (selectionKey.isConnectable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if (client.isConnectionPending()) {
                            ByteBuffer write = ByteBuffer.allocate(1024);

                            try {
                                client.finishConnect();

                                write.put((LocalDateTime.now() + "连接建立").getBytes());
                                write.flip();

                                client.write(write);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                try {
                                    write.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader br = new BufferedReader(inputStreamReader);
                                    String writeMessage = br.readLine();

                                    write.put(writeMessage.getBytes());
                                    write.flip();
                                    client.write(write);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });

                        }
                        try {
                            client.register(selector, SelectionKey.OP_READ);
                        } catch (ClosedChannelException e) {
                            e.printStackTrace();
                        }
                    } else if (selectionKey.isReadable()) {
                        SocketChannel readClient = (SocketChannel) selectionKey.channel();

                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                        int read = 0;
                        try {
                            read = readClient.read(readBuffer);
                            if (read > 0) {
                                readBuffer.flip();
//                                Charset charset = Charset.forName("UTF-8");
                                Charset charset = StandardCharsets.UTF_8;
                                String receiveMessage = charset.decode(readBuffer).toString();
                                //String string = new String(readBuffer.array(),0,read);
                                System.out.println(receiveMessage);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

                selectionKeys.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
