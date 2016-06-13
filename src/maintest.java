import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by novas on 16/3/12.
 */
public class maintest
{
    public static void main(String[] args)
    {
        String sdf=new SimpleDateFormat("yyyy-MM-dd HH-s:SSS").format(new Date());
        System.out.println(sdf);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,2016);
        calendar.set(Calendar.WEEK_OF_YEAR,11);
        calendar.set(Calendar.DAY_OF_WEEK,7);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
    }
}
