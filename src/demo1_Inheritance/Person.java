package demo1_Inheritance;

public class Person {
    private String name;
    private int age;

    Person()
    {
        System.out.println("父类的空参构造被调用");
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
}

