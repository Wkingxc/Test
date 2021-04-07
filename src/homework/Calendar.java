package homework;
import java.util.Scanner;
@SuppressWarnings("ALL")
public class Calendar {
    int[][] months = {
            {0,31,28,31,30,31,30,31,31,30,31,30,31},
            {0,31,29,31,30,31,30,31,31,30,31,30,31}
    };//months[1]为闰年
    String[] weeks = {"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
    boolean isLeapyear(int year)//判断是否是闰年
    {
        if((year%100==0&&year%400==0)||(year%100!=0&&year%4==0))
        {
            return true;
        }
        return false;
    }
    int findWeek(int y,int m,int d)//找到指定日期的星期数0~6
    {
        //基姆拉尔森计算公式
        int week = 0;
        if(m==1 || m==2)
        {
            m += 12;
            y--;
        }
        week = (d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
        return week;

    }
    void go()//程序入口
    {
        Scanner in = new Scanner(System.in);
        int method = 0;
        System.out.println("请输入模式：\n 1、打印指定年份日历 \n 2、给日期查星期");
        method = in.nextInt();
        while(true)
        {
            switch (method)
            {
                case 1-> function1();
                case 2-> function2();
                default -> System.out.println("wrong!");
            }
            System.out.println("请输入模式：\n 1、打印指定年份日历 \n 2、给日期查星期");
            method = in.nextInt();
        }

    }
    void function1()//打印指定年份日历
    {
        boolean is1582 = false;
        int year, flag = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入年份：");
        year = in.nextInt();
        if(year==1582){is1582 = true;}
        if(isLeapyear(year))
        {
            flag = 1;//使用months[1]，也就是闰年的月份天数表
        }
        for(int index = 1; index <= 12; index++)//index代表月份
        {
            int day = 1;
            System.out.println(index+"月");
            for(String str:weeks)//打印标题
            {
                System.out.printf("%5s",str);
            }
            System.out.println();
            int intiWeek = findWeek(year,index,1);
            for(int i =0; i< 7; i++)//打印日历第一行
            {
                if(i < intiWeek)
                {
                    System.out.printf("%7s","");
                }else
                {
                    System.out.printf("%7d",day);
                    if(is1582 && day==4 && index==10){day = 14;}
                    day++;
                }
            }
            System.out.println();
            while(day <= months[flag][index])//打印日历剩余行
            {
                for (int j = 0;j < 7; j++)
                {
                    if(day <= months[flag][index])
                    {
                        System.out.printf("%7d",day);
                        day++;
                    }
                }
                System.out.println();
            }
        }
    }
    void function2()//查到指定日期对应的星期数
    {
        Scanner in = new Scanner(System.in);
        int y,m,d;
        System.out.println("请输入年份：");
        y = in.nextInt();
        System.out.println("请输入月份：");
        m = in.nextInt();
        System.out.println("请输入日期：");
        d = in.nextInt();
        int t = findWeek(y, m,d );
        String result = weeks[t];
        System.out.println(result);
    }
    public static void main(String[] args) {
        Calendar x = new Calendar();
        x.go();
    }
}
