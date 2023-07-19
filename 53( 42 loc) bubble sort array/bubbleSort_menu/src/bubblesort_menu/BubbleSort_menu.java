package bubblesort_menu;

import java.util.Scanner;

public class BubbleSort_menu {

    public static void main(String[] args) {
        int[] ArrInput= new int[0];
        int choice;
        do {
            //1. Display a menu
            DisplayMenu();
            //2. Get user choice
            choice = GetChoice(1, 4);
            //3. Do option based on the selected choice
            switch (choice) {
                case 1:
                    ArrInput= InputArray();
                    break;
                case 2:
                    SortAscending(ArrInput);
                    break;
                case 3:
                    SortDescending(ArrInput);
                    break;
                case 4:
                    System.exit(0);
            }
        } while (choice < 4 && choice >= 1);
    }

    static void DisplayMenu() {
        System.out.println("========= Bubble Sort program =========");
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Descending");
        System.out.println("4. Exit");
    }

    static int GetChoice(int min, int max) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Please choice one option: ");
                choice = Integer.parseInt(sc.nextLine());
                //check if choice is valid between min and max choice
                if (choice >= min && choice <= max) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return choice;
    }
    
    static int InputNumber(String s, int min) {
        int num;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(s);
                num = Integer.parseInt(sc.nextLine());
                //check value of number row or column is more than 0
                if (num >= min && num <= Integer.MAX_VALUE) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("Please input number and number is greater than zero");
            }
        } while (true);
        return num;
    }
    
    static int[] InputArray(){
        System.out.println("----- Input Element -----");
        System.out.println("Input Length Of Array");
        int size_arr= InputNumber("Enter Number: ",1 );
        int arr[]= new int[size_arr];
        Scanner sc= new Scanner(System.in);
        for (int i=0;i<size_arr; i++){
            arr[i]= InputNumber("Enter Number "+(i+1)+": ", Integer.MIN_VALUE);
        }
        return arr; 
    }
    
    static void SortAscending(int a[]){
        for(int i=0; i<a.length-1; i++){
            for (int j=i+1; j<a.length; j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                }
            }
        }
        System.out.println("----- Ascending -----");
        for (int i=0; i<a.length-1; i++){
            System.out.print("["+a[i]+"]->");
        }
        System.out.println("["+a[a.length-1]+"]");
    }
    
    static void SortDescending(int a[]){
        for(int i=0; i<a.length-1; i++){
            for (int j=i+1; j<a.length; j++){
                if(a[i]<a[j]){
                    int temp=a[i];
                        a[i]=a[j];
                        a[j]=temp;
                }
            }
        }
        System.out.println("----- Ascending -----");
        for (int i=0; i<a.length-1; i++){
            System.out.print("["+a[i]+"]->");
        }
        System.out.println("["+a[a.length-1]+"]");
    }
}
    

