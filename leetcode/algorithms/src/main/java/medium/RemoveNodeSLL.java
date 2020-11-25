package medium;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-25
 */
public class RemoveNodeSLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        Addition of a dummy node helps take care of certain corner cases like
        a list with a single node
        removing the head of the list etc.
         */
        ListNode dummy = new ListNode(0, head);

        ListNode ptr1 = dummy;
        ListNode ptr2 = dummy;

        for(int i=0; i<=n; i++) {
            ptr1 = ptr1.next;
        }

        while (ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);

        ListNode head = new ListNode(1, n1);

        head = new RemoveNodeSLL().removeNthFromEnd(head, 1);
        System.out.println();

    }
}

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Follow up: Could you do this in one pass?



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
