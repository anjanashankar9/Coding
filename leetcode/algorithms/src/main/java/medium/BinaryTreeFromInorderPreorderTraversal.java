package medium;

import helpers.TreeNode;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-19
 */
public class BinaryTreeFromInorderPreorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if(pStart > pEnd || iStart > iEnd)
            return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int index = findNodeInorder(inorder, iStart, iEnd, preorder[pStart]);
        if(index == -1)
            return null;
        node.left = buildTree(preorder, pStart+1, pEnd, inorder, iStart, index-1);
        node.right  = buildTree(preorder, pStart+index-iStart+1, pEnd, inorder, index+1, iEnd);

        return node;
    }

    private int findNodeInorder(int[] inorder, int iStart, int iEnd, int val) {
        for(int i=iStart; i <= iEnd; i++) {
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] preorder = {3,9,20,15,7};
//        int[] inorder = {9,3,15,20,7};

        int[] preorder = {1,2};
        int[] inorder = {1,2};

//        int[] preorder = {1,2,3};
//        int[] inorder = {2,3,1};

        TreeNode root = new BinaryTreeFromInorderPreorderTraversal().buildTree(preorder, inorder);
        System.out.println("Done");
    }
}
