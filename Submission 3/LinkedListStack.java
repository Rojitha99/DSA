/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
public class LinkedListStack {
    
    class Node{
        int data;
        Node next;
        
        Node(int data){
            this.data=data;
        }
    }
    
    Node top=null;
    
    //push
    void push(int data){
        Node newNode = new Node(data);
        newNode.next=top;
        top=newNode;
    }
    
    //pop
    int pop(){
        if(top==null)
            throw new RuntimeException("stack is Empty");
        
        int value=top.data;
        top=top.next;
        return value;
    }
    
    //display
    void display(){
        Node temp=top;
        while(temp!=null){
            System.out.println(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();
        System.out.println("Popped: " + stack.pop());
        
        stack.display();
    }
    
}
