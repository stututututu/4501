package MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Base.Comp.BaseFrame;
import Base.Comp.BasePanel;
import Db.DbManager;

public class MainFrame extends BaseFrame {

	private JLabel jlLogin;
	private JButton jbLogin;
	private JButton jbJoin;
	private JButton jbLogout;
	private JButton jbWrite;
	private BasePanel jpLogin;
	private DbManager db;
	private Vector<Vector<String>> data;
	private DefaultTableModel dtm;
	private JTable jTable;
	private JScrollPane jsp;
	private BasePanel jpLogout;

	public MainFrame() {
		db = new DbManager();
		// TODO Auto-generated constructor stub
		super.SetFrame("4501", 400, 500);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		jlLogin = new JLabel("로그인하세요.");
		jbLogin = new JButton("로그인");
		jbJoin = new JButton("회원가입");
		jbLogout = new JButton("로그아웃");
		jbWrite = new JButton("글쓰기");
	
		jpLogin = new BasePanel().setGrid(2, 1);
		jpLogout = new BasePanel().setGrid(2, 1);
		
		Vector<String> cols = new Vector<String>();
		cols.add("번호");
		cols.add("닉네임");
		cols.add("제목");
		cols.add("내용");
		cols.add("날씨");
		
		data = db.getData("select * from list");
		
		dtm = new DefaultTableModel(data, cols);
		jTable = new JTable(dtm);
		jsp = new JScrollPane(jTable);
		
	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		super.jpTop.addCild();
		super.jpTop.jpCenter.add(new JLabel("GHAS 게시판"));
		super.jpTop.jpBottom.add(jlLogin);
	
		jpLogout.add(jbLogin);
		jpLogout.add(jbJoin);

		jpLogin.add(jbLogout);
		jpLogin.add(jbWrite);

		logout();
		
		super.jpTop.jpBottom.add(jlLogin);
		
		super.jpCenter.add(jsp);
		
		
	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		jTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
//				new ShowFrame();
//				new WritingFrame();
				new UpdateFrame();
			}
		});
		
		jbLogin.addActionListener(e -> {
			new LoginFrame();
		});
		
		jbJoin.addActionListener(e -> {
			new SigninFrame();
		});

		jbLogout.addActionListener(e -> {
			logout();
		});
		jbWrite.addActionListener(e -> {
//			new WritingFrame();
		});
		
		
		
	}

	private void logout() {
		// TODO Auto-generated method stub
		super.jpTop.jpRight.removeAll();
		super.jpTop.jpRight.add(jpLogout);
		
		
		super.reFresh();
	}

	public void login() {
		// TODO Auto-generated method stub
		super.jpTop.jpRight.removeAll();
		super.jpTop.jpRight.add(jpLogin);
		
		super.reFresh();
	}
}


// 1. 중간중간 최소 뭔가 쓰면 계속 테스트 해본다.
//		-> 내가 원하는 대로 나오는지.
//			-> 내가 원하는대로 안나온다 -> 내가 생각하는게 다름.	-> 잠깐 쉬고, 생각 정리. 어떤 식으로 만들지.
//				-> 기존에 만들었던 곳이 문제임.	-> 분석.
// 2. 프로젝트 2~3개 정도? -> 능숙 -> 단위를 높여 테스트한다.
// 3. 뭔가를 다하고나서 마지막에 테스트하는 행동 -> 절대 금지.
// 
