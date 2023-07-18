package bublesort;

import java.util.*;

public class BubleSort {

    public static void main(String[] args) {
        //1. Input a positive decimal number
        int size_array = InputPosNum("Enter number of array: ");
        //2. Generate random array
 //         int[] arr= GenArr(size_array);
 //       int[] arr = {5, 1, 12, -5, 16};
        int[] arr = {2,6,3,6,8,6,1,2,9,8};
        //3. Display array before sorting
        DisplayArrUnsorted(arr, "Unsorted array: ");
        //4. Sort array using bubble sort
        BubbleSort(arr);
     //5. Display array after sorting
        DisplayArrSorted(arr,"Sorted array: ");
    }

    public static int InputPosNum(String s) {
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(s);
                size = Integer.parseInt(sc.nextLine());
                //check value of size such that it is a positive decimal num
                if (size > 0 && size <= Integer.MAX_VALUE) {
                    break;
                }
            } catch (NumberFormatException q) {
            }
        } while (true);
        return size;
    }
    public static int[] GenArr(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        //loop use to random each element in array
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(size_array);
        }
        return array;
    }
    public static void DisplayArrUnsorted(int arr[], String s) {
        System.out.print(s + "[");
        // loop use to take position of each element in array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }
    public static void BubbleSort(int[] arr) {
        /*Loop use to take element from the first to last element, 
        after each loop, one element is sorted*/
        for (int i = 0; i < arr.length; i++) {
            // loop use to take each unsorted element
            for (int j = 0; j < arr.length - i- 1 ; j++) {
                // check if the before number is larger next number or not
                if (arr[j] > arr[j + 1]) {
                    // loop use to take position of each element in array
//                    for (int k = 0; k < arr.length; k++) {
//                        System.out.print(arr[k] + " ");
//                    }
//                    System.out.println("   " + arr[j] + ">" + arr[j + 1] + ", swap");
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else if (arr[j] < arr[j + 1]) {
//                    // loop use to take position of each element in array
//                    for (int k = 0; k < arr.length; k++) {
//                        System.out.print(arr[k] + " ");
//                    }
//                    System.out.println("   " + arr[j] + "<" + arr[j + 1] + ", ok");
                }
            }
        }
    }
    public static void DisplayArrSorted(int arr[], String s){
       System.out.print(s + "[");
        // loop use to take position of each element in array
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }
        
    }

