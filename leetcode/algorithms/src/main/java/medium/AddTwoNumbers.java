package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-12
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}


public class AddTwoNumbers {
    // This is an iterative solution.
    // For recursive solution refer :
    // ../../../../../../crackthecodinginterview/src/main/java/linkedlist/SumLists.java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        int carry = 0;

        if(l1 == null) {
            return l2;
        }

        if(l2 == null)
            return l1;

        while(l1 != null && l2 != null) {
            int r = l1.val + l2.val + carry;
            carry = r / 10;
            int data = r % 10;
            ListNode node = new ListNode(data);
            if (result == null)
                result = tail = node;
            else {
                tail.next = node;
                tail = tail.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null){
            int r = l1.val + carry;
            carry = r / 10;
            int data = r % 10;
            ListNode node = new ListNode(data);
            tail.next = node;
            tail = tail.next;
            l1 = l1.next;
        }

        while (l2 != null){
            int r = l2.val + carry;
            carry = r / 10;
            int data = r % 10;
            ListNode node = new ListNode(data);
            tail.next = node;
            tail = tail.next;
            l2 = l2.next;
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = tail.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
        ListNode temp = result;

        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */

//https://leetcode.com/problems/add-two-numbers/
