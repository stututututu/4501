package window.Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Db.DbManager;
import base.comp.BaseFrame;
import window.LogMainFrame;

public class WritingFrame extends BaseFrame {

	private JTextField jtName;
	private JTextField jtDate;
	private JTextField jtContents;
	private JButton jbSave;
	private JButton jbClose;
	private JPanel jpTop;
	private JPanel jpTnull;
	private JPanel jpCenter;
	private JPanel jpBottom;
	private JTextField jtTitle;
	private String contents;
	public String title;
	private DbManager db;
	DefaultTableModel tableDtm;
	private LogMainFrame logMainFrame;

	public WritingFrame(LogMainFrame logMainFrame) {
		// TODO Auto-generated constructor stub
		this.logMainFrame = logMainFrame;
		db = new DbManager();

		super.setFrame("Wirting", 500, 420);
	}



	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jpTop = new JPanel(new FlowLayout());
		jpTnull = new JPanel();
		jpCenter = new JPanel();
		jpBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		jtTitle = new JTextField("제목");
		jtName = new JTextField("작성자");
		jtDate = new JTextField("작성일");
		jtContents = new JTextField();

		jbSave = new JButton("저장");
		jbClose = new JButton("닫기");
	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jtName.setPreferredSize(new Dimension(100, 30));
		jpTnull.setPreferredSize(new Dimension(200, 30));
		jtDate.setPreferredSize(new Dimension(100, 30));
		jtTitle.setPreferredSize(new Dimension(450, 30));
		jtContents.setPreferredSize(new Dimension(450, 300));

		jpTop.add(jtName);
		jpTop.add(jpTnull);
		jpTop.add(jtDate);

		jpCenter.add(jtTitle, BorderLayout.NORTH);
		jpCenter.add(jtContents, BorderLayout.CENTER);

		jpBottom.add(jbSave);
		jpBottom.add(jbClose);

		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpBottom, BorderLayout.SOUTH);
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jbSave.addActionListener(e -> {
			
			title = jtTitle.getText();
			contents = jtContents.getText();
			
			
			db.setUpdate("INSERT INTO `4501`.`list` (`title`, `contents`) VALUES ( ?, ?);\r\n"
					+ "", title, contents);
			tableDtm.getDataVector().clear();
			tableDtm.getDataVector().addAll(db.getData("SELECT * FROM `4501`.list;"));
			logMainFrame.tableRefresh();
		});

		jbClose.addActionListener(e -> {
			dispose();
		});
	}

}
