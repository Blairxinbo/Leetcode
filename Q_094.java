/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Q_094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root,res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                traversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                traversal(root.right, res);
            }
        }
    }
}