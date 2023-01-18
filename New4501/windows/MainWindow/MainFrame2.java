package MainWindow;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Base.Comp.BaseFrame;
import Base.Comp.BasePanel;
import Db.DbManager;
import MainWindow.ShowFrame;

public class MainFrame2 extends BaseFrame {

	private JTabbedPane jTab;
	private JPanel jpTbutton;
	private JButton jbTabBottom;
	private JButton jbTabTop;
	private DbManager db;
	private Vector<Vector<String>> data;
	private DefaultTableModel dtm;
	private JTable table;
	private JScrollPane scroll;
	private JPanel jpTbutton2;
	private JButton jbTabBottom2;
	private JButton jbTabTop2;

	private JPanel jpTop2;
	private JLabel jlWelcome;

	public MainFrame2() {
		db = new DbManager();
		// TODO Auto-generated constructor stub
		super.SetFrame("4501", 400, 500);
	}

	@Override
	public void setComp() {
		// TODO Auto-generated method stub
		// 탭1
		jTab = new JTabbedPane();
		jpTbutton = new BasePanel().setGrid(2, 1, 10, 10);
//		jpTbutton = new JPanel(new GridLayout(2, 1, 10, 10));
		jbTabTop = new JButton("로그인");
		jbTabBottom = new JButton("회원가입");
		// 탭2
		jpTop2 = new JPanel();
		jpTbutton2 = new JPanel(new GridLayout(2, 1, 10, 10));
		jbTabTop2 = new JButton("로그아웃");
		jbTabBottom2 = new JButton("글쓰기");
		jlWelcome = new JLabel("환영합니다", JLabel.CENTER);

		// 테이블
		Vector<String> cols = new Vector<>();
		cols.add("번호");
		cols.add("닉네임");
		cols.add("제목");
		cols.add("내용");
		cols.add("날짜");
		data = db.getData("SELECT * FROM `4501`.list;");
		dtm = new DefaultTableModel(data, cols);

		
//		System.out.println(data.size());
		table = new JTable(dtm);
		scroll = new JScrollPane(table);

	}

	@Override
	public void setDesign() {
		// TODO Auto-generated method stub
		jpTbutton.add(jbTabTop);
		jpTbutton.add(jbTabBottom);
		
		jpTbutton2.add(jbTabTop2);
		jpTbutton2.add(jbTabBottom2);
		// 탭 1

		// 탭2
		super.add(jTab, BorderLayout.NORTH);
		jpTop2.add(new JLabel("GHAS게시판"), BorderLayout.WEST);
		jpTop2.add(jpTbutton2, BorderLayout.EAST);
		jpTop2.add(jlWelcome, BorderLayout.SOUTH);

		
		jpTop.addCild();
		jpTop.jpRight.add(jpTbutton);
		jpTop.jpLeft.add(new JLabel("GHAS게시판"));
		jpTop.jpBottom.add(new  JLabel("로그인하세요"), JLabel.CENTER);

		
		
		
		jTab.addTab("1", jpTop);
		jTab.addTab("2", jpTop2);

		
		//		jpTop.add(jTab);
		super.add(jTab, BorderLayout.NORTH);

		jpCenter.add(scroll);
		super.add(jpCenter, BorderLayout.CENTER);
//		super.add(jpCenter);

	}

	@Override
	public void events() {
		// TODO Auto-generated method stub
		
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				int seletRow = table.getSelectedRow();
				Vector<String> list = data.get(seletRow);
//				new ShowFrame();
				
				new UpdateFrame();
			}
			
		});
		
//		jbTabTop.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			@Override
//			public void mouseClicked(MouseEvent e, int b) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
//		table.addActionListener(e, x -> {
//			new LoginFrame();
//			
//		});
		
//		// 자바 문법 : 람다식 사용하는 것.
//		jbTabTop.addActionListener(new WW());
//		jbTabBottom.addActionListener(this);
		
		// 익명 클래스 사용한다.		
		jbTabTop.addActionListener(e -> {
			new LoginFrame();
			
		});
		
		jbTabBottom.addActionListener(e -> {
			new SigninFrame();
		});
		jbTabBottom2.addActionListener(e -> {
			new WritingFrame();
		});

	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}

}

//class WW implements ActionListener{
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println("ss");
////		if(e.getActionCommand().)
//	}
//	
//}
