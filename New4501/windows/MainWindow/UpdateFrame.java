package MainWindow;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.TextField;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;
import Db.DbManager;
import model.UserModel;

public class UpdateFrame extends BaseFrame {

	private JButton jbClose;
	private JTextField jtContents;
	private JTextField jtTitle;
	private JButton jbUpdate;
	private JButton jbDelete;
	private JTextField jtName;
	private JTextField jtDate;
	private Vector<String> listData;
	private Vector<String> memberData;
	private DbManager db;
	private String title;
	private String contents;

	public UpdateFrame(Vector<String> list, Vector<String> user) {
		
		db = new DbManager();
		super.SetFrame("UpdateTable", 400, 500);
		listData = list;
		memberData = user;
		
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbUpdate = new JButton("수정");
		jbDelete = new JButton("삭제");
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
		
		jpBottom.setFlow().add(jbUpdate);
		jpBottom.setFlow().add(jbDelete);
		jpBottom.setFlow().add(jbClose);
		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jbUpdate.addActionListener(e -> {
		
			contents = jtContents.getText();
			db.setData("UPDATE `4501`.`list` SET `title` = ?, `contents` = ? WHERE (`title` = ?);\r\n", listData.get(0),title,contents);
		});
		jbDelete.addActionListener(e -> {
			title = jtTitle.getText();
			db.setData("DELETE FROM `4501`.`list` WHERE (`title` = ?);\r\n", title);
		});

	}

}
