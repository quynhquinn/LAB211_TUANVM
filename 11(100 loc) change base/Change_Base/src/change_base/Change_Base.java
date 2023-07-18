package change_base;

import java.util.*;

public class Change_Base {

    public static void main(String[] args) {
        //1. Choose the base number in
        int BaseIn = ChooseBaseIn();
        //2. Choose the base number out
        int BaseOut = ChooseBaseOut();
        //3. Enter the input value
        String InputValue = InputValue(BaseIn);
        //4. Change base from base in to base out
        Stack OutputValue = ChangeBase(InputValue, BaseIn, BaseOut);
        //5. Display output value
        Display(OutputValue);
    }

    public static int ChooseBaseIn() {
        int baseIn;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Choose the base number input(1 is binary, 2 is decimal,  3 is hexadecimal): ");
                baseIn = Integer.parseInt(sc.nextLine());
                //check if value input is valid or not
                if (baseIn >= 1 && baseIn <= 3) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return baseIn;
    }

    public static int ChooseBaseOut() {
        int baseOut;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Choose the base number out(1 is binary, 2 is decimal,  3 is hexadecimal): ");
                baseOut = Integer.parseInt(sc.nextLine());
                //check if value input is valid or not
                if (baseOut >= 1 && baseOut <= 3) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return baseOut;
    }

    public static String InputValue(int BaseIn) {
        int choice = BaseIn;
        String s = null;
        Scanner sc = new Scanner(System.in);
        switch (choice) {
            case 1:
                do {
                    System.out.println("Enter the input value by base 2: ");
                    s = sc.nextLine().trim();
                    //check if the string input is empty
                    // regex: 01 : digit 0 and 1
                    // + : 1 or more than
                } while (s.isEmpty() == true || !s.matches("^[01]+$"));
                break;
            case 2:
                do {
                    System.out.println("Enter the input value by base 10: ");
                    s = sc.nextLine().trim();
                    //check if the string input is empty
                    // [0-9]: digit from 0 to 9
                    // + : 1 or more than
                } while (s.isEmpty() == true || !s.matches("^[0-9]+$"));
                break;
            case 3:
                do {
                    System.out.println("Enter the input value by base 16: ");
                    s = sc.nextLine().trim();
                    //check if the string input is empty
                    // [0-9] digit from 0 to 9
                    // A-F: char from A - F
                    // + : 1 or more than 
                } while (s.isEmpty() == true || !s.matches("^[0-9A-F]+$"));
                break;
        }
        return s;
    }

    public static int ConvertToDec(int choice, String InputValue) {
        int Dec = 0;
        int j = 0;
        switch (choice) {
            case 1:
                char[] BinDigit = InputValue.toCharArray();
                // loop use to take position of each element or char array from last to begin
                for (int i = BinDigit.length - 1; i >= 0; i--) {
                    Dec = Dec + (Character.getNumericValue(BinDigit[i]) * (int) Math.pow(2, j));
                    j++;
                }
                break;
            case 2:
                Dec = Integer.parseInt(InputValue);
                break;
            case 3:
                char[] HexDigit = InputValue.toCharArray();
                // loop use to take position of each element or char array from last to begin
                for (int i = HexDigit.length - 1; i >= 0; i--) {
                    Dec = Dec + (Character.getNumericValue(HexDigit[i]) * (int) Math.pow(16, j));
                    j++;
                }
                break;
        }
        return Dec;
    }

    public static Stack DecConvertTo(int choice, int decimal) {
        Stack<Integer> output = new Stack<Integer>();
        switch (choice) {
            case 1:
                // do when input value after convert to dec num not equal to 0
                while (decimal != 0) {
                    output.push(decimal % 2);
                    decimal = decimal / 2;
                }
                break;

            case 2:
                output.push(decimal);
                break;
        }
        return output;
    }

    public static Stack DecToHex(int choice, int decimal) {
        Stack<Character> output = new Stack<Character>();
        char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // do when input value after convert to dec num not equal to 0
        while (decimal != 0) {
            int temp = decimal % 16;
            output.push(digit[temp]);
            decimal = decimal / 16;
        }
        return output;
    }

    public static Stack ChangeBase(String InputValue, int BaseIn, int BaseOut) {
        Stack<Character> output = new Stack<Character>();
        int Dec = ConvertToDec(BaseIn, InputValue);
        //check if case base out is Hex , call the function HexToDec
        if (BaseOut == 3) {
            output = DecToHex(BaseOut, Dec);
        } else {
            output = DecConvertTo(BaseOut, Dec);
        }
        return output;
    }

    public static void Display(Stack OutputValue) {
        Scanner sc = new Scanner(System.in);
        String choice;
        // do when stack output value if empty
        
            while (!(OutputValue.isEmpty())) {
            System.out.print(OutputValue.pop());
        }
        System.out.println();

        do {
            System.out.println("Do you want to continue (Y/N): ");
            choice = sc.nextLine();
        } while (choice.isEmpty() == true || !choice.matches("^[YN]{1}$"));
        switch (choice) {
            case "Y":
                int BaseIn = ChooseBaseIn();
                int BaseOut = ChooseBaseOut();
                String InputValue = InputValue(BaseIn);
                Stack OutputValue1 = ChangeBase(InputValue, BaseIn, BaseOut);
                Display(OutputValue1);
                break;
            case "N":
                System.out.println("Exit program");
                break;
        }
    
}
}
