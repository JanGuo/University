package com.janguo.javabasic.concurrent.collections.diy;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityLinkList<E extends Comparable<E>> {
    private PriorityLinkList.Node<E> first;

    private final PriorityLinkList.Node<E> NULL = (PriorityLinkList.Node<E>) null;

    private int size;

    public PriorityLinkList() {
        // this.first = NULL;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    @SafeVarargs
    public static <E extends Comparable<E>> PriorityLinkList<E> of(E... elements) {
        PriorityLinkList<E> list = new PriorityLinkList<>();
        if (elements.length > 0) {
            for (E element : elements) {
                PriorityLinkList<E> linkList = list.addFistNode(element);
            }
        }
        return list;
    }

    public PriorityLinkList<E> addFistNode(E e) {
        PriorityLinkList.Node<E> newNode = new PriorityLinkList.Node<>(e);
        // 保存的是需要插入位置的前一个
        PriorityLinkList.Node<E> previous = NULL;
        // 移动当前位置的指针
        PriorityLinkList.Node<E> current = first;
        while (current != null && e.compareTo(current.value) > 0) {
            previous = current;
            current = current.next;
        }
        if (previous == NULL) {
            first = newNode;
        } else {
            previous.next = newNode;
        }
        newNode.next = current;
        size++;
        return this;
    }


    public boolean contains(E e) {
        PriorityLinkList.Node<E> current = first;
        while (current != null) {
            if (current.value == e) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public E removeFistNode() {
        PriorityLinkList.Node<E> current = first;
        if (this.isEmpty()) {
            throw new NoSuchElementException("Can't remove it isEmpty");
        } else {
            first = current.next;
            size--;
            return current.value;
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        } else {
            StringBuilder builder = new StringBuilder("[");
            PriorityLinkList.Node<E> current = first;
            while (null != current) {
                builder.append(current.toString()).append(",");
                current = current.next;
            }
            builder.replace(builder.length() - 1, builder.length(), "]");
            return builder.toString();
        }
    }

    static class Node<E> {
        E value;
        PriorityLinkList.Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (value != null) {
                return value.toString();
            } else {
                return "null";
            }
        }
    }

    public static void main(String[] args) {
        Student student2 = new Student("A", 14);
        Student student1 = new Student("B", 20);
        Student student = new Student("C", 8);
//        PriorityLinkList<Integer> linkList = PriorityLinkList.of(10, 1, -10, -22, 0, 88, 100, 92);
        PriorityLinkList<Student> linkList = PriorityLinkList.of(student, student1, student2);
        System.out.println(linkList);
    }

    static class Student implements Comparable<Student> {
        private final String name;
        private final int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Student o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
