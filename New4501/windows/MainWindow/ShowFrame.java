package MainWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.TextField;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;
import model.UserModel;

public class ShowFrame extends BaseFrame {

	private JButton jbClose;
	private JTextField jtContents;
	private JTextField jtTitle;
	private JTextField jtName;
	private JTextField jtDate;
	private Vector<String> listData;
	private Vector<String> memberData;

	public ShowFrame(Vector<String> list, Vector<String> user) {
		listData = list;
		memberData = user;
		super.SetFrame("ShowTable", 400, 500);

	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbClose = new JButton("닫기");
		jtName = new JTextField(memberData.get(2));
		jtDate = new JTextField();
		jtContents = new JTextField(listData.get(3));
		jtTitle = new JTextField(listData.get(2));

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpTop.setGrid(1, 3, 10, 10).add(jtName);
		jpTop.add(new JPanel());
		jpTop.add(jtDate);

		jpCenter.addCild();
		jpCenter.jpTop.add(jtTitle);
		jpCenter.jpCenter.add(jtContents);
		
		jpBottom.setFlow().add(jbClose);
		
		jtTitle.setEnabled(false);
		jtContents.setEnabled(false);
		jtDate.setEnabled(false);
		jtName.setEnabled(false);
		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jbClose.addActionListener(e -> {
			dispose();
		});

	}

}
