package my_sort;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Mycompare1 mycompareup = new Mycompare1();
        Mycompare2 mycomparedown = new Mycompare2();
        List<Student> s = new ArrayList<>();
        for(int i=0; i<5; i++)
        {
            s.add(new Student((in.nextInt())));
        }
        s.sort(mycompareup);
        for (Student student : s)
        {
            System.out.print(student.score + " ");
        }
        s.sort(mycomparedown);
        System.out.println("");
        for(Student student : s)
        {
            System.out.print(student.score + " ");
        }
    }
}
class Mycompare1 implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2)
    {
        return o1.score-o2.score;
    }
}

class Mycompare2 implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2)
    {
        return o2.score-o1.score;
    }
}

