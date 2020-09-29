package linkedlist;

import java.util.HashSet;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class RemoveDups {
    private Node removeDups(Node head) {
        // O(N) time O(N) space
        HashSet<Integer> numbers = new HashSet<>();

        Node prev = null;
        Node curr = head;

        while(curr != null) {
            if(numbers.contains(curr.data)) {
                prev.next = curr.next;
            }
            else {
                prev = curr;
                numbers.add(curr.data);
            }
            curr = curr.next;
        }
        return head;
    }


    private Node removeDupsWithoutExtraSpace(Node head) {
        //O(N2) time and O(1) space

        Node curr = head;

        while(curr != null) {
            //Look in the remaining list and delete all nodes with same value
            Node temp = curr;
            while(temp.next != null) {
                if(temp.next.data == curr.data) {
                    temp.next = temp.next.next;
                }
                else{
                    temp = temp.next;
                }
            }

            curr = curr.next;
        }
        return head;
    }

    public static void removeDups(String[] args) {

    }
}

/*
Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
