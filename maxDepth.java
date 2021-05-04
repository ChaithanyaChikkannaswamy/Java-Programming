/*
* Question: https://leetcode.com/problems/maximum-depth-of-binary-tree/
* Date: May 4th 2021
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
    public int maxDepth(TreeNode root) {
        return maxRecursion(root, 0);
    }
    
    public int maxRecursion(TreeNode node, int depth){
        if(node == null)
            return 0;
        depth++;
        
        if(node.left == null && node.right == null) 
            return depth;
        if(node.left!= null && node.right ==null)
            return maxRecursion(node.left, depth);
        if(node.left == null && node.right!= null)
            return maxRecursion(node.right, depth);
            
        
        return Math.max(maxRecursion(node.left, depth), maxRecursion(node.right, depth));
    
    }
}
