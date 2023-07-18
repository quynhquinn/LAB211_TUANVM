
package linearsearch;
import java.util.*;
public class LinearSearch {

    public static void main(String[] args) {
        //1.Input a positive decimal number
         int posNum = InputPositiveNumber("Enter number of array: ");
        //2.Input a search number
         int searchNum= InputSearchNumber("Enter search value: ");
        //3.Generate array by generate random integer in number range
        int [] array = GenArr(posNum);
        //4. Display the array
        DisplayArr(array,"The array: ");
        //5. Find the index of search number in array
        int index= FindIndexSearchNum(array, searchNum);
        //5. Display the index of search number in array
        DisplayIndex(index, "Found "+searchNum+" at index: ");
    }
    public static int InputPositiveNumber( String s){
        int size_array;
        Scanner sc= new Scanner(System.in);
        do{
        try {
            System.out.println(s);
            size_array= Integer.parseInt(sc.nextLine());
            //check value of size array such that it is a positive number
            if (size_array >0 && size_array <=Integer.MAX_VALUE) break;
            throw new NumberFormatException();
        } catch(NumberFormatException e ){  
        }
    }while(true);
        return size_array;
    }
    
    public static int InputSearchNumber (String s) {
        int searchNum;
        Scanner sc= new Scanner(System.in);
        do{
        try {
            System.out.println(s);
            searchNum= Integer.parseInt(sc.nextLine());
             //check value of search number such that it is a positive number
            if (searchNum >=0 && searchNum <=Integer.MAX_VALUE) break;
            throw new NumberFormatException();
        } catch(NumberFormatException e ){  
        }
    }while(true);
        return searchNum;
    }
    
    public static int[] GenArr(int posNum) {
        int [] arr= new int[posNum];
        Random rand= new Random();
        //loop use to generate random value of each element
        for(int i=0;i<posNum; i++){
            arr[i]=rand.nextInt(posNum);
        }
        return arr;
    }
   
    public static void DisplayArr(int array[], String s) {
        System.out.print(s);
        System.out.print("[");
        //Loop use to print elements in array from index 0 to length-1
        for ( int i=0; i<array.length-1; i++){
            System.out.print(array[i]+", ");
        }
        System.out.print(array[array.length-1]+"]");
       }
    public static int FindIndexSearchNum(int[] array,int searchNum){
        //loop to check each element of array
        for ( int i=0;i < array.length; i++){
         // if find the element that same to the search number return the index of the element
        if (array[i]==searchNum) return i;}
               return -1;
    }
  
    public static void DisplayIndex(int index, String s) {
        System.out.println();
        System.out.print(s);
        System.out.println(index);
    }
    
}
