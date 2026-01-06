/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
public class LinkedListFIFOQueue {

    class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
        }
    }
    
    Node front=null,rear=null;
    
    //Enqueue
    void enqueue(int data){
        Node newNode=new Node(data);
        
        if(rear==null){
            front=rear=newNode;
            return;
        }
    }
    
    //Dequeue
    int dequeue(){
        if(front==null)
            throw new RuntimeException("Queue is Empty");
        
        int value=front.data;
        front=front.next;
        
        if(front==null)
            rear=null;
        
        return value;
    }
    
    //display
    void display(){
        Node temp=front;
        while(temp!=null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        
        q.display();
        
    }
    
}
