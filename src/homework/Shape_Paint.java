package homework;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Shape_Paint {
    static int count = 0;//用来保存图形的序号
    Shape[] shapes = new Shape[100];//用于保存创建的图形
    void go()
    {
        int method;
        Scanner in = new Scanner(System.in);
        while (true)
        {
                String name;
                System.out.println("1、创建矩形 2、创建圆 3、创建三角形 4、绘制序号前所有图形 5、查找图形");
                method = in.nextInt();
                switch (method)
                {
                    case 1:{
                        System.out.print("请输入矩形的名称： ");
                        name = in.next();
                        shapes[count++] = new Rectangle(name);
                        break;
                    }
                    case 2:{
                        System.out.print("请输入圆的名称： ");
                        name = in.next();
                        shapes[count++] = new Circle(name);
                        break;
                    }
                    case 3:{
                        System.out.print("请输入三角形的名称： ");
                        name = in.next();
                        shapes[count++] = new Triangle(name);
                        break;
                    }
                    case 4:{
                        System.out.println("请输入要绘制的截止序号： ");//绘制序号之前的所有图形
                        int n = in.nextInt();
                        for(int i=0; i<n; i++)
                        {
                            shapes[i].draw();
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("请输入要查找图形的名称： ");
                        String s = in.next();
                        findName(s);
                        break;
                    }
                    default:
                        System.out.println("wrong!");
                }
                System.out.println("---------------------------------------------");
            }
    }
    void findName(String s)
    {
        boolean flag = false;//用来标记有没有找到
        for(int i=0; i<count; i++)
        {
            if(shapes[i].getName().equals(s))
            {
                shapes[i].draw();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("未找到！");
        }
    }
    public static void main(String[] args) {
        Shape_Paint shape_paint = new Shape_Paint();
        shape_paint.go();
    }
}
class Shape
{
    private int xuhao;
    private String name;
    void setName(String s)
    {
        name = s;
        xuhao = Shape_Paint.count;
    }
    void draw()//根据对象类型进行不同的绘制方案
    {
        if(this instanceof Rectangle)
        {
            System.out.println(xuhao+" 矩形 "+name);
        }else if(this instanceof Circle)
        {
            System.out.println(xuhao+" 圆形 "+name);
        }else if(this instanceof Triangle)
        {
            System.out.println(xuhao+" 三角形 "+name);
        }
    }
    String getName(){return name;}
}
class Rectangle extends Shape
{
    Rectangle(String s)
    {
        setName(s);
    }
}
class Circle extends Shape
{
    Circle(String s){setName(s);}
}
class Triangle extends Shape
{
    Triangle(String s){setName(s);}
}
