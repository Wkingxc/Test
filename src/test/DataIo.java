package test;

import java.io.*;

public class DataIo {
    public static void main(String[] args) throws Exception{
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("E:\\data.txt")));
        out.writeBoolean(true);
        out.writeChar('c');
        out.writeByte(1);
        out.writeShort(2);
        out.writeInt(3);
        out.writeLong(4L);
        out.writeFloat(5.0f);
        out.writeDouble(6.0);
        out.writeUTF("hello world!");
        out.close();
        /*DataInputStream in = new DataInputStream(
                new BufferedInputStream( new FileInputStream("E:\\data.txt")));
        System.out.println(in.readBoolean()+";"+in.readChar()+";");
        System.out.println(in.readByte()+";"+in.readShort()+";");
        System.out.println(+in.readInt()+";"+in.readLong());
        System.out.println(in.readFloat()+";"+in.readDouble()+";");
        System.out.println(in.readUTF()); in.close();*/

    }
}
