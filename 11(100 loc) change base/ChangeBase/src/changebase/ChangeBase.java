package changebase;

import java.math.BigInteger;
import java.util.*;

public class ChangeBase {

    public static void main(String[] args) {
        //1. Choose the base number in
        int BaseIn = ChooseBaseIn();
        //2. Choose the base number out
        int BaseOut = ChooseBaseOut(BaseIn);
        //3. Enter the input value
        String InputValue = InputValue(BaseIn);
        //4. Change base from base in to base out
        StringBuilder OutputValue = ChangeBase(InputValue, BaseIn, BaseOut);
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
                //check if base in is valid 
                if (baseIn >= 1 && baseIn <= 3) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
        } while (true);
        return baseIn;
    }

    public static int ChooseBaseOut(int BaseIn) {
        int baseOut;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Choose the base number out(1 is binary, 2 is decimal,  3 is hexadecimal): ");
                baseOut = Integer.parseInt(sc.nextLine());
                //check if value base out is valid 
                if (baseOut >= 1 && baseOut <= 3 && BaseIn != baseOut ) {
                    break;
                }
                System.out.println("Can't convert when base out is equal to base in");
                System.out.println();
            } catch (NumberFormatException e) {
                
            }
        } while (true);
        return baseOut;
    }

    public static String InputValue(int BaseIn) {
        int choice = BaseIn;
        String s = new String();
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
                    //a-f : char from a-f
                    // + : 1 or more than 
                } while (s.isEmpty() == true || !s.matches("^[0-9A-Fa-f]+$"));
                break;
        }
        
        return s;
    }

    public static BigInteger ConvertToDec(int BaseIn, String InputValue) {
        BigInteger Dec = BigInteger.ZERO;
        switch (BaseIn) {
            case 1:
                BigInteger ValueInput = new BigInteger(InputValue);
                BigInteger base = BigInteger.valueOf(2);
                //loop us to take index of each digit from last to first
                for (int i = 0; i < InputValue.length(); i++) {
                    BigInteger[] divide = ValueInput.divideAndRemainder(BigInteger.TEN);
                    Dec = Dec.add(divide[1].multiply(base.pow(i)));
                    ValueInput = divide[0];
                }
                break;
            case 2:
                BigInteger Value10 = new BigInteger(InputValue);
                return Value10;
            case 3:
                int j = 0;
                int digitValue;
                BigInteger base16 = BigInteger.valueOf(16);
                // loop use to take value index of each digit from first to last
                for (int i = InputValue.length() - 1; i >= 0; i--) {
                    digitValue = Character.getNumericValue(InputValue.charAt(i));
                    Dec = Dec.add((BigInteger.valueOf(digitValue).multiply(base16.pow(j))));
                    j++;
                }
        }
        return Dec;
    }

    public static StringBuilder DecConvertTo(int choice, BigInteger decimal) {
        StringBuilder output = new StringBuilder();
        switch (choice) {
            case 1:
                // do when input value after convert to dec num not equal to 0
                while (decimal != BigInteger.ZERO) {
                    BigInteger[] remain = decimal.divideAndRemainder(BigInteger.valueOf(2));
                    output.append(remain[1]);
                    decimal = remain[0];
                }
                break;
            case 2:
                String out = decimal.toString();
                char[] out1 = out.toCharArray();
                //loop use to take position of each digit from char array from last to first
                for (int i = out.length() - 1; i >= 0; i--) {
                    output.append(out1[i]);
                }
                break;
            case 3:
                // do when input value after convert to dec num not equal to 0
                while (decimal != BigInteger.ZERO) {
                    BigInteger remain = decimal.mod(BigInteger.valueOf(16));
                    //check if remainder is a number from 0 to 9
                    if (remain.intValue() >= 0 && remain.intValue() <= 9) {
                        output.append(remain.toString());
                    } else {
                        switch (remain.intValue()) {
                            case 10:
                                output.append('A');
                                break;
                            case 11:
                                output.append('B');
                                break;
                            case 12:
                                output.append('C');
                                break;
                            case 13:
                                output.append('D');
                                break;
                            case 14:
                                output.append('E');
                                break;
                            case 15:
                                output.append('F');
                                break;
                        }
                    }
                    decimal = decimal.divide(BigInteger.valueOf(16));
                }
                break;
        }
        return output.reverse();
    }

    public static StringBuilder ChangeBase(String InputValue, int BaseIn, int BaseOut) {
        StringBuilder output ;
        BigInteger Dec = ConvertToDec(BaseIn, InputValue);
        output = DecConvertTo(BaseOut, Dec);
        return output;
    }

    public static void Display(StringBuilder OutputValue) {
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.println(OutputValue);
        System.out.println();
        do {
            System.out.println("Do you want to continue (Y/N): ");
            choice = sc.nextLine();
        // loop again if choice input is empty or it's not syntactically correct
        // regex: YN: Y or N ( Yes or No)
        // {1}: 1 character 
        } while (choice.isEmpty() == true || !choice.matches("^[YN]{1}$"));
        switch (choice) {
            case "Y" :
                int BaseIn = ChooseBaseIn();
                int BaseOut = ChooseBaseOut(BaseIn);
                String InputValue = InputValue(BaseIn);
                StringBuilder OutputValue1 = ChangeBase(InputValue, BaseIn, BaseOut);
                Display(OutputValue1);
                break;
            case "N":
                System.out.println("Exit program");
                break;
        }

    }

}
