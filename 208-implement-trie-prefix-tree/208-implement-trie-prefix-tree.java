class Node
{
    char val;
    boolean end;
    HashMap<Character, Node> children;
    Node(char val)
    {
        this.val=val;
        children=new HashMap<>();
        end=false;
    }
    
    public String toString()
    {
        if(this.end) return "*val:"+val+" children:"+children+"*";
        return "val:"+val+" children:"+children;
    }
}

class Trie {
    Node root;
    
    public Trie() {
        root=new Node('\u0000');
    }
    
    public void insert(String word) {
        int i=0;
        Stack<Node> nodes=new Stack<>();
        nodes.push(root);
        while(!nodes.empty())
        {
            Node node=nodes.pop();
            if(i==word.length())
            {
                node.end=true;
                break;
            }
            char ch=word.charAt(i);
            if(node.children.containsKey(ch))
                nodes.push(node.children.get(ch));
            else
            {
                Node child=new Node(ch);
                node.children.put(ch, child);
                nodes.push(child);
            }
            i++;
        }
    }
    
    public boolean search(String word) {
        int i=0;
        Stack<Node> nodes=new Stack<>();
        nodes.push(root);
        while(!nodes.empty())
        {
            Node node=nodes.pop();
            if(i==word.length()) return node.end;
            char ch=word.charAt(i);
            if(node.children.containsKey(ch))
                nodes.push(node.children.get(ch));
            else return false;
            i++;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        int i=0;
        Stack<Node> nodes=new Stack<>();
        nodes.push(root);
        while(!nodes.empty())
        {
            Node node=nodes.pop();
            if(i==prefix.length()) break;
            char ch=prefix.charAt(i);
            if(node.children.containsKey(ch))
                nodes.push(node.children.get(ch));
            else return false;
            i++;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */