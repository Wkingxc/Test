package file_io;

import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) {
       FileReader fr = null;
       try {
           fr = new FileReader("E:/test.txt");
           char[] datas = new char[100];
           fr.read(datas);
           for(char c:datas)
           {
               System.out.print(c);
           }

       } catch(Exception e){
           e.printStackTrace();
       }finally
       {
           if(fr!=null){
               try {
                   fr.close();
               } catch(Exception e){
                   e.printStackTrace();
               }

           }
       }


    }
}
