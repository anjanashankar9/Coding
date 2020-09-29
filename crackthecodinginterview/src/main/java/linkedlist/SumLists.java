package linkedlist;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class SumLists {
    private Node getSum(Node head1, Node head2) {
        return addList(head1, head2, 0);
    }

    private Node addList(Node list1, Node list2, int carry) {
        if(list1 == null && list2 == null && carry == 0) {
            return null;
        }
        Node result = new Node();
        int value = carry;
        if(list1 != null) {
            value += list1.data;
        }
        if(list2 != null) {
            value += list2.data;
        }
        result.data = value % 10;

        Node nextResult = addList(list1 == null ? null : list1.next,
                list2 == null ? null : list2.next,
                value >= 10 ? 1: 0);
        result.next = nextResult;
        return result;
    }
}

/*
You have two numbers represented by a linked list,
where each node contains a single digit.The digits are stored in reverse order,
such that the 1 's digit is at the head of the list.
Write a function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input:(7-> 1 -> 6) + (5 -> 9 -> 2).Thatis,617 + 295. Output:2 -> 1 -> 9.Thatis,912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295. Output:9 -> 1 -> 2.Thatis,912.
 */
