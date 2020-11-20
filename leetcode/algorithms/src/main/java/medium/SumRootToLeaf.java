package medium;

import helpers.TreeNode;

import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-20
 */

class NumberTreeNode {
    TreeNode treeNode;
    int number;

    public NumberTreeNode(TreeNode treeNode, int number) {
        this.treeNode = treeNode;
        this.number = number;
    }
}

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        if (root==null)
            return 0;

        Stack<NumberTreeNode> stack = new Stack<>();
        NumberTreeNode nt = new NumberTreeNode(root, root.val);
        stack.push(nt);
        int sum = 0;
        while(!stack.isEmpty()) {
            NumberTreeNode object = stack.pop();

            if(object.treeNode.left == null && object.treeNode.right == null) {
                sum += object.number;
            }
            if(object.treeNode.left != null){
                stack.push(new NumberTreeNode(
                        object.treeNode.left,
                        object.number * 10 + object.treeNode.left.val));
            }
            if(object.treeNode.right != null){
                stack.push(new NumberTreeNode(
                        object.treeNode.right,
                        object.number * 10 + object.treeNode.right.val));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;

        System.out.println(new SumRootToLeaf().sumNumbers(root));

    }
}

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
