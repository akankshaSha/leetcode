class Node
{
    char val;
    boolean end;
    Node[] children;
    Node(char val)
    {
        this.val=val;
        children=new Node[26];
        end=false;
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root=new Node('\u0000');
    }
    
    public void addWord(String word) {
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
            if(node.children[ch-'a']==null) node.children[ch-'a']=new Node(ch);
            nodes.push(node.children[ch-'a']);
            i++;
        }
    }
    
    boolean sear(String word, int index, Node node)
    {
        if(index==word.length()) return node.end;
        char ch=word.charAt(index);
        if(ch!='.')
        {
            if(node.children[ch-'a']==null) return false;
            else return sear(word, index+1, node.children[ch-'a']);
        }
        else
        {
            boolean res=false;
            for(Node child: node.children)
            {
                if(child==null) continue;
                else res=res||sear(word, index+1, child);
            }
            return res;
        }
    }
    public boolean search(String word) {
        return sear(word, 0, this.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */