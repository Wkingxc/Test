package file_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("E:/test.txt");
            int readcount = 0;
            byte[] datas = new byte[4];
            while ((readcount = fis.read(datas))!=-1)
            {
                System.out.print(new String(datas,0,readcount));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally
        {
            if(null!=fis)
            {
                try {
                    fis.close();
                } catch(IOException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
