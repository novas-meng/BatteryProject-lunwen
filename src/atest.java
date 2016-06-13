import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by novas on 16/2/11.
 */
public class atest {
    public static void main(String[] args)throws Exception
    {
        ArrayList<Double> waveList=new ArrayList<Double>();
        ArrayList<Double> reslist=new ArrayList<Double>();
        ArrayList<Double> datareslist=new ArrayList<Double>();
        BufferedReader br=new BufferedReader(new FileReader("orig.txt"));
        String line=br.readLine();
        while (line!=null)
        {
            String[] as=line.split("\t");
            waveList.add(Double.parseDouble(as[0]));
            reslist.add(Double.parseDouble(as[as.length-1]));
            line=br.readLine();
        }
        double[] waves=new double[waveList.size()];
        double[] res=new double[waves.length];
        for(int i=0;i<waveList.size();i++)
        {
            waves[i]=waveList.get(i);
        }
        for(int i=0;i<reslist.size();i++)
        {
            res[i]=waveList.get(i);
        }
        double[] data=new double[waves.length];
        int count=0;
        br=new BufferedReader(new FileReader("origafter.txt"));
        line=br.readLine();
        while (line!=null)
        {
            String[] as=line.split(" ");
            data[count]=Double.parseDouble(as[as.length-1]);
            count++;
            line=br.readLine();
        }
        double[] plain=new double[data.length];
        count=0;
        br=new BufferedReader(new FileReader("oriplain.txt"));
        line=br.readLine();
        while (line!=null)
        {
            String[] as=line.split(" ");
            plain[count]=Double.parseDouble(as[as.length-1]);
            count++;
            line=br.readLine();
        }
        for(int i=0;i<plain.length;i++)
        {
            System.out.println(plain[i]);
        }
    }
}
