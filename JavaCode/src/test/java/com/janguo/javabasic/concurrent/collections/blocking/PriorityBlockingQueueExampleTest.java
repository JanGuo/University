package com.janguo.javabasic.concurrent.collections.blocking;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class PriorityBlockingQueueExampleTest {

    private static PriorityBlockingQueueExample exampel;

    @Before
    public void setUp() {
        exampel = new PriorityBlockingQueueExample();
    }

    @After
    public void tearDown() {
        exampel = null;
    }

    @Test
    public void testAddNewElement() {
        // 底层为数组，初始值为11 超过11自动扩容
        PriorityBlockingQueue<String> queue = exampel.creat();
        for (int i = 0; i < 12; i++) {
            assertThat(queue.add("Hello" + i), equalTo(true));
        }
        assertThat(queue.size(), equalTo(12));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        PriorityBlockingQueue<String> queue = exampel.creat();
        queue.add(null);
    }

    @Test(expected = ClassCastException.class)
    public void testAddObjectWithNoComparable() {

        PriorityBlockingQueue<UserNoComparable> queue = exampel.creat();
        queue.add(new UserNoComparable());
        fail("Should not process to here");
    }

    static class UserNoComparable {

    }

    @Test
    public void testAddObjectWithNoComparableButCreatArgs() {

        PriorityBlockingQueue<UserNoComparable> queue = exampel.creat(3, (o1, o2) -> o1.hashCode() - o2.hashCode());
        queue.add(new UserNoComparable());

    }

    @Test
    public void testAddObjectWithComparable() {

        PriorityBlockingQueue<UserComparable> queue = exampel.creat();
        queue.add(new UserComparable());
    }

    static class UserComparable implements Comparable<Student> {

        @Override
        public int compareTo(Student o) {
            return o.getAge();
        }
    }

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void testElementNewElement() {
        // 底层为数组，初始值为11 超过11自动扩容
        PriorityBlockingQueue<String> queue = exampel.creat();
        for (int i = 0; i < 12; i++) {
            assertThat(queue.add("Hello" + (i + 1)), equalTo(true));
        }
        assertThat(queue.size(), equalTo(12));

        assertThat(queue.element(), equalTo("Hello1"));

    }

    @Test
    public void testTackNewElement() {
        // 底层为数组，初始值为11 超过11自动扩容
        PriorityBlockingQueue<String> queue = exampel.creat();
//        for (int i = 0; i < 12; i++) {
//            assertThat(queue.add("Hello"+(i+1)), equalTo(true));
//        }


        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(() -> {
            queue.add("Hello1");
        }, 2, TimeUnit.SECONDS);
        service.shutdown();
        try {
            assertThat(queue.take(), equalTo("Hello1"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPriority() {
        PriorityBlockingQueue<FIFOEntry> queue = exampel.creat();
        queue.add(new FIFOEntry<String>("fsasdq"));
        queue.add(new FIFOEntry<String>("caa"));
        queue.add(new FIFOEntry<String>("bbbb"));
        queue.add(new FIFOEntry<String>("b"));
        queue.add(new FIFOEntry<String>("aaa"));
        queue.add(new FIFOEntry<String>("sd"));


        System.out.println(queue.remove().entry);
        System.out.println(queue.remove().entry);

    }

}

class FIFOEntry<E extends Comparable<? super E>>
        implements Comparable<FIFOEntry<E>> {
    static final AtomicLong seq = new AtomicLong(0);
    final long seqNum;
    final E entry;

    public FIFOEntry(E entry) {
        seqNum = seq.getAndIncrement();
        this.entry = entry;
    }

    public E getEntry() {
        return entry;
    }

    public int compareTo(FIFOEntry<E> other) {
        int res = entry.compareTo(other.entry);
        if (res == 0 && other.entry != this.entry)
            res = (seqNum < other.seqNum ? -1 : 1);
        return res;
    }
}