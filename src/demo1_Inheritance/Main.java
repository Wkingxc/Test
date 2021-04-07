package demo1_Inheritance;

import java.util.Scanner;

public class Main {

    static class Student extends Person
    {
        int score;
        Student (){

        };
        Student (String name, int age , int score)
        {
            setName(name);
            setAge(age);
            this.score = score;
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Student s1 = new Student(in.next(),in.nextInt(),in.nextInt());
        System.out.println(s1.getName()+" "+s1.getAge()+" "+s1.score);
        Student s2 = new Student();
    }
}
