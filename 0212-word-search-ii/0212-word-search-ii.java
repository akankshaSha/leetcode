class Node {
    char c;
    Node children[];
    boolean end;
    Node(char c)
    {
        this.c = c;
        children = new Node[26];
        end = false;
    }
}

class Solution {
    
    void dfs(char board[][], boolean[][] visited, int x, int y, Node node, HashSet<Node> res)
    {
        if(node.end) res.add(node);
        int dx[]={0, 0, 1, -1}, dy[]={-1, 1, 0, 0};
        visited[x][y]=true;
        for(int i=0; i<4; i++)
        {
            int m = x + dx[i], n = y + dy[i];
            boolean inBounds = -1<m && m<board.length && -1<n && n<board[m].length;
            if(inBounds && !visited[m][n] && node.children[board[m][n] - 'a'] != null)
            {
                dfs(board, visited, m, n, node.children[board[m][n] - 'a'], res);
            }
        }
        visited[x][y] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        //1. make trie, map end nodes with Strings
        HashMap<Node, String> nodeString = new HashMap<>();
        Node root = new Node('\0');
        for(String word : words)
        {
            Node node=root;
            for(int i=0; i<word.length(); i++)
            {
                char c = word.charAt(i);
                if(node.children[c - 'a'] == null) node.children[c - 'a'] = new Node (c);
                node = node.children[c - 'a'];
            }
            node.end = true;
            nodeString.put(node, word);
        }
        
        //2. make visited board
        boolean visited[][] = new boolean[board.length][board[0].length];
        
        HashSet<Node> res = new HashSet<>();
        //3. greedy dfs board
        
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
            {
                Node node = root;
                if(node.children[board[i][j] - 'a'] != null)
                    dfs(board, visited, i, j, node.children[board[i][j] - 'a'], res);
            }
        }
        
        //4. result
        List<String> ans = new ArrayList<>();
        for(Node node : res) ans.add(nodeString.get(node));
        return ans;
    }
}

// approach 1: store words in a set
/*
class Solution {
    void dfs(char board[][], boolean visited[][], int x, int y, String pick, HashSet<String> dictionary, List<String> res)
    {
        if(dictionary.contains(pick)) {
            res.add(pick);
        }
        int dx[]={0, 0, 1, -1}, dy[]={-1, 1, 0, 0};
        visited[x][y]=true;
        for(int i=0; i<4; i++)
        {
            int m = x + dx[i], n = y + dy[i];
            boolean inBounds = -1<m && m<board.length && -1<n && n<board[m].length;
            if(inBounds && !visited[m][n])
                dfs(board, visited, m, n, pick+board[m][n], dictionary, res);
        }
        visited[x][y] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> dictionary=new HashSet<>();
        for(String word : words) dictionary.add(word);
        List<String> res=new ArrayList<>();
        boolean visited[][]=new boolean[board.length][board[0].length];
        
        //1. dfs and match
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[i].length; j++)
                dfs(board, visited, i, j, Character.toString(board[i][j]), dictionary, res);
        }        
        
        return res;
    }
}
*/