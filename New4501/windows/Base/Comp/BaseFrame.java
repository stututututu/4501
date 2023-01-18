package Base.Comp;

import java.awt.BorderLayout;

import javax.swing.JFrame;



import Design.IDesign;

public abstract class BaseFrame extends JFrame implements IDesign {
	public BasePanel jpCenter = new BasePanel();
	public BasePanel jpTop = new BasePanel();
	public BasePanel jpRight = new BasePanel();
	public BasePanel jpLeft = new BasePanel();
	public BasePanel jpBottom = new BasePanel();

	public void SetFrame(String title, int w, int d) {
		// TODO Auto-generated constructor stub
		setComp();
		setDesign();

		events();

		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpRight, BorderLayout.EAST);
		super.add(jpLeft, BorderLayout.WEST);
		super.add(jpBottom, BorderLayout.SOUTH);
		
		
		
		super.setTitle(title);
		super.setSize(w, d);

		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setVisible(true);

	}
	
	public void reFresh() {
		super.validate();
		super.repaint();
	}

}
	