package graph;

import layout.*;
import layout.GroupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by novas on 2016/2/6.
 */
public class mainframe extends JFrame
{
    int width=1000;
    int height=800;
    public mainframe()
    {

        DataModel dataModel=new DataModel();
        this.setLayout(null);
       // DataModel dataModel=new DataModel();
       // this.setLayout(new ScrollPaneLayout());
        chart chart=new chart(width,height);
        JInternalFrame tablepanel=new paramtable(dataModel,width,height);
        Table_Model model=new Table_Model(dataModel.getTableNodeArray());
        JTable table=new JTable(model);

        JScrollPane jScrollPane=new JScrollPane(table);

        this.getContentPane().add(chart);
        this.getContentPane().add(tablepanel);
        this.setVisible(true);
        this.setSize(width,800);
    }
}
