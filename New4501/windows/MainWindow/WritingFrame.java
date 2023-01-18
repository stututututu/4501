package MainWindow;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;

public class WritingFrame extends BaseFrame{

	private JButton jbClose;
	private JButton jbSave;

	public WritingFrame() {
		// TODO Auto-generated constructor stub
		super.SetFrame("writing", 400, 500);
	}

	public void setComp() {
		// TODO Auto-generated method stub
		jbClose = new JButton("닫기");
		jbSave = new JButton("저장");

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpTop.setGrid(1, 3, 10, 10).add(new JTextField());
		jpTop.add(new JPanel());
		jpTop.add(new JTextField());

		jpCenter.addCild();
		jpCenter.jpTop.add(new JTextField());
		jpCenter.jpCenter.add(new JTextField());
		
		jpBottom.setFlow().add(jbSave);
		jpBottom.add(jbClose);

//		super.add(jpTop, BorderLayout.NORTH);
//		super.add(jpCenter, BorderLayout.CENTER);
//		super.add(jpBottom, BorderLayout.SOUTH);

	}

	@Override
	public void events() {
		// TODO Auto-generated method stub

	}

}