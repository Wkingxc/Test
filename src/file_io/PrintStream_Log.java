package file_io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintStream_Log {
    public static void log(String massege)
    {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("E:/test.txt",true));
            System.setOut(out);
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss SSS");
            String time = sdf.format(now);
            System.out.println(time+"   "+massege);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void read()throws Exception
    {
        int k = 0;
        FileReader reader = new FileReader("E:/test.txt");
        BufferedReader br = new BufferedReader(reader);
        String[] s = new String[100];
        while ((s[k] = br.readLine())!=null)
        {
            k++;
        }
        int length = s.length;
        for(String ss:s)
        {
            if(ss!=null)
            {
                System.out.println(ss);
            }
        }
    }
    public static void main(String[] args)throws Exception {
        read();
    }
}
