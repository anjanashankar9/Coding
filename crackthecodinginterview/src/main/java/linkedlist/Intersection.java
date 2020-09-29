package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class Intersection {
    /**
     * Finds the intersection point of the two Singly Linked Lists
     * @param head1
     * @param head2
     * @return the intersecting Node
     */
    private Node intersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return null;
        }
        int l1 = 1;
        int l2 = 1;

        Node temp1 = head1;
        while(temp1.next != null) {
            l1++;
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while(temp2.next != null) {
            l2++;
            temp2 = temp2.next;
        }

        if(temp1 != temp2) {
            System.out.println("The lists do not intersect");
            return null;
        }

        int k = Math.abs(l1-l2);
        temp1 = head1;
        temp2 = head2;
        if(l1 > l2) {
            for(int i=0; i<k; i++) {
                temp1 = temp1.next;
            }
        }

        if(l2 > l1) {
            for(int i=0; i<k; i++) {
                temp2 = temp2.next;
            }
        }

        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}

/*
Given two (singly) linked lists, determine if the two lists intersect.
Return the inter­ secting node.
Note that the intersection is defined based on reference,
not value.That is, if the kth node of the first linked list is
the exact same node (by reference) as the jth node of the second linked list,
then they are intersecting.
 */
