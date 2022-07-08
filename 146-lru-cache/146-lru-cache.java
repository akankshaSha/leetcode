class Node
{
    int key;
    Node next;
    Node prev;
    Node(int key)
    {
        this.key=key;
    }
}
class LRUCache {
    
    int capacity;
    HashMap <Integer, Integer> map;
    static HashMap <Integer, Node> posMap;
    static Node head;
    static Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<Integer, Integer>();
        posMap=new HashMap<Integer, Node>();
        head=null;
        tail=null;
    }
    
    static void deletePrevious(int key)
    {
        Node t=posMap.get(key);
        if(t==head)
        {
            head=head.next;
        }
        else if(t==tail)
        {
            tail=tail.prev;
        }
        else
        {
            t.prev.next=t.next;
            t.next.prev=t.prev;
        }
        posMap.remove(key);
    }
    
    static void append(int key)
    {
        Node node=new Node(key);
        if(head==null) head=tail=node;
        else
        {
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        posMap.put(key, node);
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            deletePrevious(key);
            append(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            deletePrevious(key);
            map.remove(key);
        }
        if(map.size()>=capacity)
        {
           int keyToRm=head.key;
           map.remove(keyToRm);
           head=head.next;
        }
        map.put(key, value);
        append(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */