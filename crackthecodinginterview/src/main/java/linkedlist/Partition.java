package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class Partition {
    private Node partition(Node head, int x) {
        Node beforeStart = null;
        Node beforeEnd = null;

        Node afterStart = null;
        Node afterEnd = null;

        Node temp = head;
        while(temp != null) {
            if(temp.data < x) {
                if(beforeStart == null) {
                    beforeStart = beforeEnd = temp;
                }
                else {
                    beforeEnd.next = temp;
                    beforeEnd = temp;
                }
            }
            else {
                if(afterStart == null) {
                    afterStart = afterEnd = temp;
                }
                else {
                    afterEnd.next = temp;
                    afterEnd = temp;
                }
            }
            temp = temp.next;
        }
        if(beforeEnd == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }
}

/*
Write code to partition a linked list around a value x,
such that all nodes less than x come before all nodes greater than or
equal to x. If x is contained within the list, the values of x only need to
be after the elements less than x (see below).
The partition element x can appear anywhere in the "right partition";
it does not need to appear between the left and right partitions.
EXAMPLE
Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
