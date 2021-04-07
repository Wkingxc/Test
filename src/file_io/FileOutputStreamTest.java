package file_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("E:/test.txt");
            fos = new FileOutputStream("E:/test01.txt",true);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            for (int i = 0; i < 9000000; i++)
            {
                fos.write(bytes);
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally
        {
            try
            {
                fis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch(Exception e){
                e.printStackTrace();
            }

        }

    }
}
