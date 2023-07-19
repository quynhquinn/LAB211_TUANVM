package analyze_string;

import java.util.*;

public class Analyze_string {

    public static void main(String[] args) {
        //1. Input string
        String Input = InputString("Input String: ");
        //2. Display result string analyze
        DisplayResultAnalysis(Input);
    }
    static boolean CheckSquareNum(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    static String InputString(String s) {
        String input;
        Scanner sc = new Scanner(System.in);
        System.out.println("==== Analysis String program ====");
        do {
            try {
                System.out.print(s);
                input = sc.nextLine().trim();
                if (input.isEmpty() == false) {
                    break;
                }
                System.out.println("String can't empty");
            } catch (NumberFormatException e) {
            }
        } while (true);
        return input;
    }
    static ArrayList<Integer> ListSquareNum(String s) {
        String num = s.replaceAll("[^0-9]", " ");
        String[] number = num.split("\\s+");
        int[] num1 = new int[number.length];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = Integer.parseInt(number[i]);
        }
        ArrayList<Integer> SquareNum = new ArrayList<>();
        for (int i = 0; i < num1.length; i++) {
            if (CheckSquareNum(num1[i]) == true) {
                SquareNum.add(num1[i]);
            }
        }
        return SquareNum;
    }
    static ArrayList<Integer> ListOddNum(String s) {
        String num = s.replaceAll("[^0-9]", " ");
        String[] number = num.split("\\s+");
        int[] num1 = new int[number.length];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = Integer.parseInt(number[i]);
        }
        ArrayList<Integer> OddNum = new ArrayList<>();
        for (int i = 0; i < num1.length; i++) {
            if (num1[i]%2!=0) {
                OddNum.add(num1[i]);
            }
        }
        return OddNum;
    }
    static ArrayList<Integer> ListEvenNum(String s) {
        String num = s.replaceAll("[^0-9]", " ");
        String[] number = num.split("\\s+");
        int[] num1 = new int[number.length];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = Integer.parseInt(number[i]);
        }
        ArrayList<Integer> EvenNum = new ArrayList<>();
        for (int i = 0; i < num1.length; i++) {
            if (num1[i]%2==0) {
                EvenNum.add(num1[i]);
            }
        }
        return EvenNum;
    }
    static ArrayList<Integer> ListAllNum(String s) {
        String num = s.replaceAll("[^0-9]", " ");
        String[] number = num.split("\\s+");
        int[] num1 = new int[number.length];
        for (int i = 0; i < num1.length; i++) {
            num1[i] = Integer.parseInt(number[i]);
        }
        ArrayList<Integer> AllNum = new ArrayList<>();
        for (int i = 0; i < num1.length; i++) {
                AllNum.add(num1[i]);
            
        }
        return AllNum;
    }
    static void DisplayNum(String s) {
        ArrayList<Integer> square = ListSquareNum(s);
        System.out.print("Perfect Square Numbers: ");
        System.out.print(square);
        System.out.println();
        ArrayList<Integer> odd = ListOddNum(s);
        System.out.print("Odd Numbers: ");
        System.out.print(odd);
        System.out.println();
        ArrayList<Integer> even = ListEvenNum(s);
        System.out.print("Even Numbers: ");
        System.out.print(even);
        System.out.println();
        ArrayList<Integer> all = ListAllNum(s);
        System.out.print("All Numbers: ");
        System.out.print(all);
        System.out.println();
    }
    static StringBuilder ListUpperChar(String s){
        StringBuilder upperChar= new StringBuilder();
        char[] character= s.toCharArray();
        for(int i=0;i<character.length;i++){
            if (Character.isUpperCase(character[i])==true){
                upperChar.append(character[i]);
            }
        }
        return upperChar;
    }
    static StringBuilder ListLowerChar(String s){
        StringBuilder lowerChar= new StringBuilder();
        char[] character= s.toCharArray();
        for(int i=0;i<character.length;i++){
            if (Character.isLowerCase(character[i])==true){
                lowerChar.append(character[i]);
            }
        }
        return lowerChar;
    }
    static StringBuilder ListSpecialChar(String s){
        StringBuilder specialChar= new StringBuilder();
        char[] character= s.toCharArray();
        for(int i=0;i<character.length;i++){
            if (Character.isLetterOrDigit(character[i])==false){
                specialChar.append(character[i]);
            }
        }
        return specialChar;
    }
    static StringBuilder ListAllChar(String s){
        StringBuilder allChar= new StringBuilder();
        char[] character= s.toCharArray();
        for(int i=0;i<character.length;i++){
            if (Character.isDigit(character[i])==false){
                allChar.append(character[i]);
            }
        }
        return allChar;
    }
    static void DisplayChar(String s){
        StringBuilder Upper = ListUpperChar(s);
        System.out.print("Uppercase Characters: ");
        System.out.print(Upper);
        System.out.println();
        StringBuilder Lower = ListLowerChar(s);
        System.out.print("Lowercase Characters: ");
        System.out.print(Lower);
        System.out.println();
        StringBuilder Special = ListSpecialChar(s);
        System.out.print("Special Characters: ");
        System.out.print(Special);
        System.out.println();
        StringBuilder All = ListAllChar(s);
        System.out.print("All Characters: ");
        System.out.println();
        System.out.print(All);
    }
    static void DisplayResultAnalysis(String s){
        System.out.println("-----Result Analysis------");
        DisplayNum(s);
        DisplayChar(s);
    }
}
