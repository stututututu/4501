package MainWindow;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;
import Db.DbManager;

public class WritingFrame extends BaseFrame{

	private JButton jbClose;
	private JButton jbSave;
	private JTextField jtContents;
	private JTextField jtTitle;
	private JTextField jtdate;
	private JTextField jtName;
	private String title;
	private String contents;
	private DbManager db;
	private MainFrame mainFrame;

	public WritingFrame(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		super.SetFrame("writing", 400, 500);
		db = new DbManager();
	}

	public void setComp() {
		// TODO Auto-generated method stub
		jbClose = new JButton("닫기");
		jbSave = new JButton("저장");
		jtName = new JTextField();
		jtdate= new JTextField();
		jtTitle = new JTextField();
		jtContents = new JTextField();
		

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpTop.setGrid(1, 3, 10, 10).add(jtName);
		jpTop.add(new JPanel());
		jpTop.add(jtdate);

		jpCenter.addCild();
		jpCenter.jpTop.add(jtTitle);
		jpCenter.jpCenter.add(jtContents);
		
		jpBottom.setFlow().add(jbSave);
		jpBottom.add(jbClose);

//		super.add(jpTop, BorderLayout.NORTH);
//		super.add(jpCenter, BorderLayout.CENTER);
//		super.add(jpBottom, BorderLayout.SOUTH);

	}

	@Override
	public void events() {
		title = jtTitle.getText();
		contents = jtContents.getText();
 
		jbSave.addActionListener(e -> {
			db.setData("INSERT INTO `4501`.`list` (`title`, `contents`) VALUES (?, ?);", title, contents);
			System.out.println("write succeed");
			mainFrame.tableRefresh();
		});
		
		jbClose.addActionListener(e -> {
			dispose();
		});
	}

}