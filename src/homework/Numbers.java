package homework;

import java.math.BigInteger;
import java.util.Scanner;
public class Numbers {
    void go()
    {
        Scanner in = new Scanner(System.in);
        MynaturalNumbers m1 = new MynaturalNumbers(in.next());//
        MynaturalNumbers m2 = new MynaturalNumbers();
        //调用setInteger方法进行赋值
        m2.setInteger(in.next());
        //创建一个与m1同值的整数类实例
        MyInteger m3 = m1.toMyInteger();
        //直接打印m1 m2 m3 对象，调用重写的toString方法
        System.out.println("m1="+m1+" m2="+m2+" m3="+m3);
        System.out.println("m1="+m1.getInteger()+" m2="+m2.getInteger()+" m3="+m3.getInteger());
        //获取 m1 m2 m3 的值的长度
        System.out.println(m1.getLength()+" "+m2.getLength()+" "+m3.getLength());
        //比较m1、m2和m1、m3的大小是否相等，调用重写的equals方法
        System.out.println("m1=m2-->"+m1.equals(m2));
        System.out.println("m1=m3-->"+m1.equals(m3));
        //分别计算m1与m2的加减乘除
        System.out.println("m1+m2= "+m1.add(m2));
        System.out.println("m1-m2= "+m1.subtract(m2));
        System.out.println("m1*m2= "+m1.multiply(m2));
        System.out.println("m1/m2= "+m1.divide(m2));
        in.close();
    }
    public static void main(String[] args) throws Exception{
        Numbers numbers = new Numbers();
        numbers.go();
    }
}
class MyInteger
{
    private BigInteger integer;//储存数据
    private int length;//数据长度
    MyInteger(){}//空参构造函数
    MyInteger(String s)//有参构造函数，进行赋值
    {
        setInteger(s);
    }
    String delete_sign(String s)//删除千分符号
    {
        while (s.contains(","))
        {
            s = s.replace(",","");
        }
        return s;
    }
    void setInteger(String s)//赋值
    {
        if(s.contains(","))
        {
            try {
                integer = new BigInteger(delete_sign(s));
            }catch (Exception e){
                System.out.println("输入错误！");
                System.exit(0);
            }
        }else
        {
            try {
                integer = new BigInteger(s);
            }catch (Exception e){
                System.out.println("输入错误！");
                System.exit(0);
            }
        }
    }
    int getLength()//获取数据长度
    {
        String s = integer.toString();
        length = s.length();
        return length;
    }
    BigInteger getInteger()//获取数据
    {
        return integer;
    }
    BigInteger add(MyInteger m)//加法
    {
        return integer.add(m.integer);
    }
    BigInteger subtract(MyInteger m)//减法
    {
        return integer.subtract(m.integer);
    }
    BigInteger multiply(MyInteger m)//乘法
    {
        return integer.multiply(m.integer);
    }
    BigInteger divide(MyInteger m)//除法
    {
        return integer.divide(m.integer);
    }
    public boolean equals(MyInteger m)//重写的比较两个MyInteger类的方法
    {
        return this.integer.equals(m.integer);
    }
    public String toString()//重写的将MyInteger实例对象转成字符串的方法
    {
        return  integer.toString();//调用bigInteger的toString方法
    }
}
class MynaturalNumbers extends MyInteger
{
    MynaturalNumbers(){}
    MynaturalNumbers(String s)//有参构造
    {
        setInteger(s);
    }
    MyInteger toMyInteger()//返回一个同值的整数类实例
    {
        return new MyInteger(getInteger().toString());
    }

}
