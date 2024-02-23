import java.util.*;

public class linkedlist{
    public static class Node{
        int data ;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = next;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data){
        Node newnode = new Node(data);  //create new node
        size++;

        if(head==null){
            head = tail =  newnode;  
            return;         //when there is no element
        }
        newnode.next = head;      //assign nextnode of newnode to head

        head = newnode ;   //make newnode as head


    }
    public void addlast(int data){
        Node newnode =  new  Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }

        tail.next = newnode;
        tail = newnode;
    }
    public void print(){
        Node temp = head;
        if(head==null){
            System.out.print("linkedlist is empty");
            return;
        }

        while(temp!=null){
            System.out.print(temp.data + " ->");
            temp= temp.next;
        }
        System.out.println("null");
    }

    public void add(int ind , int data){
        Node newnode = new Node(data);
        Node temp = head;
        int i=0;

        if(head==null){
            addfirst(data);
            return;
        }
        size++;

        while(i<ind-1){
            temp = temp.next;
            i++;
        }

        newnode.next = temp.next;
        temp.next = newnode;
    }
    public int removefirst(){
        if(size==0){
            System.out.print("list is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val =head.data;
            head = tail = null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next ;
        size--;
        return val;
    }
    public int removelast(){
        if(size == 0){
            System.out.print("list is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val =head.data;
            head = tail = null;
            size=0;
            return val;
        }

        Node prev = head ;
        for(int i=0;i<size -2 ; i++){
            prev = prev.next ; 
        }
        int val = prev.next.data ;  //tail.data
        prev.next = null;
        tail = prev ;
        size--;
        return val;
    }
    public static int helper(Node head , int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int ind = helper(head.next,key);
        if(ind==-1){
            return -1;
        }
        return ind+1;
    }
    public static int recsearch(int key){
        return helper(head , key);
    }
    public static int itrsearch(int key){
        Node temp =head;
        int i=0;

        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head ;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public void deletenthfromend(int n){
        //calsulate size
        int sz=0;
        Node temp =head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head= head.next;  //remove first
            return ;
        }

        int i=1;
        int indfroend = sz - n;
        Node prev =head;

        while(i<indfroend){
            prev = prev.next;
            i++;

        }
        prev.next = prev.next.next ;
        return;
    }
    public static void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;    //to find last node of first half

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;     //mid

        //reverse after mid
        Node curr = mid.next;    //start point of second half
        mid.next = null;      //terminate the first half
        Node prev = null;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr =next;
        }

        //alternate merging
        Node lh = head;
        Node rh = prev;
        Node nextleft , nextright;

        while(lh!=null && rh!=null){
            nextleft = lh.next;
            lh.next = rh;
            nextright =rh.next;
            rh.next = nextleft;
            lh = nextleft;
            rh = nextright;
        }
    }
    public static void main(String args[]){

        linkedlist ll = new linkedlist();
        //ll.print();
        ll.addfirst(1);
       // ll.print();
        ll.addfirst(2);
        ll.addlast(3);
        ll.addlast(4);
        //ll.print();

        ll.add(2 , 7);
        // ll.removefirst();
        // ll.print();
        // ll.removelast();
        // ll.print();

        // System.out.println(size);

        // System.out.println(recsearch(3));
        // System.out.println(itrsearch(3));
        // ll.print();
        // ll.reverse();
        // ll.print();

        // ll.deletenthfromend(3);
        ll.print();
        ll.zigzag();
        ll.print();


    }
}