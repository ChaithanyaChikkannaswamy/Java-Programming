/*
* Question: https://leetcode.com/problems/balanced-binary-tree/submissions/
* Date : May 4th 2021
*
*/

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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        helperbbt(root);
        return result;
    }
    
    public int helperbbt(TreeNode root){
        if(root == null)
            return 0;
        
        int left = helperbbt(root.left);
        int right = helperbbt(root.right);
        
        if(Math.abs(left - right)>1 || left == -1 || right == -1)
            result = false;
        
        return Math.max(left,right)+1;
    }
}
