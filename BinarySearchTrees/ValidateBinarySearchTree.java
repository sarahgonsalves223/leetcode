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
    public boolean isValidBST(TreeNode root) {
        /*
        Validating using Preoder Traversal and storing the order in a list.
        O(n) for storage. The recursion will also use O(log n) storage in stack 
        but that would be dwarfed by the O(n). Also, O(n) for the time complexity
        as it traverses every node once.
        */
        List<Integer> order = new ArrayList<>();
        preorderTraversal(root, order);
        for(int i=0; i<order.size() - 1; i++){
            if(order.get(i) >= order.get(i+1))
                return false;
        }
        return true;
    } 
    private List<Integer> preorderTraversal(TreeNode root, List<Integer> order){
        if(root == null){
            return order;
        }
        preorderTraversal(root.left, order);
        order.add(root.val);
        preorderTraversal(root.right, order);
        return order;
    }
}
