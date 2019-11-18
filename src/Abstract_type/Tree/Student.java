package Abstract_type.Tree;

import java.util.ArrayList;
import java.util.List;

public class Student {
    int age;
    String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    int changeAge(int age){
        if(age == 0)
            return age;
        return changeAge(age - 1);
    }

    public static void main(String[] args) {
        Student s = new Student(10, "zhiyuan");
        s.changeAge(5);
    }
}
