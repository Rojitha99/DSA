
package dsa;

/**
 *
 * @author Rojitha
 */
public class DoublyLinkedList {
    
    class Node{
        int data;
        Node prev,next;
        
        Node(int data){
            this.data=data;
            prev=next=null;
        }
    }
    
    Node head=null;
    
    //Insert at end
    void insert(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        
        Node temp=head;
        while(temp.next !=null)
            temp=temp.next;
        temp.next=newNode;
        newNode.prev=temp;
    }
    
    //display forward
    void display(){
        Node temp=head;
        while(temp !=null){
            System.out.println(temp.data +"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args) {
         DoublyLinkedList list = new DoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
    }
    
}
