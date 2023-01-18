package MainWindow;

import java.awt.BorderLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Base.Comp.BaseFrame;

public class LoginFrame extends BaseFrame{

	private JButton jbLog;

	public LoginFrame() {
		// TODO Auto-generated constructor stub
		super.SetFrame("Login", 300, 200);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jbLog = new JButton("로그인");
		
	}

	@Override
	public void setDesign() {

		jpCenter.setGrid(2, 2, 10, 10).add(new JLabel("아이디"));
		jpCenter.add(new JTextField());
		jpCenter.add(new JLabel("비밀번호"));
		jpCenter.add(new JTextField());
		jpBottom.add(jbLog);
		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		
	}

}
