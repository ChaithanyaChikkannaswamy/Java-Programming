
/**
 * @author chaithanyac
 * find the maximum average value of any subtree of a tree. 
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
class Solution{
    double max;
    
    public double maximumAverageSubtree(TreeNode root){
        max = 0.0;
        helper(root);
        return max;
    }
    
    int[] helper(TreeNode node){
        if(node == null)
            return new int[]{0,0};
        
        int sum = node.val;
        int nodes = 1;
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        
        sum += left[0] + right[0];
        nodes += left[1] + right[1];
        
        max = Math.max(max, (sum/nodes));
        return new int[]{sum, nodes};
    }
}
