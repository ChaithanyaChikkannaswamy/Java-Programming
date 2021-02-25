/*
* Date: February 24th 2021
* Question: https://leetcode.com/problems/score-of-parentheses/
*/

class Solution {
    public int scoreOfParentheses(String S) {
        TreeNode root = computeTreeNode(S);
        return root.computeScore();
    }
    
    private TreeNode computeTreeNode(String S) {
        TreeNode current = new TreeNode();
        TreeNode root = current;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                TreeNode child = new TreeNode();
                child.setParent(current);
                current.addChild(child);
                current = child;
            } else {
                current = current.getParent();
            }
        }
        return root;
    }
    
    class TreeNode {
        private List<TreeNode> children;
        private TreeNode parent;
        
        public TreeNode() {
            children = new ArrayList<>();
        }
        
        public void addChild(TreeNode n) {
            children.add(n);
        }
        
        public void setParent(TreeNode p) {
            parent = p;
        }
        
        public TreeNode getParent() {
            return parent;
        }
        
        public int computeScore() {
            if (children.isEmpty()) {
                return 1;
            }
            int res = 0;
            for (TreeNode c : children) {
                res += c.computeScore();
            }
            if (parent == null) {
                // root case
                return res;
            }
            return 2*res;
        }
    }
}
