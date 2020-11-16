package medium;

import helpers.ListNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-16
 */
public class ReverseSLL {
    public ListNode reverseBetween(ListNode head, int m, int n){
        int cnt = 1;

        //Empty List return
        if(head == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while(cnt < m && curr != null) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }

        if(cnt<m)
            return head;

        // These will be used to finish recursions.
        ListNode tail = prev;
        ListNode end = curr;

        prev = curr;
        curr = curr.next;

        while(cnt < n && curr!= null) {
            cnt++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(tail == null) {
            head = prev;
        }
        else {
            tail.next = prev;
        }
        end.next = curr;

        return head;
    }

    ListNode createList() {

        ListNode node5 = new ListNode(5);
        ListNode node3 = new ListNode(3, node5);

        return node3;
    }

    public static void main(String[] args) {
        ReverseSLL sll = new ReverseSLL();
        ListNode head = sll.createList();
        printList(head);

        head = sll.reverseBetween(head, 1, 2);
        printList(head);
    }

    private static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
/*
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.
 */
