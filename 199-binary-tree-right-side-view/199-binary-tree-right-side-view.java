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
    Set<Integer> set = new HashSet<>();
    List<Integer> ans = new ArrayList<>();
    public void recur(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(!set.contains(level)){
            ans.add(root.val);
            set.add(level);
        }
        recur(root.right, level+1);
        recur(root.left,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        recur(root, 0);
        return ans;
    }
}