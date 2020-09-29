package linkedlist;

import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-28
 */
public class Palindrome {
    boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            stack.push(slowPtr.data);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Skipping the middle element for an odd length list
        if(fastPtr != null) {
            slowPtr = slowPtr.next;
        }

        while(slowPtr != null) {
            int top = stack.pop().intValue();
            if(top != slowPtr.data) {
                return false;
            }
            slowPtr = slowPtr.next;
        }
        return true;
    }
}

/*
Implement a function to check if a linked list is a palindrome.
 */
