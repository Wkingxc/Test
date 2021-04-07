package file_io;

import java.io.FileReader;
import java.util.Properties;

public class Property_IO {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("users.properties");
        Properties user = new Properties();
        user.load(fr);
        System.out.println(user.getProperty("wpy123"));
    }
}
