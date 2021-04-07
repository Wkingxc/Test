package file_io;

import java.io.FileWriter;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("E:/test.txt",true);
            writer.write("天天开心！");

        } catch(Exception e){
            e.printStackTrace();
        }finally
        {
            if(writer!=null){
                try {
                    writer.close();
                } catch(Exception e){
                    e.printStackTrace();
                }

            }
        }

    }
}
