package helpers;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-01
 *
 * Definition of doubly linked list.
 */

public class DoublyLinkedListNode {
    public int val;
    public DoublyLinkedListNode prev;
    public DoublyLinkedListNode next;

    public DoublyLinkedListNode() {}

    public DoublyLinkedListNode(int val) { this.val = val; }

    public DoublyLinkedListNode(int val, DoublyLinkedListNode prev) {
        this.val = val;
        this.prev = prev;
    }

    public DoublyLinkedListNode(int val, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}