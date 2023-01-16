/**
 * 
 */
package window.Table;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Db.DbManager;
import base.comp.BaseFrame;

/**
 * @author KJW
 *
 */
public class showTableFrame extends BaseFrame {

	private JTextField jtName;
	private JTextField jtDate;
	private JTextField jtContents;
	private JButton jbClose;
	private JPanel jpTop;
	private JPanel jpTnull;
	private JPanel jpCenter;
	private JPanel jpBottom;
	private JTextField jtTitle;
	private DbManager db;
	private Vector<Object> list;



	public showTableFrame(Vector<Object> list) {
		this.list = list;
		super.setFrame("Wirting", 500, 420);

		
	}


	@Override
	public void setComp() {
		db = new DbManager();
		// TODO Auto-generated method stub
		jpTop = new JPanel(new FlowLayout());
		jpTnull = new JPanel();
		jpCenter = new JPanel();
		jpBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		jtTitle = new JTextField(list.get(2) + "");
		jtTitle.setEnabled(false);
		jtName = new JTextField();
		jtName.setEnabled(false);
		jtDate = new JTextField();
		jtDate.setEnabled(false);
		jtContents = new JTextField(list.get(3)+ "");
		jtContents.setEnabled(false);

		jbClose = new JButton("닫기");
	}

	@Override
	public void setDesign() {
//		title = db.getData("SELECT * FROM `4501`.list WHERE (`writing_no` = ?);", writingnum);
//		jtTitle.setText(writingnum);

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

		jpBottom.add(jbClose);

		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpBottom, BorderLayout.SOUTH);
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub

		jbClose.addActionListener(e -> {
			dispose();
		});
	}

}
