package thread;

public class ThreadTest01 {
    /*
    一、线程实现方式：
    1、创建一个类继承Thread
    2、面向接口编程，利用Thread的构造方法传入一个实现Runable接口的类
    二、方法：
    1、Thread.sleep(ms) 静态方法
    2、t.interrupt()-->唤醒睡眠-->原理:让sleep抛出异常
    3、stop()  强行结束线程-->已弃用
    4、合理结束线程：
        -->在线程类中设置一个布尔类型标记，只有为true时，run方法才会执行
    5、thread1.setPriority(int)
        -->设置线程优先级（1-10，默认5）
    6、Thread.yield() 静态方法
        -->让位，让当前线程回到就绪状态，让给其他线程
    7、t.join()
        -->t合并到当前线程中，当前线程受阻，直到t线程执行结束
        -->不是栈合并，只是当前线程进入等待
     */
    public void test01()
    {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        thread1.start();
        for (int i = 1; i <= 3; i++)
        {
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        myThread.run = false;

    }
    public static void main(String[] args) {
        ThreadTest01 tt = new ThreadTest01();
        tt.test01();
    }
}
class MyThread implements Runnable
{
    boolean run = true;
    @Override
    public void run() {
            try {
                for (int i   = 1; i < 100000; i++)
                {
                    if(run)
                    {
                        System.out.print(i+" ");
                        Thread.sleep(1000);
                    }
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            System.out.println("over");
    }
}
