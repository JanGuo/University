package com.janguo.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Reactor implements Runnable {
    final Selector selector;
    final ServerSocketChannel serverSocketChannel;

    Reactor(int port) throws IOException {
        selector = Selector.open();
        serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        selectionKey.attach(new Acceptor());
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    dispatch(iterator.next());
                    selectionKeys.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dispatch(SelectionKey key) {
        Runnable r = (Runnable) key.attachment();
        r.run();
    }

    class Acceptor implements Runnable {

        @Override
        public void run() {
            try {
                SocketChannel c = serverSocketChannel.accept();
                if (c != null) {
                    new Handler(selector, c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    class Handler implements Runnable {
        final SocketChannel socket;
        final SelectionKey sk;
        final Integer MAXIN = 1024;
        final Integer MAXOUT = 1024;
        ByteBuffer input = ByteBuffer.allocate(MAXIN);
        ByteBuffer output = ByteBuffer.allocate(MAXOUT);
        static final int READING = 0, SENDING = 1;
        int state = READING;


        Handler(Selector selector, SocketChannel socketChannel) throws IOException {
            socket = socketChannel;
            socketChannel.configureBlocking(false);
            sk = socket.register(selector, 0);
            sk.attach(this);
            sk.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }

        @Override
        public void run() {
            try {
                if (state == READING) read();
                else if (state == SENDING) send();
            }catch (Exception e){
                e.printStackTrace();
            }

//            try {
//                socket.read(input);
//                if (inputIsComplete()) {
//                    process();
//                    sk.attach(new Sender());
//                    sk.interestOps(SelectionKey.OP_WRITE);
//                    sk.selector().wakeup();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }

        void read() throws IOException {
            socket.read(input);

            if (inputIsComplete()){
                process();
                state = SENDING;
                sk.interestOps(SelectionKey.OP_WRITE);
            }
        }
        void send() throws IOException {
            socket.write(output);

            if (outputIsComplete()) sk.channel();
        }

//        class Sender implements Runnable {
//
//            @Override
//            public void run() {
//                try {
//                    socket.write(output);
//                    if (outputIsComplete()) {
//                        sk.channel();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }

        boolean inputIsComplete() {
            /* ... */
            return false;
        }

        boolean outputIsComplete() {

            /* ... */
            return false;
        }

        void process() {
            /* ... */
            return;
        }
    }
    class MthreadHandler implements Runnable{
        final SocketChannel channel;
        final SelectionKey selectionKey;
        ByteBuffer input = ByteBuffer.allocate(1024);
        ByteBuffer output = ByteBuffer.allocate(1024);
        static final int READING = 0, SENDING = 1;
        int state = READING;

        ExecutorService pool = Executors.newFixedThreadPool(2);
        static final int PROCESSING = 3;

        MthreadHandler(Selector selector, SocketChannel c) throws IOException
        {
            channel = c;
            c.configureBlocking(false);
            // Optionally try first read now
            selectionKey = channel.register(selector, 0);

            //将Handler作为callback对象
            selectionKey.attach(this);

            //第二步,注册Read就绪事件
            selectionKey.interestOps(SelectionKey.OP_READ);
            selector.wakeup();
        }

        boolean inputIsComplete()
        {
            /* ... */
            return false;
        }

        boolean outputIsComplete()
        {

            /* ... */
            return false;
        }

        void process()
        {
            /* ... */
            return;
        }

        public void run()
        {
            try
            {
                if (state == READING)
                {
                    read();
                }
                else if (state == SENDING)
                {
                    send();
                }
            } catch (IOException ex)
            { /* ... */ }
        }


        synchronized void read() throws IOException
        {
            // ...
            channel.read(input);
            if (inputIsComplete())
            {
                state = PROCESSING;
                //使用线程pool异步执行
                pool.execute(new Processer());
            }
        }

        void send() throws IOException
        {
            channel.write(output);

            //write完就结束了, 关闭select key
            if (outputIsComplete())
            {
                selectionKey.cancel();
            }
        }

        synchronized void processAndHandOff()
        {
            process();
            state = SENDING;
            // or rebind attachment
            //process完,开始等待write就绪
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }

        class Processer implements Runnable
        {
            public void run()
            {
                processAndHandOff();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Reactor reactor = new Reactor(8899);
        reactor.run();

    }
}
