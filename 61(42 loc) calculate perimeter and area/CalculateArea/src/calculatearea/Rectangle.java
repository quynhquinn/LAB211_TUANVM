
package calculatearea;

public class Rectangle extends Shape {
    double width,length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public double getArea(){
        return width*length;
    }
    
    public double getPerimeter(){
        return (width+length)*2;
    }
    public void printResult(){
        System.out.println("-----Rectangle-----");
        System.out.println("Width: "+this.width);
        System.out.println("Length: "+this.length);
        System.out.println("Area: "+getArea());
        System.out.println("Perimeter: "+getPerimeter());
    }
    
}
