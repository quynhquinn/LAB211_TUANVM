 
package fibo;
import java.util.*;
public class Fibo {
    public static void main(String[] args) {
       //tìm 45 số fibo bằng đệ quy
        List<Integer> fibo = fiboArr(45);
   
       // in 45 số
       display(fibo);
    }
  
    public static List<Integer> fiboArr(int n) {
           List<Integer> f = new ArrayList<>();
           f.add(0);
           f.add(1);
           for (int i=2; i<n; i++){
               f.add(f.get(i-1) + f.get(i-2));
           }
             return f;

    }
     public static void display(List<Integer> fibo) {
       fibo.toArray();
       for (int i=0; i<fibo.size(); i++) {
           System.out.print(fibo.get(i)+", ");
       }
   //    System.out.println(fibo(fibo.size()-1));
//        //check
//        System.out.println("so fibo thu 0 la 0");
//        for (int i=1; i<45; i++){
//            System.out.println("So fibo thu "+i+": "+Findfibo(i,0,1));
//        }
   }
   
  
   
 
    
}
