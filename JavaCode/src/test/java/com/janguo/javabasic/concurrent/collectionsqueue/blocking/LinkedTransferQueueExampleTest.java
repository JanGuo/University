package com.janguo.javabasic.concurrent.collectionsqueue.blocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class LinkedTransferQueueExampleTest {

    private LinkedTransferQueueExample example;

    @Before
    public void setUp() throws Exception {
        example = new LinkedTransferQueueExample();
    }

    @After
    public void tearDown() throws Exception {
        example = null;
    }

    @Test
    public void testTryTransfer() {
        LinkedTransferQueue<String> queue = example.creat();

        assertThat(queue.tryTransfer("Java"), equalTo(false));

        assertThat(queue.size(), equalTo(0));
    }

    @Test
    public void testTransfer() throws InterruptedException {
        LinkedTransferQueue<String> queue = example.creat();

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 2, TimeUnit.SECONDS);

        queue.transfer("Java");

        assertThat(queue.size(), equalTo(0));
    }

    @Test
    public void testHasWaitingConsumer() throws InterruptedException {
        LinkedTransferQueue<String> queue = example.creat();

        assertThat(queue.hasWaitingConsumer(), equalTo(false));
        assertThat(queue.getWaitingConsumerCount(), equalTo(0));

        List<Callable<String>> callableList = IntStream.rangeClosed(1, 5).boxed().map(integer -> (Callable<String>)
                () -> {
                    try {
                        return queue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).collect(Collectors.toList());

        ExecutorService service = Executors.newCachedThreadPool();
        callableList.stream().forEach(stringCallable -> {
            Future<String> stringFuture = service.submit(stringCallable);
//            try {
//                System.out.println(stringFuture.get());
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
        });

        TimeUnit.SECONDS.sleep(1);

        assertThat(queue.hasWaitingConsumer(), equalTo(true));
        assertThat(queue.getWaitingConsumerCount(), equalTo(5));

        ExecutorService service1 = Executors.newSingleThreadExecutor();


        IntStream.rangeClosed(1, 5).boxed().map(integer -> "Hello" + integer).forEach(queue::add);

        TimeUnit.SECONDS.sleep(2);
        assertThat(queue.hasWaitingConsumer(), equalTo(false));
        assertThat(queue.getWaitingConsumerCount(), equalTo(0));
        System.out.println("-------");
        assertThat(queue.size(), equalTo(0));
        service.shutdown();
    }

    @Test
    public void teatAdd() {
        LinkedTransferQueue<String> queue = example.creat();
        assertThat(queue.add("Hello"), equalTo(true));
        assertThat(queue.size(),equalTo(1));
    }
}