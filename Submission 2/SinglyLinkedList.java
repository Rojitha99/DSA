
package dsa;

/**
 *
 * @author Rojitha
 */
public class SinglyLinkedList {
    
    class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    
    Node head = null;
    
    //Insert at end
    void insert(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp =head;
        while(temp.next !=null)
            temp=temp.next;
        temp.next=newNode;
    }
    
    //dispaly List
    void display(){
        Node temp=head;
        while(temp !=null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
    }
    
}
