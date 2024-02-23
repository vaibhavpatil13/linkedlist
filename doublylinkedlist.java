import java.util.*;

public class doublylinkedlist{
    public class Node
{
    int data;
    Node next;
    Node prev;

    public Node(int data){
        this.data =data;
        this.next =null;
        this.prev =null;
    }
    
}   
public static Node head;
    public static Node tail;
    public static int size;

public void addfirst(int data){
    Node newnode =  new Node(data);
    size++;
    if(head==null){
        head = tail = newnode;
        return;
    }
    newnode.next =head;
    head.prev = newnode;
    head = newnode;


}
public void addlast(int data){
    Node newnode = new Node(data);
    size++;
    if(head==null){
        head =tail= newnode;
        return ;
    }


    tail.next = newnode;
    newnode.prev = tail;
    tail=newnode;
}

public void removefirst(){
    if(head ==null){
        System.out.println("ll is empty");
    }
    if(head.next==null){
        head = tail = null;
        size--;
    }

    head = head.next;
    head.prev = null;
    size--;
}
public void print(){
    Node temp = head;
    while(temp !=null){
        System.out.print(temp.data+"->");
        temp =temp.next;
    }
    System.out.println("null");
}
public void reverse(){
    Node curr = head;
    Node prev = null;
    Node next ;
    while(curr!=null){
        next = curr.next;
        curr.next = prev ;
        curr.prev = next;
        prev = curr;
        curr = next;
    }

    head = prev;
}


 public static void main(String args[]){
    doublylinkedlist ll = new doublylinkedlist();

    ll.addfirst(4);
    ll.addfirst(1);
    ll.print();
    ll.addlast(5);
    ll.print();
    ll.removefirst();
    ll.print();

    ll.reverse();
    ll.print();

    }
}