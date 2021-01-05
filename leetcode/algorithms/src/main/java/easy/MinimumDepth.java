package easy;

import helpers.TreeNode;

import java.util.Stack;

/**
 * @Author Anjana Shankar
 * @Created 2021-01-05
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * */

class StackNode {
    TreeNode node;
    int depth;

    StackNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
public class MinimumDepth {
    public int minDepth(TreeNode root) {
        Stack<StackNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        if (root == null)
            return 0;

        StackNode s = new StackNode(root, 1);
        stack.push(s);
        while (!stack.empty()) {
            StackNode stNode = stack.pop();
            TreeNode n = stNode.node;
            int depth = stNode.depth;
            if(n.left == null && n.right == null) {
                min = min<depth ? min : depth;
            }
            if (n.left != null){
                stack.push(new StackNode(n.left, depth+1));
            }
            if (n.right != null){
                stack.push(new StackNode(n.right, depth+1));
            }
        }
        return min;
    }
}

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5


Constraints:

The number of nodes in the tree is in the range [0, 105].
-1000 <= Node.val <= 1000
 */

//https://leetcode.com/problems/minimum-depth-of-binary-tree/
