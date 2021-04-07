package file_io;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args)throws Exception {
        File f1 = new File("E:/Xunlei/text.txt");
        File f2 = f1.getParentFile();
        System.out.println(f1.exists());

        if(!f1.exists())
        {
            f1.createNewFile();//创建具体文件
            f1.mkdir();//创建单层目录
            f1.mkdirs();//创建多层目录
        }
        String parentpath = f1.getParent();//获取父路径
        System.out.println(parentpath);

        String absolutepath = f1.getAbsolutePath();//获取绝对路径
        System.out.println(absolutepath);

        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f1.length());

        long haomiao = f1.lastModified();//获取最后一次修改时间，从1970到现在的总毫秒数
        Date time = new Date(haomiao);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strtime = sdf.format(time);
        System.out.println(strtime);

        File[] files = f2.listFiles();//返回子目录下的所有文件或目录
        for(File f:files)
        {
            System.out.println(f.getAbsolutePath());
        }
    }
}
