// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int data;
    Node next;
    
    public Node(int head){
        this.data = head;
        this.next = null;
    }
}

class GFG {
    public static Node a;
    public static Node b;
    
    public static void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    a=null;
		    b=null;
		    int n = sc.nextInt();
		    Node head = new Node(sc.nextInt()), tail = head;
		    while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    obj.alternatingSplitList(head);
		    printList(a);
		    printList(b);
		}
	}
}


// } Driver Code Ends


/*
The structure of node class is:
class Node {
    int data;
    Node next;
    
    public Node(int head){
        this.data = head;
        this.next = null;
    }
}
*/

/*

class GFG {
    public static Node a; //store the head of first list in this
    public static Node b; //store the head of second list in this
}
*/


class Solution {
    public void alternatingSplitList(Node head){
       //Your code here
       Node a=head;
       Node b=head.next;
       Node t=b;
       while(true)
       {
          if(b==null)
          {
              a.next=null;
              break;
          }
           a.next=b.next;
           a=a.next;
           if(a==null)
           {
               b.next=null;
               break;
           }
           b.next=a.next;
           b=b.next;
       }
       GFG.a=head;
       GFG.b=t;
    }
    
}