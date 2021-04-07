package file_io;

import java.io.*;

public class CopyFile {

    public static void main(String[] args) {
        File src = new File("C:\\Users\\至尊\\Desktop\\学习");
        File des = new File("E:\\Xunlei\\");
        try
        {
            copy(src,des);
            System.out.println("拷贝完成！");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void copy(File src,File des)throws IOException
    {
        //保证创建的时候有根目录
        des = new File(des.getAbsolutePath()+"\\"+src.getName());
        v_copy(src,des);
    }
    public static void v_copy(File src,File des)throws IOException
    {
        File[] files = src.listFiles();

        if(!des.exists()){

            des.mkdirs();
        }
        for(File file: files)
        {
            if(file.isDirectory())
            {
                v_copy(file,new File(des+"\\"+file.getName()));

            }else if(file.isFile())
            {
                String s1 = file.getAbsolutePath();
                String s2 = des.getPath()+"\\"+file.getName();
                InputStream bis = new BufferedInputStream(new FileInputStream(s1));
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(s2));
                byte[] bytes = new byte[1024];
                int count;
                while ((count= bis.read(bytes))!=-1)
                {
                    bos.write(bytes,0,count);
                }
                bis.close();
                bos.close();
            }
        }
    }
}
