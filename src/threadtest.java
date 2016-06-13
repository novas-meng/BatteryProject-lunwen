/**
 * Created by novas on 16/2/8.
 */
public class threadtest
{
    public static void main(String[] args)throws Exception
    {
        String A=new String("A");
        String B=new String("B");
        String C=new String("C");
        printRunnable printA=new printRunnable(A,B);
        printRunnable printB=new printRunnable(B,C);
        printRunnable printC=new printRunnable(C,A);
        Thread AT=new Thread(printA);
        Thread BT=new Thread(printB);
        Thread CT=new Thread(printC);
        AT.start();
        AT.sleep(100);
        BT.start();
        BT.sleep(100);
        CT.start();
        CT.sleep(100);
    }

}
class printRunnable implements Runnable
{
    String print;
    Object next;
    public printRunnable(String print,Object next)
    {
        this.print=print;
        this.next=next;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++)
        {
            synchronized (print)
            {
                synchronized (next)
                {
                    System.out.println(print);
                    next.notify();
                }
                try {
                    print.wait();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
