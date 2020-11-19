package medium;

import helpers.TreeNode;

import java.util.*;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-19
 */
public class BinaryTreeZigZagOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> level = new LinkedList<>();
        boolean leftToRight = true;

        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                if(leftToRight) {
                    result.add(emptyQueueAndPrint(level));
                    leftToRight = false;
                }
                else {
                    result.add(emptyStackAndPrint(stack));
                    leftToRight = true;
                }
                if(!queue.isEmpty())
                    queue.add(null);
            }
            else {
                if(leftToRight) {
                    level.add(node.val);
                }
                else {
                    stack.push(node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }

            }
        }
        return result;
    }

    private List<Integer> emptyQueueAndPrint(Queue<Integer> queue) {
        List<Integer> l = new ArrayList<>();
        while(!queue.isEmpty()) {
            l.add(queue.remove());
        }
        return l;
    }

    private List<Integer> emptyStackAndPrint(Stack<Integer> stack) {
        List<Integer> l = new ArrayList<>();
        while(!stack.empty()) {
            l.add(stack.pop());
        }
        return l;
    }
}

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

 */

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/