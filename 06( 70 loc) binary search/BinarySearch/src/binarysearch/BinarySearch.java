package binarysearch;

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        //1. Input number of array
        int size_array = InputPosNum("Enter number of array: ");
        //2. Input a search num
        int search_num = InputSearchNum("Enter search value: ");
        //3. Genarate array
//        int[] arr = GenArr(size_array);
              int[] arr = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};
        //4. Sort array
        SortArr(arr);
        //5.Binary search
        int index = BinarySearch(search_num, arr, 0, size_array - 1, 1);
        //6. Display index
        display(index, "Found " + search_num + " at index: ");
    }

    public static int InputPosNum(String s) {
        int posnum;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(s);
                posnum = Integer.parseInt(sc.nextLine());
                if (posnum > 0 && posnum <= Integer.MAX_VALUE) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return posnum;
    }

    public static int InputSearchNum(String s) {
        Scanner sc = new Scanner(System.in);
        int searchnum;
        do {
            try {
                System.out.println(s);
                searchnum = Integer.parseInt(sc.nextLine());
                if (searchnum >= 0 && searchnum < Integer.MAX_VALUE) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return searchnum;
    }

    public static int[] GenArr(int n) {
        int a[] = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(n);
        }
        return a;
    }

    public static void SortArr(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("Sorted array: [");
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println(a[a.length - 1] + "]");
    }

    public static int BinarySearch(int searchvalue, int a[], int l, int r, int count) {

        //check if first position in subarray is less than last position 
        if (l<=r) {
            int mid = (l + r) / 2;
            //check if search value is equal to middle element
            if (searchvalue == a[mid]) {
                return mid;
                //if search value if greater than middle element
            } else if (searchvalue > a[mid]) {
                return BinarySearch(searchvalue, a, mid + 1, r, count + 1);
            } else 
                return BinarySearch(searchvalue, a, l, mid - 1, count + 1);
            }
        
        return -1;
    }

    public static void display(int index, String s) {

        if (index >= 0) {
            System.out.println(s + index);
        } else {
            System.out.println("NOT FOUND!");
        }
    }
}
