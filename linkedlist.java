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

    public static boolean iscycle(){   //floyds cycle finding algorithm
        Node slow = head;
        Node fast =head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;  //+1
            fast = fast.next.next;  //+2

            if(slow == fast){      //cycle exists
                return true;
            }
        }

        return false;
    }

    public static void removecycle(){
        //detects a cycle
        Node slow =head;
        Node fast = head;
        boolean cycle = false;

        while(fast!=null && fast.next!=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycle=true;
                break;

            }
        }
        if(cycle==false){
            return;
        }

        //find meet point
        slow = head;
        Node prev = null;

        while(slow!=fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //make last node next null
        prev.next = null;
    }
    public static void main(String args[]){

         head = new Node(1);
         Node temp = new Node(2);
         head.next = temp;
         head.next.next = new Node(3);
         head.next.next.next = temp;

         System.out.println(iscycle());
         removecycle();
         System.out.println(iscycle());




    }
}