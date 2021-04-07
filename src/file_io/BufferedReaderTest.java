package file_io;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("E:/test.txt");
        BufferedReader br = new BufferedReader(reader);
        String s;
        while ((s = br.readLine()) != null)
        {
            System.out.println(s);
        }
    }
}
