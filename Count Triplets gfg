class Solve
{
    static int countTriplets(Node head, int x) 
    { 
        HashMap <Integer, Integer> values=new HashMap<>();
        int count=0, index=0;
        Node t=head;
        while(t!=null)
        {
            values.put(t.data, index++);
            t=t.next;
        }
        
        Node i=head;
        Node j=head.next;
        int m=0,n=1;
        while(i!=null)
        {
            j=i.next;
            n=m+1;
            while(j!=null)
            {
                int target=x-(i.data+j.data);
                if(values.containsKey(target) && values.get(target)>n)
                {
                    count++;
                }
                j=j.next;
                n++;
            }
            i=i.next;
            m++;
        }
        return count;
    } 
}
