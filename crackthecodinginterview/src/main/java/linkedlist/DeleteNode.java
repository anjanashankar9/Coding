package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class DeleteNode {
    // When pointer to Head is given
    private Node deleteNode(Node head, Node toDelete) {
        if(head == null) {
            return null;
        }
        if(head.next == null && head != toDelete) {
            return head;
        }

        Node ptr = head;
        Node prev = null;

        while(ptr.next != null) {
            if(ptr.next == toDelete) {
                prev.next = ptr.next;
                return head;
            }
            prev=ptr;
            ptr = ptr.next;
        }
        return head;
    }

    private boolean deleteNodeWithoutHead(Node toDelete) {
        if(toDelete == null || toDelete.next == null) {
            return false;
        }
        Node next = toDelete.next;
        toDelete.data = next.data;
        toDelete.next = next.next;
        return true;
    }
}

/*
Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
EXAMPLE
lnput:the node c from the linked lista->b->c->d->e->f
Result: nothing is returned, but the new linked list looks likea->b->d->e- >f
 */
