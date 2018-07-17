/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return height(root, 0) != -1;
    }
    
    private int height(TreeNode node, int height){
        if(height == -1){
            return height;
        }
        if(node == null){
            return height - 1;
        }
        if(node.left == null && node.right == null){
            return height;
        }
        int leftHeight = height(node.left, height + 1);
        int rightHeight = height(node.right, height + 1);
        if(leftHeight == -1 || rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) < 2){
            return Math.max(leftHeight, rightHeight);
        }
        return -1;
    }
}
