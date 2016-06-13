package graph;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * Created by novas on 2016/2/6.
 */
public class paramtable extends JInternalFrame
{
   int parentwidth;
   int parentheight;
   public paramtable(DataModel dataModel,int parentwidth,int parentheight)
   {
       this.parentwidth=parentwidth;
       this.parentheight=parentheight;
       Table_Model model=new Table_Model(dataModel.getTableNodeArray());
       JTable table=new JTable(model);

       JScrollBar scrollBar=new JScrollBar();
       JScrollPane jScrollPane=new JScrollPane(table);
       jScrollPane.setVerticalScrollBar(scrollBar);
       this.setTitle("���ͼ��");
       this.setBorder(null);
       this.setResizable(false);
       this.setFocusable(false );
       this.setBounds(20,parentheight/2+40,parentwidth/8*6,parentheight/3-40);
       this.add(jScrollPane);
       this.setVisible(true);
   }
}
class Table_Model extends AbstractTableModel
{

    String[] titlename={"���","�ͺ�","����","����"};
    tableNode[] data;
    public Table_Model(tableNode[] data)
    {
        this.data=data;
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int column) {
        return titlename[column];
    }

    @Override
    public int getColumnCount() {
        return titlename.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex].get(columnIndex);
    }
}
