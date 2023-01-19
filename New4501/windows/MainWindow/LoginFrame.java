package MainWindow;

import java.awt.BorderLayout;
import java.awt.Label;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;
import Db.DbManager;
import model.UserModel;

public class LoginFrame extends BaseFrame {

	private JButton jbLog;
	private DbManager db;
	private JTextField jtId;
	private JPasswordField jtPw;
	private String id;
	private String Pw;
	private MainFrame mainFrame;
	private Vector<String> userName;

	public LoginFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		super.SetFrame("Login", 300, 200);
		db = new DbManager();

	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbLog = new JButton("로그인");
		jtId = new JTextField();
		jtPw = new JPasswordField();

	}

	@Override
	public void setDesign() {

		jpCenter.setGrid(2, 2, 10, 10).add(new JLabel("아이디"));
		jpCenter.add(jtId);
		jpCenter.add(new JLabel("비밀번호"));
		jpCenter.add(jtPw);
		jpBottom.add(jbLog);

	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jbLog.addActionListener(e -> {
			id = jtId.getText();
			Pw = jtPw.getText();
			

			System.out.println("아이디" + id);
			System.out.println("비번" + Pw);
			Vector<Vector<String>> idCheck = db.getData("select * from member where id = ?", id);
			if (idCheck.size() == 0) {
				JOptionPane.showMessageDialog(null, "아이디 없음", "경고", JOptionPane.ERROR_MESSAGE);
				jtId.setText("");
				jtId.requestFocus();
				return;
			}
			Vector<Vector<String>> pwCheck = db.getData("select * from member where pw = ?", Pw);
			if (pwCheck.size() == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호 없음", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			UserModel.u_id = id;
			UserModel.u_pw = Pw;

			UserModel.logstate = true;
			mainFrame.login();

			dispose();

		});

	}

}
