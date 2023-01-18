package MainWindow;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Base.Comp.BaseFrame;
import Db.DbManager;

public class SigninFrame extends BaseFrame {

	private JButton jbSignin;
	private MainFrame mainFrame;
	private JTextField jtId;
	private JPasswordField jpPw;
	private JPasswordField jpPw1;
	private JTextField jtNick;

	public SigninFrame() {
		// TODO Auto-generated constructor stub
		this.mainFrame = mainFrame;
		super.SetFrame("signin", 300, 400);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbSignin = new JButton("화원가입");
		jtId = new JTextField();
		jtNick = new JTextField();
		jpPw = new JPasswordField();
		jpPw1 = new JPasswordField();
	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpCenter.setGrid(4, 2, 10, 10).add(new JLabel("아이디"));
		jpCenter.add(jtId);
		jpCenter.add(new JLabel("닉네임"));
		jpCenter.add(jtNick);
		jpCenter.add(new JLabel("비밀번호"));
		jpCenter.add(jpPw);
		jpCenter.add(new JLabel("비밀번호 확인"));
		jpCenter.add(jpPw1);
		jpBottom.add(jbSignin);
//		super.add(jpCenter, BorderLayout.CENTER);
//		super.add(jpBottom, BorderLayout.SOUTH);
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		DbManager db = new DbManager();
		
		jbSignin.addActionListener(e -> {
			
			String id = jtId.getText();
			String nick = jtNick.getText();
			String pw = jpPw.getText();
			String pw1 = jpPw1.getText();
			
			
			Vector<Vector<String>> idCheckData = db.getData("select * from member where id = ?", id);
			if(idCheckData.size() != 0) {
				JOptionPane.showMessageDialog(null, "아이디 중복", "정보", JOptionPane.ERROR_MESSAGE);
				jtId.setText("");
				jtId.requestFocus();
				return;
			}
			
			
			Vector<Vector<String>> nickCheckData = db.getData("select * from member where name = ?", nick);
			if(nickCheckData.size() != 0) {
				JOptionPane.showMessageDialog(null, "닉네임 중복", "정보", JOptionPane.ERROR_MESSAGE);
				jtNick.setText("");
				jtNick.requestFocus();
				return;
			}
			
			if(!pw.equals(pw1)) {
				JOptionPane.showMessageDialog(null, "비번 서로 다름", "정보", JOptionPane.ERROR_MESSAGE);
				jpPw.setText("");
				jpPw1.setText("");
				jpPw.requestFocus();
				return;
			}
			
			
			db.setData("INSERT INTO `4501`.`member` (`id`, `name`, `pw`) VALUES (?, ?, ?);",
				id, nick, pw);
		});
		
		
	}

}
