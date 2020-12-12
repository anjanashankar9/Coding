package hard;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-11
 */
public class ReverseKGroup {

    private ListNode reverseList(ListNode head, ListNode bPtr, ListNode nPtr) {
        // Since the minimum length of the list to be reversed is > 1, we can
        // skip taking care of the null checks.
        // The function returns the last node of the reversed list.
        ListNode prev = null;
        ListNode curr = head;

        while(curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;
        bPtr.next = curr;
        head.next = nPtr;
        return head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k<2) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);

        ListNode prev = dummy;
        ListNode bPtr = dummy;
        ListNode curr = head;

        int count = 0;
        while(curr != null) {
            count = 0;
            while(curr != null && count != k) {
                prev = curr;
                curr =curr.next;
                count++;
            }

            if (count == k) {
                prev.next = null;
                prev = reverseList(bPtr.next, bPtr, curr);
                bPtr = prev;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode node6 = new ListNode(6);
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4);
//        ListNode node3 = new ListNode(3, node4);
//        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1);

        ListNode newHead = new ReverseKGroup().reverseKGroup(head, 2);

        System.out.println("Done");
    }
}

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

Follow up:

Could you solve the problem in O(1) extra memory space?
You may not alter the values in the list's nodes, only nodes itself may be changed.


Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
Example 3:

Input: head = [1,2,3,4,5], k = 1
Output: [1,2,3,4,5]
Example 4:

Input: head = [1], k = 1
Output: [1]


Constraints:

The number of nodes in the list is in the range sz.
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 */

//https://leetcode.com/problems/reverse-nodes-in-k-group/