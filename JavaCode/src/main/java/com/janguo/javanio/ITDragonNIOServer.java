package com.janguo.javanio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class ITDragonNIOServer {
    /*
     * NIO 也称 New IO， Non-Block IO，非阻塞同步通信方式
     * 从BIO的阻塞到NIO的非阻塞，这是一大进步。功归于Buffer，Channel，Selector三个设计实现。
     * Buffer   ：  缓冲区。NIO的数据操作都是在缓冲区中进行。缓冲区实际上是一个数组。而BIO是将数据直接写入或读取到Stream对象。
     * Channel  ：  通道。NIO可以通过Channel进行数据的读，写和同时读写操作。
     * Selector ：  多路复用器。NIO编程的基础。多路复用器提供选择已经就绪状态任务的能力。
     * 客户端和服务器通过Channel连接，而这些Channel都要注册在Selector。Selector通过一个线程不停的轮询这些Channel。找出已经准备就绪的Channel执行IO操作。
     * NIO通过一个线程轮询，实现千万个客户端的请求，这就是非阻塞NIO的特点。
     */

    private final int BUFFER_SIZE = 1024;  //缓冲区大小
    private final int PORT = 8899;         //监听端口
    public Selector selector;              // 多路复用器，NIO编程的基础，负责管理通道Channel
    private ByteBuffer readBuffer = ByteBuffer.allocate(BUFFER_SIZE); // 缓冲区Buffer

    public ITDragonNIOServer(){
        startServer();
    }

    private void startServer(){
        try {
            // 1. 开启多路复用器
            selector = Selector.open();
            // 2. 打开服务器通道（网络读写通道）
            ServerSocketChannel channel = ServerSocketChannel.open();
            // 3. 设置服务器通道为非阻塞，true为阻塞，false为非阻塞
            channel.configureBlocking(false);
            // 4. 绑定端口
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
