package base.comp;

import javax.swing.JFrame;


import base.iDesign;

public abstract class BaseFrame extends JFrame implements iDesign {


	public void setFrame(String title,int w ,int d) {
		// TODO Auto-generated constructor stub
		setComp();
		setDesign();
		events();
		
		super.setTitle(title);
		super.setSize(w,d);
		
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setVisible(true);
	}
	
	public void refresh() {
		super.repaint();
		super.validate();
		
	}

}
