
package dsa;

/**
 *
 * @author Rojitha
 */
import java.util.LinkedList;
import java.util.Queue;

public class StackQueueDequeuefriendly {
    Queue<Integer> q1 =new LinkedList<>();
    Queue<Integer> q2 =new LinkedList<>();
    
    //push operation
    public void  push(int x){
        q1.add(x);
    }
    
    //pop operation (dequeue friendly)
    public int pop(){
        if(q1.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        
        //move element except last
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        
        int popped=q1.remove();
        
        //swap queues
        Queue<Integer>temp =q1;
        q1=q2;
        q2=temp;
        
        return popped;
    }



    
    public static void main(String[] args) {
       StackQueueDequeuefriendly s = new StackQueueDequeuefriendly();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop()); // 30
    }
    
}
