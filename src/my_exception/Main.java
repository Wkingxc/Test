package my_exception;

public class Main{

    public static void main(String[] args) {
        Person[] p = new Person[10];
        for (int i = 0,num = 0; i < 10; i++,num+=3)
        {
            try {
                p[i] = new Person();
                p[i].setId(num);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

}
class Person {
    private int id;
    Person(){}
    public void setId(int id) throws Myexception {
        if(id < 20)
        {
            this.id = id;
            System.out.println(id + " creat");
        }else
        {
            throw new Myexception(id + "过大，创建失败！");
        }
    }
}
class Myexception extends Exception
{
    Myexception(){}
    Myexception(String s)
    {
        super(s);
    }
}

