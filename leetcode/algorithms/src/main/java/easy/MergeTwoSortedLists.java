package easy;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-23
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sumHead = null;
        ListNode temp = null;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                ListNode newNode = new ListNode(cur1.val);
                if(sumHead == null) {
                    sumHead = newNode;
                    temp = newNode;
                }
                else {
                    temp.next = newNode;
                    temp = temp.next;
                }
                cur1 = cur1.next;
            }
            else {
                ListNode newNode = new ListNode(cur2.val);
                if(sumHead == null) {
                    sumHead = newNode;
                    temp = newNode;
                }
                else {
                    temp.next = newNode;
                    temp = temp.next;
                }
                cur2 = cur2.next;
            }
        }

        if(cur1 != null) {
            if(sumHead == null) {
                sumHead = cur1;
            }
            else
                temp.next = cur1;
        }

        if (cur2 != null) {
            if(sumHead == null) {
                sumHead = cur2;
            }
            else
                temp.next = cur2;
        }

        return sumHead;
    }

}
/*
Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
 */

//https://leetcode.com/problems/merge-two-sorted-lists/
