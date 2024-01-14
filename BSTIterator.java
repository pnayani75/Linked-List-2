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
class BSTIterator {
    List<Integer> li;
    int idx;
    public BSTIterator(TreeNode root) {
        this.li = new ArrayList();
        inorder(root);
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        li.add(root.val);
        inorder(root.right);
    }
    public int next() { // o(h) ---> o(logn)
        int re = li.get(idx);
        idx++;
        return re;
    }
    
    public boolean hasNext() { // o(1)
        if(idx<li.size()) return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
