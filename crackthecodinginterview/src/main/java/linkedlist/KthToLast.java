package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class KthToLast {
    private Node kthToLast(Node head, int k) {
        Node kPtr = head;
        Node temp = head;
        for(int i=0; i<k; i++) {
            if(kPtr == null) {
                return null;
            }
            kPtr = kPtr.next;
        }

        while(kPtr != null) {
            temp = temp.next;
            kPtr = kPtr.next;
        }
        return temp;
    }
}

/*
Implement an algorithm to find the kth to last element of a singly linked list.
 */
