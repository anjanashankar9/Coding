package easy;

import helpers.ListNode;

public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // find length of two linked lists
        // Move the longer list by that many.
        // Then start going through

        int cntA = 0;
        ListNode tmpA = headA;
        while (tmpA != null) {
            tmpA = tmpA.next;
            cntA++;
        }

        int cntB = 0;
        ListNode tmpB = headB;
        while (tmpB != null) {
            tmpB = tmpB.next;
            cntB++;
        }

        tmpA = headA;
        tmpB = headB;
        while (cntA > cntB) {
            tmpA = tmpA.next;
            cntA--;
        }
        while (cntB > cntA) {
            tmpB = tmpB.next;
            cntB--;
        }

        while (tmpA != tmpB) {
            tmpA = tmpA.next;
            tmpB = tmpB.next;
        }
        return tmpA;
    }
}
