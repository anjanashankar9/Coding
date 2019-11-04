package interviewkit.linkedlists;

public class CycleDetectSLL {
    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:*/
    class Node {
        int data;
        Node next;
    }


    boolean hasCycle(Node head) {
        Node ptr1, ptr2;
        ptr1 = head;
        ptr2=head;

        while(ptr1 != null && ptr2 != null && ptr2.next!= null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            if(ptr1 == ptr2)
                return true;
        }
        return false;
    }
}


/*
A linked list is said to contain a cycle if any node is visited more than once while traversing the list. For example, in the following graph there is a cycle formed when node  points back to node .

image

Function Description

Complete the function has_cycle in the editor below. It must return a boolean true if the graph contains a cycle, or false.

has_cycle has the following parameter(s):

: a pointer to a Node object that points to the head of a linked list.
Note: If the list is empty,  will be null.

Input Format

There is no input for this challenge. A random linked list is generated at runtime and passed to your function.

Constraints

Output Format

If the list contains a cycle, your function must return true. If the list does not contain a cycle, it must return false. The binary integer corresponding to the boolean value returned by your function is printed to stdout by our hidden code checker.

Sample Input

The following linked lists are passed as arguments to your function:

image

image

Sample Output

0
1
Explanation

The first list has no cycle, so we return false and the hidden code checker prints  to stdout.
The second list has a cycle, so we return true and the hidden code checker prints  to stdout.
 */

//https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists