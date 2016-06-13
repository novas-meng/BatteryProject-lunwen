package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by novas on 2016/2/6.
 */
public class DataModel
{
    private tableNode[] tableNodes;
    public void initTableNodeArray()
    {
        String bianhao="B005";
        String xinghao="li";
        BufferedReader br=null;
        ArrayList<tableNode> list=new ArrayList<tableNode>();
        try {
            int count=0;
            br=new BufferedReader(new FileReader("B0005.txt"));
            String line=br.readLine();
            while (line!=null)
            {
                count++;
                list.add(new tableNode(bianhao,xinghao,count,line));
                line=br.readLine();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        tableNodes=new tableNode[list.size()];
        list.toArray(tableNodes);
    }
    public tableNode[] getTableNodeArray()
    {
        return tableNodes;
    }
}
class tableNode
{
    String bianhao;
    String xinghao;
    int zhouqi;
    String rongliang;
    public tableNode(String bianhao,String xinghao,int zhouqi,String rongliang)
    {
        this.bianhao=bianhao;
        this.xinghao=xinghao;
        this.zhouqi=zhouqi;
        this.rongliang=rongliang;
    }
    public Object get(int index)
    {
        switch (index)
        {
            case 0:
                return bianhao;
            case 1:
                return xinghao;
            case 2:
                return zhouqi;
            case 3:
                return rongliang;
            default:
                return null;
        }
    }
}