package window.Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.desktop.UserSessionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Db.DbManager;
import base.comp.BaseFrame;
import window.LogMainFrame;

public class UpDelFrame extends BaseFrame {

	private Vector<Object> userlist;
	private JPanel jpTop;
	private JPanel jpTnull;
	private JPanel jpCenter;
	private JPanel jpBottom;
	private JTextField jtName;
	private JTextField jtDate;
	private JTextField jtContents;
	private JButton jbUpdate;
	private JButton jbClose;
	private JTextField jtTitle;
	private DbManager db;
	private String Title;
	private String Contents;
	private JButton jbDel;
	private LogMainFrame logMainFrame;
	private Vector<Object> list;

	public UpDelFrame(LogMainFrame logMainFrame, Vector<Object> list) {
		this.logMainFrame = logMainFrame;
		db = new DbManager();
		// TODO Auto-generated constructor stub
		super.setFrame("Update,Delete", 500, 420);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		jpTop = new JPanel(new FlowLayout());
		jpTnull = new JPanel();
		jpCenter = new JPanel();
		jpBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		jtTitle = new JTextField(list.get(2)+ "");
		jtName = new JTextField(userlist.get(2) + "");
		jtDate = new JTextField("작성일");
		jtContents = new JTextField(list.get(3)+ "");

		jbUpdate = new JButton("수정");
		jbDel = new JButton("삭제");

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

		jpBottom.add(jbUpdate);
		jpBottom.add(jbDel);
		jpBottom.add(jbClose);

		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpBottom, BorderLayout.SOUTH);
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jbUpdate.addActionListener(e -> {

			Title = jtTitle.getText();
			Contents = jtContents.getText();
			db.setUpdate("UPDATE `4501`.`list` SET `title` = ?, `contents` = ? WHERE (`Title` = ?);", Title, Contents,
					Title);
			System.out.println("수정완료");

			logMainFrame.tableRefresh();

			super.dispose();

		});
		jbDel.addActionListener(e -> {
			db.setUpdate("DELETE FROM `4501`.`list` WHERE (`Title` = ?);", Title);
		});

		jbClose.addActionListener(e -> {
			dispose();
		});
	}

}