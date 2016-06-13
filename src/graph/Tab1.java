package graph;

import layout.GroupLayout;
import layout.LayoutStyle;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.text.View;


public class Tab1 extends JPanel {

	DataModel dataModel;
	chart chart;
	private JInternalFrame tablepanel;
	//private JFrame jFrame=new JFrame();
	//Container container=new Container();
    public Tab1(DataModel dataModel,int width,int height) {
		chart=new chart(width,height);
		tablepanel=new paramtable(dataModel,width,height);
		this.dataModel=dataModel;
	//	container.add(tablepanel);
		//container.setTitle("fa");
		//container.setSize(300,500);
	//	container.setVisible(true);
       // initComponents();
		this.setLayout(null);
		this.add(chart);
		this.add(tablepanel);
		this.setVisible(true);
		this.setSize(width,height);
        updateStatus();
    }
    private void initComponents() {

    	 GroupLayout layout = new GroupLayout(this);
    	 this.setLayout(layout);
    	 layout.setHorizontalGroup(
    	            layout.createParallelGroup(GroupLayout.LEADING)
    	            .add(layout.createSequentialGroup()
    	                .addContainerGap()
    	                .add(layout.createParallelGroup(GroupLayout.LEADING)
    	                    .add(layout.createSequentialGroup()
									// .add(12, 12, 12)
									.add(chart, 600, 700, 800)
									.addPreferredGap(LayoutStyle.RELATED))))
    	        );
    	 layout.setVerticalGroup(
 	            layout.createParallelGroup(GroupLayout.LEADING)
 	            .add(layout.createSequentialGroup()
 	                .addContainerGap()
 	                .add(layout.createParallelGroup(GroupLayout.LEADING)
 	                    .add(layout.createSequentialGroup()
								// .add(12, 12, 12)
								.add(chart, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.RELATED))))
 	        );
    }
    public void updateStatus() {
    
    }
}
