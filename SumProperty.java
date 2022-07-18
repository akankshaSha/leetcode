class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        if(root==null || (root.left==null && root.right==null)) return 1;
        if(root.right==null)
        {
            if(root.data==root.left.data) return isSumProperty(root.left);
            return 0;
        }
        if(root.left==null)
        {
            if(root.data==root.right.data) return isSumProperty(root.right);
            return 0;
        }
        if(root.data!=root.right.data+root.left.data) return 0;
        return (isSumProperty(root.left)==1) && (isSumProperty(root.right)==1)?1:0;
    }
}
