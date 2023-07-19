
package calculatearea;

public class Circle extends Shape {
    double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return 2*radius*Math.PI;
    }
    public double getParimeter(){
        return radius*radius*Math.PI;
    }
    public void printResult(){
        System.out.println("-----Circle-----");
        System.out.println("Radius: "+ this.radius);
        System.out.println("Area: "+getArea());
        System.out.println("Perimeter: "+getParimeter());
    }
            
    
}
