package matrix;

import java.util.*;

public class Matrix {

    public static void main(String[] args) {
        int choice;
        do {
            //1. Display a menu
            DisplayMenu();
            //2. Get user choice
            choice = GetChoice(1, 4);
            //3. Do option based on the selected choice
            switch (choice) {
                case 1:
                    AdditionMatrix();
                    break;
                case 2:
                    SubtractionMatrix();
                    break;
                case 3:
                    MultiplicationMatrix();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (choice < 4 && choice >= 1);
    }

    public static void DisplayMenu() {
        System.out.println("======Calculator program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    public static int GetChoice(int min, int max) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Your choice: ");
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

    public static int InputNumber(String s, int min) {
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
                System.out.println("Value of matrix is digit");
            }
        } while (true);
        return num;
    }

    public static int[][] EnterFirstMatrix() {
        int row = InputNumber("Enter Row Matrix 1:", 1);
        int column = InputNumber("Enter Column Matrix 1:", 1);
        int[][] FirstMatrix = new int[row][column];
        //loop use to take position of each element in row
        for (int i = 0; i < row; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < column; j++) {
                FirstMatrix[i][j] = InputNumber("Enter Matrix1" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:", Integer.MIN_VALUE);
            }
        }
        return FirstMatrix;
    }

    public static int[][] EnterSecondMatrix(int[][] matrix1) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2, col2;
        do {
            try {
                row2 = InputNumber("Enter Row Matrix 2:", 1);
                //check if the row of matrix 2 is equal to the row of matrix 1
                if (row2 == row1) {
                    break;
                }
                System.out.println("The row of matrix 2 must have equal to the row of matrix 1");
            } catch (NumberFormatException e) {

            }
        } while (true);
        do {
            try {
                col2 = InputNumber("Enter Column Matrix 2:", 1);
                ////check if the col of matrix 2 is equal to the col of matrix 1
                if (col2 == col1) {
                    break;
                }
                System.out.println("The column of matrix 2 must have equal to the column of matrix 1");
            } catch (NumberFormatException e) {
            }
        } while (true);
        int[][] SecondMatrix = new int[row2][col2];
        //loop use to take position of each element in row
        for (int i = 0; i < row2; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < col2; j++) {
                SecondMatrix[i][j] = InputNumber("Enter Matrix1" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:", Integer.MIN_VALUE);
            }
        }
        return SecondMatrix;
    }

    public static int[][] EnterSecondMultiMatrix(int[][] matrix1) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2, col2;
        do {
            try {
                row2 = InputNumber("Enter Row Matrix 2:", 1);
                //check if the row of matrix 2 is equal to the column of matrix 1
                if (row2 == col1) {
                    break;
                }
                System.out.println("The row of matrix 2 must have equal to column of matrix 1");
            } catch (NumberFormatException e) {

            }
        } while (true);
        col2 = InputNumber("Enter Column Matrix 2:", 1);
        int[][] SecondMatrix = new int[row2][col2];
        //loop use to take position of each element in row
        for (int i = 0; i < row2; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < col2; j++) {
                SecondMatrix[i][j] = InputNumber("Enter Matrix1" + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:", Integer.MIN_VALUE);
            }
        }
        return SecondMatrix;
    }

    public static void DisplayMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        //loop use to take position of each element in row
        for (int i = 0; i < row; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < column; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void AdditionMatrix() {
        System.out.println("--------Addition--------");
        int[][] matrix1 = EnterFirstMatrix();
        int[][] matrix2 = EnterSecondMatrix(matrix1);
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[matrix1.length][matrix1[0].length];
        System.out.println("--------Result--------");
        DisplayMatrix(matrix1);
        System.out.println("+");
        DisplayMatrix(matrix2);
        System.out.println("=");
        //loop use to take position of each element in row 
        for (int i = 0; i < row; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        DisplayMatrix(result);
    }

    public static void SubtractionMatrix() {
        System.out.println("--------Subtraction--------");
        int[][] matrix1 = EnterFirstMatrix();
        int[][] matrix2 = EnterSecondMatrix(matrix1);
        int row = matrix1.length;
        int column = matrix1[0].length;
        int[][] result = new int[matrix1.length][matrix1[0].length];
        System.out.println("--------Result--------");
        DisplayMatrix(matrix1);
        System.out.println("-");
        DisplayMatrix(matrix2);
        System.out.println("=");
        //loop use to take position of each element in row
        for (int i = 0; i < row; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < column; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        DisplayMatrix(result);
    }

    public static void MultiplicationMatrix() {
        System.out.println("--------Multiplication--------");
        int[][] matrix1 = EnterFirstMatrix();
        int[][] matrix2 = EnterSecondMultiMatrix(matrix1);
        int row = matrix1.length;
        int column = matrix2[0].length;
        int[][] result = new int[row][column];
        System.out.println("--------Result--------");
        DisplayMatrix(matrix1);
        System.out.println("*");
        DisplayMatrix(matrix2);
        System.out.println("=");
        //loop use to take position of each element in row
        for (int i = 0; i < row; i++) {
            //loop use to take position of each element in column
            for (int j = 0; j < column; j++) {
                //loop use to take position of each element in each row of matrix 1
                // and column of matrix 2
                for (int p = 0; p < matrix1[0].length; p++) {
                    result[i][j] = result[i][j] + matrix1[i][p] * matrix2[p][j];
                }
            }
        }
        DisplayMatrix(result);
    }
}
