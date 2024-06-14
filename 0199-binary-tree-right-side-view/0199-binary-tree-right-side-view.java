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
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        //By comparing it with length of the queue
        List<Integer>ans = new ArrayList<>();

        Deque<TreeNode> q = new ArrayDeque<>();
        if(root == null) return ans;

        q.offer(root);
        while(!q.isEmpty()){
            int level_len = q.size();

            for(int i = 0 ; i < level_len ; i++){
                TreeNode node = q.poll();
                if(i == level_len-1){
                    ans.add(node.val);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
        
    }
}