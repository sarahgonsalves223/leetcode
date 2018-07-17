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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        /*I did this by getting entire inorder of the tree and then searching 
        throught that ordered list to get the next node of the given node. 
        This requires O(n) for the traversal of the tree and then O(n) for 
        the traversal of the list again. Also, O(n) space complexity to store
        the order in a list.
        I think we can do better both in space and time. There is no requirement to 
        store all the nodes in the tree since we need to know only the next one of the
        given node. The rest of the order can be ignored. This should reduce the space complexity
        to O(1). Except for the O(h) required for recursion.
        As for the time complexity, if the node is the leftmost node in the tree then we shouldn't
        have to traverse the rest of the tree after it has been hit. Or if the node is in the right 
        subtree of root then we don't even need to traverse the left subtree. All these optimizations
        can be done with better code implementation and algorithm.
	
	Also the fact that the problem is for BST and not only Binary Tree means you can use the property
	of the BST and locate where the successor is supposed to be.
        */
        
        List<TreeNode> order = new ArrayList<>();
        inorder(root, order);
        for(int i=0; i<order.size()-1; i++){
            TreeNode node = order.get(i);
            if(node == p){
                return order.get(i+1);
            }
        }
        return null;
    }
    
    private List<TreeNode> inorder(TreeNode node, List<TreeNode> order){
        if(node == null) return order;
        inorder(node.left, order);
        order.add(node);
        inorder(node.right, order);
        return order;
    }
}
