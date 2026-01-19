
package dsa;

/**
 *
 * @author Rojitha
 */
public class OptimizedInsertionSort {

    static void insertionSort(int[] arr){
        int n=arr.length;
        
        for(int i=1;i<n;i++){
            int key=arr[i];
            int j=i-1;
            
            while(j>=0&&arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    static void printArray(int[] arr){
        for(int x:arr)
            System.out.print(x + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr={5,3,8,4,2};
        insertionSort(arr);
        printArray(arr);
    }
    
}
