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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*BFS Solution*/
        
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) return levels;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int nodes = queue.size(); 
            while(nodes>0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);    
                }
                if(levels.size() == level){
                    levels.add(new ArrayList<>());
                }
                List<Integer> list = levels.get(levels.size()-1);
                list.add(node.val);
                nodes--;
            }
            level++;
        }
        return levels;
        
        /*DFS Solution*/
        /*
        List<List<Integer>> levels = new ArrayList<>();
        DFS(root, 0, levels);
        return levels;
        */
    }
    
    private void DFS(TreeNode node, int level, List<List<Integer>> levels){
        if(node == null){
            return;
        }
        if(levels.size() == level){
            levels.add(new ArrayList<>());
        }
        List<Integer> list = levels.get(level);
        list.add(node.val);
        DFS(node.left, level + 1, levels);
        DFS(node.right, level + 1, levels);
    }
}
