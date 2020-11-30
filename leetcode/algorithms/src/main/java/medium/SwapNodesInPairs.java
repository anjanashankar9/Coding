package medium;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-30
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        ListNode next = null;
        ListNode temp = null;
        while (curr != null && curr.next != null) {
            next = curr.next;
            temp = next.next;
            next.next = curr;
            prev.next = next;
            curr.next = temp;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}

/*
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes. Only nodes itself may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
//https://leetcode.com/problems/swap-nodes-in-pairs/
