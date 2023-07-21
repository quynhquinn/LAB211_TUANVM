
package sortstudent;

public class Student {
    private String name;
    private String classes;
    private float mark;

    public Student() {
    }

    public Student(String name, String classes, float mark) {
        this.name = name;
        this.classes = classes;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    public String toString(){
        return  "Name: " + name + "\n" +
                "Classes : "+classes+" \n"+
                "Mark: "+mark+"\n";
        
                
                
    }
    

   
    
}
