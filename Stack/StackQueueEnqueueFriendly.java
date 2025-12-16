

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implements a Queue using two Stacks with efficient amortized O(1) complexity.
 */
public class StackQueueEnqueueFriendly{
    
    private Stack<Integer> enStack; // Input Stack (for enqueue)
    private Stack<Integer> deStack; // Output Stack (for dequeue/peek)
    
    public StackQueueEnqueueFriendly(){
        enStack = new Stack<>();
        deStack = new Stack<>();
    }
    
    
    public void enqueue(int x){
        enStack.push(x);
    }
    
    
    private void transferStacks() {
        if (deStack.isEmpty()) {
            while (!enStack.isEmpty()) {
                deStack.push(enStack.pop());
            }
        }
    }
    
    public int dequeue(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        
        transferStacks();
        return deStack.pop();
    }
    
    public int peek(){
        if(empty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        
        transferStacks();
        return deStack.peek();
    }
    
    public boolean empty(){
        return enStack.isEmpty() && deStack.isEmpty();
    }
    
    // --- Display Utility for main method ---
    private String getInternalState() {
        return String.format(
            "| EnStack (Input): %s | DeStack (Output): %s |",
            enStack.toString(), 
            deStack.toString()
        );
    }

    
    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        
        System.out.println("=== Testing Efficient Two-Stack Queue ===\n");
        
        // Initial State
        System.out.println("Is queue empty? " + q.empty()); // true
        
        // 2. Test Enqueue
        System.out.println("\n--- Enqueue 10, 20, 30 ---");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("After Enqueue: " + q.getInternalState()); 
        // EnStack: [10, 20, 30], DeStack: []
        
        
        System.out.println("\n--- Peek ---");
        
        System.out.println("Peeked element: " + q.peek()); // Should be 10
        System.out.println("After Peek: " + q.getInternalState());
        // EnStack: [], DeStack: [30, 20, 10]
        
        // 3. Test Dequeue
        System.out.println("\n--- Dequeue 10, 20 ---");
        
        System.out.println("Dequeued: " + q.dequeue()); // Should be 10
        System.out.println("Dequeued: " + q.dequeue()); // Should be 20
        System.out.println("After Dequeue: " + q.getInternalState());
        // EnStack: [], DeStack: [30]
        
        // 4. Test Mixed Operations
        System.out.println("\n--- Mixed Operations ---");
        q.enqueue(40); 
        q.enqueue(50); 
        System.out.println("After Enqueue 40, 50: " + q.getInternalState()); 
        // EnStack: [40, 50], DeStack: [30]
        
        System.out.println("Peeked element: " + q.peek()); // Should be 30 
        
        System.out.println("Dequeued: " + q.dequeue()); // Should be 30 
        System.out.println("After Dequeue 30: " + q.getInternalState()); 
        // EnStack: [40, 50], DeStack: []
        
        System.out.println("\n--- Final Dequeue ---");
        
        System.out.println("Dequeued: " + q.dequeue()); // Should be 40
        System.out.println("Dequeued: " + q.dequeue()); // Should be 50
        System.out.println("Is queue empty? " + q.empty()); // true
        System.out.println("Final State: " + q.getInternalState());
        
        // 5. Test Error Handling
        System.out.println("\n--- Testing Empty Exception ---");
        try {
            q.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Success! Caught expected exception: " + e.getMessage());
        }
    }
}