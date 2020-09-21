package linkedlists;

public class ReverseDLL {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep)  {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode tempPtr = null;
        DoublyLinkedListNode newHead = head;
        while (head!=null) {
            temp = head.next;
            tempPtr = head.prev;
            head.prev = head.next;
            head.next = tempPtr;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void reverseDLL(String[] args) {
        DoublyLinkedList llist = new DoublyLinkedList();

        llist.insertNode(1);
        llist.insertNode(2);
        llist.insertNode(3);
        llist.insertNode(4);
//        llist.insertNode(10);

        DoublyLinkedListNode newHead = reverse(llist.head);
        printDoublyLinkedList(newHead, " ");
    }
}

