/*
* Question: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
* Date: MAy 6th 2021
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepthnary(Node root) {
        if(root == null)
            return 0;
        
        if(root.children == null)
            return 1;
        
        int max = 0;
        for(Node child: root.children){
            int height = maxDepthnary(child);
            max = Math.max(height,max);
        }
        
        return max+1;   
            
    }
}
