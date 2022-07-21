/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue <TreeNode> nodes=new LinkedList<>();
        List<String> serial=new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty())
        {
            TreeNode node=nodes.remove();
            if(node==null) serial.add("null");
            else serial.add(Integer.toString(node.val));
            if(node!=null)nodes.add(node.left);
            if(node!=null)nodes.add(node.right);
        }
        for(int i=serial.size()-1; i>=0; i--)
        {
            if(serial.get(i)!="null") break;
            else serial.remove(i);
        }
        return serial.toString();
    }
    
    TreeNode makeNode(String val)
    {
        TreeNode node;
        if(val.equals("null")) node=null;
        else node= new TreeNode(Integer.parseInt(val)); 
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.print(data);
        data=data.substring(1, data.length()-1);
        if(data.length()==0) return null;
        String values[]=data.split(",");
        TreeNode nodes[]=new TreeNode[values.length];
        for(int i=0; i<values.length; i++)
            nodes[i]=makeNode(values[i].trim());
        
        int i=0, j=1, k=2;
        for(; i<nodes.length; i++)
        {
            if(nodes[i]==null) continue;
            
            if(j>=nodes.length) nodes[i].left=null;
            else nodes[i].left=nodes[j];
            if(k>=nodes.length) nodes[i].right=null;
            else nodes[i].right=nodes[k];
            j+=2;
            k+=2;
        }
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));