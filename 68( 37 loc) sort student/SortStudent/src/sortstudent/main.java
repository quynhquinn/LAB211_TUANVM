package sortstudent;

import java.util.*;

public class main {

    public static void main(String[] args) {
        //1. Input data student
        ArrayList<Student> StudentList= inputStudentList();
        //2. Sort student by name
        sortStudentsByName(StudentList);
        //3. Display list students after sort by name
        displayStudentsSorted(StudentList);
    }

    static String inputName(String s) {
        String name;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            name = sc.nextLine();
            //do when string code is empty 
            // [A-Z]{1}: 1 character from A to Z
            // [a-z]: char from a to z
            // +: 1 or more than
        } while (name.isEmpty() == true || !name.matches("^[A-Z]{1}[a-z]+$"));
        return name;
    }
    static String inputClass(String s) {
        String classes;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(s);
            classes = sc.nextLine();
        } while (classes.isEmpty() == true || !classes.matches("^(FU)[0-9]+$"));
        return classes;
    }
    static float inputMark(String s) {
        float mark;
        Scanner sc = new Scanner(System.in);
        do {
            try{
            System.out.print(s);
            mark = Integer.parseInt(sc.nextLine().trim());
            if(mark>=0 && mark <=100){break;}
            }catch(NumberFormatException e){
            }
        } while (true);
        return mark;
    }
    static Student inputStudent(){
        String name= inputName("Name: ");
        String classes= inputClass("Classes: ");
        float mark= inputMark("Mark: ");
        Student s= new Student(name, classes, mark);
        return s;
    }
    static ArrayList<Student> inputStudentList(){
        String choice;
        Scanner sc= new Scanner (System.in);
        ArrayList<Student> list= new ArrayList<>();
        System.out.println("===== Collection Sort Program=====");
        do{
            System.out.println("Please input student information");
            Student s= inputStudent();
            list.add(s);
            do{
            System.out.print("Do you want to enter more student information?(Y/N):");
            choice= sc.nextLine();
            if(choice.matches("[YN]")){break;}
            switch(choice){
                case "Y":
                    System.out.println("Please input student information");
                    Student s1= inputStudent();
                    list.add(s1);
                    break;
                case "N":
                    break;
            }
            }while(true);
            }while(!"N".equals(choice));
        return list;
    }
    static void sortStudentsByName(ArrayList<Student> list){
        Collections.sort(list, new StudentComparator());
    }
    static void displayStudentsSorted(ArrayList<Student> list){
        int i=1;
        while(i<=list.size()){
            for (Student s: list){
                System.out.println("-------------Student "+i+"-------------");
                System.out.print(s);
                i++;
            }
        }
    }
    
    
    
}

   
    

