package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test03 {
    void func1(String s)
    {
        int sum =0;
        StringBuilder str = new StringBuilder();
        int len = s.length();
        for (int i=0; i<len; i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                str.append(s.charAt(i));
                if(( i==len-1 ||!Character.isDigit(s.charAt(i+1))))
                {
                    sum += Integer.parseInt(str.toString());
                    str.delete(0,str.length());
                }
            }
        }
        System.out.println(sum);
    }
    void func2(String s)
    {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(s);
        while (m.find())
        {
            sum += Integer.parseInt(m.group());
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        Test03 test03 = new Test03();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        test03.func1(s);
        test03.func2(s);
        in.close();
    }
}
