package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.DefaultMenuLayout;

import Db.DbManager;
import base.comp.BaseFrame;

public class LoginFrame extends BaseFrame {

	private JLabel jlId;
	private JLabel jlPw;
	private JTextField jtId;
	private JTextField jtPw;
	private JButton jbLogin;
	private JPanel jpTright;
	private JPanel jpTleft;
	private JPanel jpBottom;
	private JPanel jpTop;
	private DbManager db;
	private Vector<Vector<Object>> data;
	private String id;
	private Vector<Vector<Object>> dataPw;
	private String pw;
	private JButton jbMainLogin;

	public LoginFrame() {
		// TODO Auto-generated constructor stub
		super.setFrame("loginFrame", 300, 160);

	}

	public LoginFrame(JButton jbLogin) {
		// TODO Auto-generated constructor stub
		this.jbMainLogin = jbLogin;
		
		
		super.setFrame("loginFrame", 300, 160);
		
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		db = new DbManager();

		jpTop = new JPanel();

		jpTleft = new JPanel(new GridLayout(2, 1, 0, 20));
		jpTright = new JPanel(new GridLayout(2, 1, 0, 10));

		jpBottom = new JPanel();

		jlId = new JLabel("아이디");
		jlPw = new JLabel("비밀번호");

		jtId = new JTextField();
		jtPw = new JTextField();

		jbLogin = new JButton("로그인");

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stud
		jpTright.setPreferredSize(new Dimension(200, 70));

		jbLogin.setPreferredSize(new Dimension(250, 30));

		jpTop.add(jpTleft, BorderLayout.WEST);
		jpTop.add(jpTright, BorderLayout.EAST);

		jpTleft.add(jlId);
		jpTleft.add(jlPw);

		jpTright.add(jtId);
		jpTright.add(jtPw);

		jpBottom.add(jbLogin);

		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpBottom, BorderLayout.SOUTH);

		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub

		jbLogin.addActionListener(e -> {
			id = jtId.getText();
			pw = jtPw.getText();
			
			// select * from 테이블 where 조건1 and 조건2;
			//data = db.getData("SELECT * FROM `4501`.`member` where `id` = ?;", id);
			//dataPw = db.getData("SELECT * FROM `4501`.`member` where `pw` = ?;", pw);
//			if (data.size() == 0) {
//				System.out.println("아이디 없음");
//				dispose();
//				new loginFrame();
//				
//			}
//			if (dataPw.size() == 0) {
//				System.out.println("비밀번호 틀림");
//				
//				return;
//			}
//
//			new LogMainFrame();
//			dispose();

			
//			data = db.getData("SELECT * FROM `4501`.`member` where `id` = ? and pw = ?;", id,pw);
// 이중조건 sql문 이용하기
			
//			data = db.getData("SELECT * FROM `4501`.`member` where `id` = ?;", id);
//			
//			if (data.size() == 0) {
//				System.out.println("아이디 없음");
//
//				
//			}
//			if (!data.get(0).get(3).equals(pw)) {
//				System.out.println("비밀번호 틀림");
//				
//				return;
//			}
			data = db.getData("SELECT * FROM `4501`.`member` where `id` = ? and pw = ?;", id, pw);
			
			if (data.size() == 0) {
				System.out.println("로그인 할 수 없습니다.");
				return;				
			}
			jbMainLogin.setText("로그아웃");
//			new LogMainFrame();
			dispose();
		});
	}

}
