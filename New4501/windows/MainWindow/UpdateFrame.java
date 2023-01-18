package MainWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.TextField;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;

public class UpdateFrame extends BaseFrame {

	private JButton jbClose;
	private JTextField jtContents;
	private JTextField jtTitle;
	private JButton jbUpdate;
	private JButton jbDelete;

	public UpdateFrame() {

		super.SetFrame("UpdateTable", 400, 500);

	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbUpdate = new JButton("수정");
		jbDelete = new JButton("삭제");
		jbClose = new JButton("닫기");
		
		jtContents = new JTextField();
		jtTitle = new JTextField();

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpTop.setGrid(1, 3, 10, 10).add(new JTextField());
		jpTop.add(new JPanel());
		jpTop.add(new JTextField());

		jpCenter.addCild();
		jpCenter.jpTop.add(jtTitle);
		jpCenter.jpCenter.add(jtContents);
		
		jpBottom.setFlow().add(jbUpdate);
		jpBottom.setFlow().add(jbDelete);
		jpBottom.setFlow().add(jbClose);
		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub

	}

}
