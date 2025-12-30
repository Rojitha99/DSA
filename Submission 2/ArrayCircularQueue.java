
package dsa;

/**
 *
 * @author Rojitha
 */
public class ArrayCircularQueue {
    int[] queue;
    int front = -1,rear = -1,size;
    
    ArrayCircularQueue(int size){
        this.size=size;
        queue=new int[size];
    }
    
    void enqueue(int data){
        if((rear + 1)%size==front){
            System.out.println("Queue is Full");
            return;
        }
        if(front==-1)front=0;
        rear=(rear+1)%size;
        queue[rear]=data;
    }
    //dequeue
    int dequeue(){
        if(front == -1){
            throw new RuntimeException("Queue is Empty");
        }
        int value = queue[front];
        if(front==rear){
            front=rear=-1;
        }else{
            front=(front + 1)%size;
        }
        return value;
    }
    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
    }
    
}
