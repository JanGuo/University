package com.janguo.javabasic.concurrent.collections.diy;

import java.util.Random;

/**
 * 跳表
 */
public class SimpleSkipList {

    private Node head;
    private Node tail;
    private int size;
    private int height;
    private Random random;

    public SimpleSkipList() {
        this.head = new Node(null, HAND_NODE);
        this.tail = new Node(null, TAIL_NODE);
        head.right = tail;
        tail.left = head;
        this.random = new Random(System.currentTimeMillis());
    }

    public void add(Integer element) {
        Node nearNode = this.find(element);
        Node newNode = new Node(element);

        nearNode.right.left = newNode;
        newNode.right = nearNode.right;

        nearNode.right = newNode;
        newNode.left = nearNode;



        int currentLevel = 0;
        while (random.nextDouble() < 0.5d) {

            if (currentLevel >= height) {
                height++;
                Node dumyHead = new Node(null, HAND_NODE);
                Node dumyTail = new Node(null, TAIL_NODE);

                dumyHead.right = dumyTail;
                dumyTail.left = dumyHead;

                dumyHead.down = head;
                dumyTail.down = tail;

                tail.up = dumyTail;
                head.up = dumyHead;

                head = dumyHead;
                tail = dumyTail;

            }

            while ((nearNode != null) && nearNode.up == null) {
                nearNode = nearNode.left;
            }
            nearNode = nearNode.up;

            Node upNode = new Node(element);
            upNode.left = nearNode;
            nearNode.right.left = upNode;
            upNode.right = nearNode.right;
            nearNode.right = upNode;

            upNode.down = newNode;
            newNode.up = upNode;

            newNode = upNode;
            currentLevel++;
        }
        size++;
    }

    public void dumpSkipList() {
        Node currentHead = head;
        for (int i = height+1; i > 0; i--) {

            System.out.printf("Total [%d] ---- Now height [%d]  ", height+1, i);
            Node current = currentHead.right;
            while (current.type == DATA_NODE) {
                System.out.printf("-->%d",current.value);
                current = current.right;
            }
            System.out.printf("\n");
            System.out.println("------------------------------------------ ");

            currentHead = currentHead.down;
        }
    }

    public Node find(Integer element) {
        Node current = head;
        for (; ; ) {
            while (current.right.type != TAIL_NODE && current.right.value <= element) {
                current = current.right;
            }
            if (current.down != null) {
                current = current.down;
            } else {
                break;
            }
        }

        return current; // current Node.value <= element < current.right (if exit)
    }

    public boolean contains(Integer element) {
        Node node = find(element);
        return node.value.equals(element);
    }

    public Integer get(Integer element) {
        Node node = this.find(element);
        return (node.value.equals(element)) ? node.value : null;
    }


    public boolean isEmpty() {
        return (size() == 0);
    }

    public int size() {
        return size;
    }

    /****************  For Node ******************/
    private final static byte HAND_NODE = (byte) -1;
    private final static byte DATA_NODE = (byte) 0;
    private final static byte TAIL_NODE = (byte) 1;

    static class Node {
        private Integer value;
        private Node up, down, left, right;
        private byte type;

        public Node(Integer value, byte type) {
            this.value = value;
            this.type = type;
        }

        public Node(Integer value) {
            this(value, DATA_NODE);
        }
    }

    public static void main(String[] args) {
        SimpleSkipList skipList = new SimpleSkipList();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            skipList.add(random.nextInt(1000));
        }
        skipList.dumpSkipList();
    }
}
