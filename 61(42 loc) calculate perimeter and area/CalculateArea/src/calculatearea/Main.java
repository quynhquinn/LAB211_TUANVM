package calculatearea;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //1. Get data of Rectangle
        Rectangle R = getRectangle();
        //2. Get data of Circle
        Circle C = getCircle();
        //3. Get data of Triangle
        Triangle T = getTriangle();
        //4. Display Area And Perimeter
        DisplayAreaAndPerimeter(R,C,T);
    }

    static double CheckInputNumber(String s, double min) {
        double num;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println(s);
                num = Double.parseDouble(sc.nextLine());
                //check value of number row or column is more than 0
                if (num >= min && num <= Double.MAX_VALUE) {
                    break;
                }
                throw new NumberFormatException();

            } catch (NumberFormatException e) {
                System.out.println("Please input number and number is greater than zero");
            }
        } while (true);
        return num;
    }

    static Rectangle getRectangle() {
        System.out.println("=====Calculator Shape Program=====");
        double w = CheckInputNumber("Please input side width of Rectangle:", 1);
        double l = CheckInputNumber("Please input length of Rectangle:", 1);
        return new Rectangle(w, l);
    }

    static Circle getCircle() {
        double r = CheckInputNumber("Please input radius of Circle:", 1);
        return new Circle(r);
    }

    static Triangle getTriangle() {
        double a = CheckInputNumber("Please input side A of Triangle:", 1);
        double b = CheckInputNumber("Please input side B of Triangle:", 1);
        double c = CheckInputNumber("Please input side C of Triangle:", 1);
        return new Triangle(a, b, c);
    }

    static void DisplayAreaAndPerimeter(Rectangle R, Circle C, Triangle T) {
        R.printResult();
        C.printResult();
        T.printResult();
    }

}
