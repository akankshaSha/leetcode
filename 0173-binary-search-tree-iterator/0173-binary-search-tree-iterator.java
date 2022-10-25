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
    Queue<Integer> inorder;
    
    List<Integer> getInorder(TreeNode node)
    {
        List<Integer> res=new ArrayList<>();
        if(node==null) return res;
        if(node.left!=null) res.addAll(getInorder(node.left));
        res.add(node.val);
        if(node.right!=null) res.addAll(getInorder(node.right));
        return res;
    }

    public BSTIterator(TreeNode root) {
        inorder=new ArrayDeque <Integer>(getInorder(root));
    }
    
    public int next() {
        return inorder.poll();
    }
    
    public boolean hasNext() {
        return ! inorder.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */