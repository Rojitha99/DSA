/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class QueueStackPushFriendly {

    private Queue<Integer> mQueue = new LinkedList<>();
    private Queue<Integer> tQueue = new LinkedList<>();
    
    public QueueStackPushFriendly(){
        mQueue = new LinkedList<>();
        tQueue = new LinkedList<>();
    }
    
    public void push(int y){
        mQueue.add(y); // enqueue
    }
    
    public boolean empty(){
        return mQueue.isEmpty(); //check isEmpty
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(mQueue.size()>1){
            tQueue.add(mQueue.remove()); //moves all element except the last one from maineQueue to tempQueue
        }
        
        int popped = mQueue.remove(); // dequeue
        
        Queue<Integer> temp = mQueue;
        mQueue = tQueue; // mainQueue now point to tempQueue
        tQueue = temp; // empty tempQueue for next operation
        
        return popped;
    }
    
    public int peek(){
         if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        while(mQueue.size()>1){
            tQueue.add(mQueue.remove()); //moves all element except the last one from maineQueue to tempQueue
        }
        
        int top = mQueue.peek(); // peek
        tQueue.add(mQueue.remove()); // put element back
        
        Queue<Integer> temp = mQueue;
        mQueue = tQueue; // mainQueue now point to tempQueue
        tQueue = temp; // empty tempQueue for next operation
        
        return top;
    }
    
    
    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        
        System.out.println("=== Testing Queue Stack (Push Friendly) ===\n");
        
        // 1. Test Empty State
        System.out.println("Is stack empty? " + s.empty());

        // 2. Test Pushing 
        System.out.println("\n--- Pushing 10, 20, 30 ---");
        s.push(10);
        s.push(20);
        s.push(30);
        
        
        System.out.println("Internal Queue State: " + s.mQueue); 
        
        
        System.out.println("Peek (Top element): " + s.peek()); // Should be 30

        // 3. Test Popping 
        System.out.println("\n--- Popping Top Element ---");
        System.out.println("Popped: " + s.pop()); // Should remove 30
        System.out.println("Internal Queue State: " + s.mQueue); // Should be [10, 20]

        // 4. Test Mixed Operations
        System.out.println("\n--- Pushing 40, then Peeking ---");
        s.push(40);
        System.out.println("Internal Queue State: " + s.mQueue); // [10, 20, 40]
        System.out.println("Peek: " + s.peek()); // Should be 40
        
        System.out.println("\n--- Popping Everything ---");
        while(!s.empty()){
            System.out.println("Popped: " + s.pop());
        }
        System.out.println("Is stack empty? " + s.empty());
        
        // 5. Test Error Handling
        System.out.println("\n--- Testing Empty Pop Exception ---");
        try {
            s.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Success! Caught expected exception: " + e.getMessage());
        }
    }
    
}