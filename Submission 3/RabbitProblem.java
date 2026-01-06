/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;

/**
 *
 * @author Rojitha
 */
public class RabbitProblem {

    static int rabbits(int n){
        int a=0,b=1;
        
        for(int i=2;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
    public static void main(String[] args) {
        int months=6;
        System.out.println("Rabbit pairs after "+ months +" months: "+rabbits(months));
        
    }
    
}
