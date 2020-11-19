package medium;

import helpers.TreeNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-19
 */
public class isValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long minValue, long maxValue) {
        if(node == null)
            return true;
        if(node.val <= minValue || node.val >= maxValue)
            return false;
        return isValidBST(node.left, minValue, node.val) &&
                isValidBST(node.right, node.val, maxValue);
    }
}
