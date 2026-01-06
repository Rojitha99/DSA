/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
public class CircularDoublyLinkedList {

    class Node{
        int data;
        Node next,prev;
        
        Node(int data){
            this.data=data;
        }
    }
    
    Node head=null;
    
    //Insert at end
    void insert(int data){
        Node newNode = new Node(data);
        
        if(head==null){
            head=newNode;
            head.next=head;
            head.prev=head;
            return;
        }
        Node tail=head.prev;
        
        tail.next=newNode;
        newNode.prev=tail;
        newNode.next=head;
        head.prev=newNode;
    }
    
    //display list
    void display(){
        if(head==null)return;
        
        Node temp=head;
        do{
            System.out.println(temp.data +"<->");
            temp=temp.next;
        }while(temp!=head);
        System.out.println("(back to back)");
    }
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);

        list.display();
    }
    
}
