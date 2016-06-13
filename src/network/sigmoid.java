package network;

/**
 * Created by novas on 2016/2/4.
 */
public class sigmoid
{
    public static double sigmoid(double x)
    {
       // System.out.println("sigmod="+x+"   "+1.0/(1+Math.exp(x)));
        x=-x;
        return 1.0/(1+Math.exp(x)) ;
    }
    public static double purelin(double x)
    {
       // System.out.println("x="+x);
        return x;
      //  x=-x;
       // return 1.0/(1+Math.exp(0.8*x)) ;
    }
    public static double Dsigmoid(double x)
    {
        x=-x;
        return 2.0/(1+Math.exp(2*x))-1;
    }
}
