package com.janguo.javabasic.concurrent.atomic.atomicrefrence;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    private static AtomicReference<Simple> atomicReference = new AtomicReference<>(new Simple("JanGuo", 22));

    public static void main(String[] args) {

        while (true) {
            Simple simple = atomicReference.get();
            Simple lisi = new Simple("LISI", 55);
            boolean b = atomicReference.compareAndSet(simple, lisi);
            if (b) break;
        }
        System.out.println(atomicReference.get());
    }

    static class Simple {
        private String name;
        private int age;

        public Simple(String name, int age) {
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
            return "Simple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
