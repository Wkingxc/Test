package thread;

public class AccountTest {
    //不使用线程同步机制，多线程对同一个账户进行取款，出现线程安全问题。
    public static void test01()
    {
        Account act = new Account("001",6000);
        Thread t1 = new AccountThread(act);
        Thread t2 = new AccountThread(act);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    public static void main(String[] args) {
        test01();
    }
}
class Account
{
    private String name;
    private double money;
    Object obj = new Object();
    Account(String name,double money)
    {
        this.name = name;
        this.money = money;
    }
    public void setMoney(double money)
    {
        this.money = money;
    }
    //以下几行代码必须是线程排队的，不能并发
    /*
    线程同步机制的语法是：
           synchronize(){
                线程同步代码块
           }
     synchronize后小括号中传的这个“数据”必须是多线程共享的数据，才能达到多线程排队
     */
    public void withdraw(double money)
    {
        synchronized (this)
        {
            double before = getMoney();
            double after = before - money;
            //模拟网络延迟，100%会出问题
            try {
                Thread.sleep(1000);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
            setMoney(after);
        }

    }
    public double getMoney()
    {
        return money;
    }
    public String getName(){return name;}
}
class AccountThread extends Thread
{
    private Account act;
    AccountThread(){}
    AccountThread(Account account)
    {
        act = account;
    }
    @Override
    public void run() {
        act.withdraw(3000);
        System.out.println("取款成功！"+"余额-->"+act.getMoney());
    }
}

