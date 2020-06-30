package com.janguo.javabasic.concurrent.collectionsqueue.diy;


import java.util.NoSuchElementException;

public class LinkList<E> {

    private Node<E> first;

    private final Node<E> NULL = (Node<E>) null;

    private int size;

    public LinkList() {
        this.first = NULL;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public static <E> LinkList<E> of(E... elements) {
        LinkList<E> list = new LinkList<>();
        if (elements.length > 0) {
            for (E element : elements) {
                list.addFistNode(element);
            }
        }
        return list;
    }

    public LinkList<E> addFistNode(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = first; // 将first 向后移
        this.size++;
        this.first = newNode; // 新的节点变为First
        return this;
    }


    public boolean contains(E e) {
        Node<E> current = first;
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
        Node<E> current = first;
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
            Node<E> current = first;
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
        Node<E> next;

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
        LinkList<String> linkList = LinkList.of("Hello", "World", "Scala", "Java", "Thread", "LinkedList");

        System.out.println("LinkList is or not empty - " + linkList.isEmpty());
        System.out.println("LinkList Size is - " + linkList.getSize());

        System.out.println(linkList);
        System.out.println("Remove is or not LinkedList - " + linkList.removeFistNode());
        System.out.println(linkList);

    }
}
