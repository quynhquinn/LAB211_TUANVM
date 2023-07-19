
package calculatearea;

public class Triangle extends Shape {
    double A,B,C;

    public Triangle() {
    }

    public Triangle(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double getA() {
        return A;
    }

    public void setA(double A) {
        this.A = A;
    }

    public double getB() {
        return B;
    }

    public void setB(double B) {
        this.B = B;
    }

    public double getC() {
        return C;
    }

    public void setC(double C) {
        this.C = C;
    }
    public double getArea(){
        double p= (A+B+C)/2;
        return Math.sqrt((p*(p-A)*(p-B)*(p-C)));
    }
    public double getPerimeter(){
        return A+B+C;
    }
    public void printResult(){
        System.out.println("-----Triangle-----");
        System.out.println("Side A: "+this.A);
        System.out.println("Side B: "+this.B);
        System.out.println("Side C: "+this.C);
        System.out.println("Area: "+getArea());
        System.out.println("Perimeter: "+getPerimeter());
    }
    
}
