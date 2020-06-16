package com.janguo.leetcode;

import java.util.Stack;

public class Solution03 {

    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(0);
        ListNode dummy1 = new ListNode(2);
        dummyHead.next = dummy1;
        ListNode dummy2 = new ListNode(4);
        dummy1.next = dummy2;
        ListNode dummy3 = new ListNode(3);
        dummy2.next = dummy3;
        dummy3.next = null;

        ListNode dummy2Head = new ListNode(0);
        ListNode dummy21 = new ListNode(5);
        dummy2Head.next = dummy21;
        ListNode dummy22 = new ListNode(6);
        dummy21.next = dummy22;
        ListNode dummy23 = new ListNode(4);
        dummy22.next = dummy23;
        dummy23.next = null;

        ListNode listNode = new Solution03().addTwoNumbers(dummyHead, dummy2Head);
        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack = new Stack<>();
        ListNode dummyHead = new ListNode(0);
        while (l1.next != null && l2.next != null) {
            stack.push(l1.next.val + l2.next.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode prot = new ListNode(0);
        prot = dummyHead;
        while (!stack.empty()){
            prot.next = new ListNode(stack.pop());
            prot = prot.next;
        }
        return dummyHead;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}