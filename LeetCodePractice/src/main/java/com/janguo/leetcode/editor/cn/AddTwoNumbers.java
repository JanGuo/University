//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4552 👎 0


package com.janguo.leetcode.editor.cn;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

        int[] input1;
        input1 = new int[]{2, 4, 3};
        int[] input2;
        input2 = new int[]{5, 6, 4};
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);

        ListNode current1 = head1;
        ListNode current2 = head2;

        for (int i = 0; i < 3; i++) {
            ListNode current11 = new ListNode(input1[i]);
            ListNode current22 = new ListNode(input2[i]);


            current1.next = current11;
            current2.next = current22;

            current1 = current11;
            current2 = current22;


        }

        ListNode listNode = solution.addTwoNumbers(head1.next, head2.next);

        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * *     int val;
     * *     ListNode next;
     * *     ListNode(int x) { val = x; }
     * * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;

            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;

                int sum = x + y + carry;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }

            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int x) {
            val = x;
        }
    }
}