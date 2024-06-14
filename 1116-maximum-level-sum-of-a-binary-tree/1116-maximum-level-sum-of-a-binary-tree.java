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
    public int maxLevelSum(TreeNode root) {

        if(root == null) return 0;
        int level = 0;
        Queue<TreeNode>q = new ArrayDeque<>();
        q.offer(root);
        int max_val = root.val,ans = 1;;
        while(!q.isEmpty()){
            int len = q.size();
            level++;
            int sum = 0;
            for(int i = 0; i < len ; i++){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(sum > max_val){
                max_val=sum;
                ans = level;
            }
        }
        return ans;        
    }
}