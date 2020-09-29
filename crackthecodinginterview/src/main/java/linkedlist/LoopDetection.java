package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class LoopDetection {
    private Node loopDetect(Node head) {
        Node temp1 = head;
        Node temp2 = head;

        while(temp2 != null && temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;

            if(temp1 == temp2) {
                //Found the collision point. Break from here.
                break;
            }
        }

        if(temp2 == null || temp2.next == null) {
            //No loop
            return null;
        }

        // Move the slow pointer to head of  linked list.
        temp1 = head;
        while(temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        //They are not at the start of the loop
        return temp1;
    }
    public static void loopDetect(String[] args) {

    }
}

/*
Given a circular linked list, implement an algorithm that returns the node at the
beginning of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in
which a node's next pointer points to an earlier node, so as
to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C[the same C as earlier]
Output: C

 */
