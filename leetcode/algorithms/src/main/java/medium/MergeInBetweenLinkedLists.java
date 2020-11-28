package medium;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-28
 */
//TODO: Edge cases are not properly checked because Leetcode constraints were not strict.
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0, list1);
        ListNode prev = dummy;
        ListNode curr = list1;

        ListNode l1aPrev = null;
        ListNode l1bnext = null;

        while(curr.next != null && curr.val != a) {
            prev = curr;
            curr = curr.next;
        }

        l1aPrev = prev;

        while(curr.next!=null && curr.val != b) {
            curr =curr.next;
        }

        l1bnext = curr.next;

        l1aPrev.next = list2;
        curr = list2;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = l1bnext;
        return dummy.next;
    }
}

/*
1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
Example 2:


Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.


Constraints:

3 <= list1.length <= 104
1 <= a <= b < list1.length - 1
1 <= list2.length <= 104

 */
