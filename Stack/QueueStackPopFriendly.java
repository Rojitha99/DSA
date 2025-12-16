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

public class QueueStackPopFriendly {

private Queue<Integer> mQueue = new LinkedList<>();
private Queue<Integer> tQueue = new LinkedList<>();
    
    public QueueStackPopFriendly(){
        mQueue = new LinkedList<>();
        tQueue = new LinkedList<>();
    }
    
    public boolean empty(){
        return mQueue.isEmpty(); //check isEmpty
    }
    
    public void push(int y){
        tQueue.add(y);
        
        while(!mQueue.isEmpty()){
            tQueue.add((mQueue.remove())); //moves all element except the last one from maineQueue to tempQueue
        }
        
        Queue<Integer> temp = mQueue;
        mQueue = tQueue; // mainQueue now point to tempQueue
        tQueue = temp; // empty tempQueue for next operation
    }
    
    public int pop(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return mQueue.remove(); // dequeue
    }
    
    public int peek(){
       if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
       return mQueue.peek(); // peek
    }
    public static void main(String[] args) {
        
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        
        System.out.println("=== Testing Queue Stack (Pop Friendly) ===\n");

        // 1. Test Empty State
        System.out.println("Is stack empty? " + s.empty()); // Should be true

        // 2. Test Pushing (LIFO Check)
        System.out.println("\n--- Pushing 10, 20, 30 ---");
        s.push(10);
        s.push(20);
        s.push(30);
        
        
        System.out.println("Internal Queue State: " + s.mQueue); 
        System.out.println("Peek (Top element): " + s.peek()); // Should be 30

        // 3. Test Popping
        System.out.println("\n--- Popping Top Element ---");
        System.out.println("Popped: " + s.pop()); // Should remove 30
        System.out.println("Internal Queue State: " + s.mQueue); // Should be [20, 10]

        // 4. Test Mixed Operations
        System.out.println("\n--- Pushing 40, Popping immediately ---");
        s.push(40);
        System.out.println("Peek after push: " + s.peek()); // Should be 40
        System.out.println("Popped: " + s.pop()); // Should remove 40
        System.out.println("Internal Queue State: " + s.mQueue); // Back to [20, 10]

        // 5. Emptying the Stack
        System.out.println("\n--- Emptying Stack ---");
        while(!s.empty()) {
            System.out.println("Popped: " + s.pop());
        }
        System.out.println("Is stack empty? " + s.empty());

        // 6. Test Error Handling
        System.out.println("\n--- Testing Empty Pop Exception ---");
        try {
            s.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Success! Caught expected exception: " + e.getMessage());
        }
    }
    
}