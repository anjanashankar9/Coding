package trees;

import java.util.Scanner;

public class IsBST {
    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Boolean checkBST(Node root, int min_value, int max_value) {
        if (root == null)
            return true;
        if (root.data < min_value || root.data > max_value)
            return false;
        else
            return (checkBST(root.left, min_value, root.data) &&
                    checkBST(root.right, root.data, max_value));
    }

    public static Boolean checkBST(Node root) {
        // Write your code here.
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void checkBST(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(checkBST(root));
    }
}

/*
For the purposes of this challenge, we define a binary search tree to be a binary tree with the following properties:

The  value of every node in a node's left subtree is less than the data value of that node.
The  value of every node in a node's right subtree is greater than the data value of that node.
The  value of every node is distinct.
For example, the image on the left below is a valid BST. The one on the right fails on several counts:
- All of the numbers on the right branch from the root are not larger than the root.
- All of the numbers on the right branch from node 5 are not larger than 5.
- All of the numbers on the left branch from node 5 are not smaller than 5.
- The data value 1 is repeated.



Given the root node of a binary tree, determine if it is a binary search tree.

Function Description

Complete the function checkBST in the editor below. It must return a boolean denoting whether or not the binary tree is a binary search tree.

checkBST has the following parameter(s):

root: a reference to the root node of a tree to test
Input Format

You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints

Output Format

Your function must return a boolean true if the tree is a binary search tree. Otherwise, it must return false.

Sample Input

image

Sample Output

Yes
Explanation

The tree in the diagram satisfies the ordering property for a Binary Search Tree, so we print Yes.
 */
//https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
