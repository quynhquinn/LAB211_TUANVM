package bmi;

import java.util.Scanner;

public class BMI {

    public static void main(String[] args) {
        int choice;
        do {
            //1. Display a menu
            DisplayMenu();
            //2. Get user choice
            choice = GetChoice(1, 3);
            //3. Do option based on the selected choice
            switch (choice) {
                case 1:
                    NormalCalculator();
                    break;
                case 2:
                    BMICalculator();
                    break;
                case 3:
                    System.exit(0);
            }
        } while (choice < 4 && choice >= 1);
    }

    static void DisplayMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
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
                System.out.println("Please enter a number");
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
            }
        } while (true);
        return num;
    }

    static int InputWeight(String s, int min) {
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
                System.out.println("BMI is digit");
            }
        } while (true);
        return num;
    }

    static int InputHeight(String s, int min) {
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
                System.out.println("BMI is digit");
            }
        } while (true);
        return num;
    }

    static String InputOperator(String s) {
        String operator;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(s);
                operator = sc.nextLine().trim();
                if (operator.matches("^[+\\-*/^=]$")) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        } while (true);
        return operator;
    }

    static void NormalCalculator() {
        double memory = 0;
        System.out.println("----- Normal Calculator -----");
        double num1 = InputNumber("Enter number: ", Integer.MIN_VALUE);
        memory = num1;
        do {
            String operator = InputOperator("Enter Operator: ");
            switch (operator) {
                case "+":
                    double num2 = InputNumber("Enter number: ", Integer.MIN_VALUE);
                    memory = num2 + memory;
                    System.out.println("Memory: " + (double) memory);
                    break;
                case "-":
                    double num3 = InputNumber("Enter number: ", Integer.MIN_VALUE);
                    memory = memory - num3;
                    System.out.println("Memory: " + (double) memory);
                    break;
                case "*":
                    double num4 = InputNumber("Enter number: ", Integer.MIN_VALUE);
                    memory = memory * num4;
                    System.out.println("Memory: " + (double) memory);
                    break;
                case "/":
                    double num5;
                    do {
                        num5 = InputNumber("Enter number: ", Integer.MIN_VALUE);
                        if(num5==0) System.out.println("Please enter a number is different to 0");
                    } while (num5 == 0);
                    memory = memory / num5;
                    System.out.println("Memory: " + (double) memory);
                    break;
                case "^":
                    double num6 = InputNumber("Enter number: ", Integer.MIN_VALUE);
                    memory = Math.pow(memory, num6);
                    System.out.println("Memory: " + (double) memory);
                    break;
                case "=":
                    System.out.println("Result: " + memory);
                    return;
            }
        } while (true);

    }

    static void BMICalculator() {
        System.out.println("----- BMI Calculator -----");
        double kg = InputWeight("Enter Weight(kg):", 1);
        double cm = InputHeight("Enter Height(cm): ", 1);
        double m = cm / 100;
        double bmi = (kg) / (m * m);
        System.out.format("BMI Number: %.2f", bmi);
        System.out.println();
        System.out.print("BMI Status: ");
        if (bmi < 19) {
            System.out.println("UNDER-STANDARD");
        } else if (bmi >= 19 && bmi <= 25) {
            System.out.println("STANDARD");
        } else if (bmi > 25 && bmi <= 30) {
            System.out.println("OVERWEIGHT");
        } else if (bmi > 30 && bmi <= 40) {
            System.out.println("FAT-SHOULD LOSE WEIGT");
        } else {
            System.out.println("VERY FAT- SHOULD LOSE WEIGHT IMMEDIATELY");
        }

    }
}
