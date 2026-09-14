// leet 572
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String fullTree = traverse(root);
        String subTree = traverse(subRoot);

        return (fullTree.contains(subTree));
    }

    public String traverse(TreeNode node){
        if(node==null) return "null";

        StringBuilder sb = new StringBuilder("^");
        sb.append(node.val);
        sb.append(traverse(node.left));
        sb.append(traverse(node.right));
        return sb.toString();
    }
}
