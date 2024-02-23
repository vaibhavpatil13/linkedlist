import java.util.*;

public class mergesort{
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
    public static void main(String args[]){
        mergesort ll = new mergesort();
        ll.addFirst(1);
        System.out.println(ll);

    }
    public static Node getmid(Node head){
        Node slow=head;
        Node fast =head.next;

        while(fast !=null&&fast.next!=null){
            slow =slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
    public static Node mergesortalg(Node head){
        if(head ==null || head.next ==null){
            return head;
                    }
        //mid 
        Node mid = getmid(head);

        Node rightHead = mid.next;
        mid.next = null;
        
        //mergesort for right left

        Node leftsort = mergesortalg(head);
        Node rightsort = mergesortalg(rightHead);

        return merge(leftsort , rightsort);
    }
    public static Node merge(Node head1 , Node head2){
        Node mergerlink = new Node(-1);
        Node temp = mergerlink;

        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp=temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp=temp.next;
            }

        }

        while(head1!=null){
            temp.next =head1;
            head1 =head1.next;
            temp =temp.next;
        }
        while(head2!=null){
            temp.next =head2;
            head2 = head2.next;
            temp =temp.next;
        }
        return mergerlink.next ;
    }
}