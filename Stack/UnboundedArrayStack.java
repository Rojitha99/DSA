/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
import java.util.NoSuchElementException;

public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    
    public UnboundedArrayStack(){
        arr = new int[2];
        top = -1; //stack is empty
    }
    
    public void push(int x){
        if(top == arr.length - 1){
            resize(arr.length * 2); //if the array is full, doble its size
        }
        arr[++top] = x;
    }
    
    public int pop(){
        if(top == -1){
            throw new NoSuchElementException("Stack is empty!");
        }
        
        int value = arr[top--];
        
        if(top > 0 && top == arr.length/4){
            resize(arr.length/2); //half the array size if it is 1/4 full
        }
        return value;
    }
    
    public boolean empty(){
        return top == -1;
    }    
    public int top(){
        if(empty()){
            throw new NoSuchElementException("Stack is empty!");
        }
        return arr[top]; //get the top element
    }
    
    private void resize(int newSize){
        int[] newArr = new int[newSize];
        for(int i = 0; i <= top; i++){
            newArr[i] = arr[i]; //copy the current element in to the new array
        }
        arr = newArr;
    }
    
    public static void main(String[] args) {

    UnboundedArrayStack s = new UnboundedArrayStack();

    System.out.println("=== Testing Unbounded Array Stack ===\n");

    // 1. Test empty stack
    System.out.println("Is Stack Empty? : " + s.empty());
    System.out.println("Initial Top Index : " + s.top);
    System.out.println("Initial Capacity  : " + s.arr.length);

    System.out.println("\n--- Pushing 3, 5, 7 ---");

    // 2. Push elements
    s.push(3);
    System.out.println("Push 3  | Top Index: " + s.top + " | Capacity: " + s.arr.length);

    s.push(5);
    System.out.println("Push 5  | Top Index: " + s.top + " | Capacity: " + s.arr.length);

    // This push will trigger resize (2 → 4)
    s.push(7);
    System.out.println("Push 7  | Top Index: " + s.top + " | Capacity: " + s.arr.length);

    // 3. Peek top element
    System.out.println("\nTop Element: " + s.top());

    System.out.println("\n--- Popping Top Element ---");

    // 4. Pop elements
    System.out.println("Pop     : " + s.pop());
    System.out.println("After Pop | Top Index: " + s.top + " | Capacity: " + s.arr.length);

    System.out.println("----------------------------------");

    // 5. Push again
    s.push(9);
    System.out.println("Push 9  | Top Index: " + s.top + " | Capacity: " + s.arr.length);

    System.out.println("----------------------------------");

    // 6. Pop remaining elements
    System.out.println("Pop     : " + s.pop());
    System.out.println("Pop     : " + s.pop());

    System.out.println("----------------------------------");

    // 7. Final state
    System.out.println("Is Stack Empty? : " + s.empty());

    // 8. Exception handling test
    System.out.println("\n--- Testing Empty Stack Exception ---");
    try {
        s.pop();
    } catch (NoSuchElementException e) {
        System.out.println("Exception Caught Successfully: " + e.getMessage());
    }
}
}