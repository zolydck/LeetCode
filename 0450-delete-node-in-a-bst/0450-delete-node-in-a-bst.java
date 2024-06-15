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


    public int successor(TreeNode root,int key){
        root = root.right;
        while(root.left!=null) root = root.left;
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        if(root.val < key) root.right = deleteNode(root.right,key);
        else if(root.val > key) root.left = deleteNode(root.left,key);
        else{
            if(root.left==null){
                root = root.right;
            }
            else if(root.right==null){
                root = root.left;
            }
            else{
                root.val = successor(root,key);
                root.right = deleteNode(root.right,root.val);
            }
        }
        return root;
    }
}