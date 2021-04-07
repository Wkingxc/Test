package file_io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Obeject_IO_Stream {
    Person p1 = new Person(12,"a");
    Person p2 = new Person(13,"b");
    Person p3 = new Person(14,"c");
     static List<Person> peoplelist = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        Obeject_IO_Stream x = new Obeject_IO_Stream();
        peoplelist.add(x.p1);
        peoplelist.add(x.p2);
        peoplelist.add(x.p3);
        x.serialize();
        peoplelist.set(0,new Person(999,"4444"));
        peoplelist.set(1,new Person(123,"xas"));
        for(Person p : peoplelist)
        {
            System.out.println(p);
        }
        System.out.println();
        x.deserialize();
    }

    //只能序列化单个对象或者对象集合
    public void serialize()throws Exception
    {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("people"));
        out.writeObject(peoplelist);
        out.flush();
        out.close();
    }

    public void deserialize()throws Exception
    {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("people"));
        /*Object o1 = in.readObject();
        System.out.println(o1);*/
        peoplelist = (List<Person>) in.readObject();
        for (Person p : peoplelist)
        {
            System.out.println(p);
        }
        in.close();
    }
}
class Person implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    //采用 transient 关键字修饰此属性，序列化时会忽略
    transient int age;
    Person(int a,String s)
    {
        id = a;
        name = s;
    }

    @Override
    public String toString() {
        return "ID:"+id+"---姓名"+name;
    }
}
