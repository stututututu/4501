package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import base.comp.BaseFrame;
import Db.DbManager;

public class JoinFrame extends BaseFrame {

	private JLabel jlId;
	private JLabel jlName;
	private JLabel jlPw;
	private JLabel jlPwCheck;
	private JTextField jtId;
	private JTextField jtName;
	private JTextField jtPw;
	private JTextField jtPwCheck;
	private JButton jbJoin;
	private JPanel jpCenter;
	private JPanel jpCleft;
	private JPanel jpCright;
	private JPanel jpBottom;
	private DbManager db;
	private Vector<Vector<Object>> userData;

	public JoinFrame() {
		// TODO Auto-generated constructor stub
		super.setFrame("joinFrame", 300, 290);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jpCenter = new JPanel();
		jpCleft = new JPanel(new GridLayout(4, 1, 10, 30));
		jpCright = new JPanel(new GridLayout(4, 1, 10, 10));

		jpBottom = new JPanel();

		jlId = new JLabel("아이디");
		jlName = new JLabel("닉네임");
		jlPw = new JLabel("비밀번호");
		jlPwCheck = new JLabel("비밀번호 확인");

		jtId = new JTextField();
		jtName = new JTextField();
		jtPw = new JTextField();
		jtPwCheck = new JTextField();

		jbJoin = new JButton("회원가입");
	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpCright.setPreferredSize(new Dimension(180, 180));
		jbJoin.setPreferredSize(new Dimension(250, 50));

		jpCleft.add(jlId);
		jpCleft.add(jlName);
		jpCleft.add(jlPw);
		jpCleft.add(jlPwCheck);

		jpCright.add(jtId);
		jpCright.add(jtName);
		jpCright.add(jtPw);
		jpCright.add(jtPwCheck);

		jpCenter.add(jpCleft, BorderLayout.WEST);
		jpCenter.add(jpCright, BorderLayout.EAST);

		jpBottom.add(jbJoin);

		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpBottom, BorderLayout.SOUTH);

	}

	@Override
	public void events() {
		// TODO Auto-generated method stub

		db = new DbManager();

		jbJoin.addActionListener(e -> {
			String id = jtId.getText();
			String Name = jtName.getText();
			String Pw = jtPw.getText();
			String PwChek = jtPwCheck.getText();
			
			userData = db.getData("SELECT * FROM `4501`.`member` where `id` = ?;", id);
			
//			if (userData.size() != 0) {
//				System.out.println("아이디 중복");
//					
//					
//				super.dispose();
//				
//			}
//			else if (Pw == PwChek) {
//				System.out.println("비밀번호 확인 완료");
//				
//				db.setUpdate("INSERT INTO `4501`.`member` (`id`, `name`, `pw`) VALUES ('" + id + "', '" + Name + "', '" + Pw
//						+ "');");
//				System.out.println("가입 완료");
//			}
			if (userData.size() != 0) {
				System.out.println("아이디 중복");
					
					
				super.dispose();
				return;
			}
			
//			if (Pw != PwChek) {
//				System.out.println("비밀번호 아님");
//				return;
//			}
			if (!Pw.equals(PwChek)) {
				System.out.println("비밀번호 아님");
				return;
			}

			System.out.println("비밀번호 확인 완료");

			db.setUpdate("INSERT INTO `4501`.`member` (`id`, `name`, `pw`) VALUES ('" + id + "', '" + Name + "', '" + Pw
					+ "');");
			System.out.println("가입 완료");
			
			new LoginFrame();
			dispose();
			
		});

	}

}
