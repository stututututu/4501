package window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Db.DbManager;
import base.comp.BaseFrame;
import window.Table.showTableFrame;

public class MainFrame extends BaseFrame {

	private JPanel jpTop;
	private JPanel jpTeast;
	private JPanel jpCenter;
	private JPanel jpBottom;

	private JButton jbLogin;
	private JButton jbJoin;

	private JTable table;

	private JLabel jlGhas;
	private JLabel jlLogpls;
	private JScrollPane scroll;
	private Panel jpTwest;
	private DbManager db;
	private Vector<Vector<Object>> data;
	private DefaultTableModel dtm;

	public MainFrame() {
		// TODO Auto-generated constructor stub
		db = new DbManager();
		super.setFrame("4501", 500, 600);
	}

	public void setComp() {
		// TODO Auto-generated method stub
		jpTop = new JPanel();
		jpTeast = new JPanel(new GridLayout(2, 1, 10, 10));
		jpTwest = new Panel();
		jpCenter = new JPanel();
		jpBottom = new JPanel();

		jbLogin = new JButton("로그인");
		jbJoin = new JButton("회원가입");

		jlGhas = new JLabel("GHAS게시판");
		jlLogpls = new JLabel("로그인 하세요");

		Vector<String> cols = new Vector<>();
		cols.add("번호");
		cols.add("닉네임");
		cols.add("제목");
		cols.add("내용");
		cols.add("날짜");

		data = db.getData("SELECT * FROM `4501`.list;");
		dtm = new DefaultTableModel(data, cols);

		table = new JTable(dtm);
		scroll = new JScrollPane(table);

	}

	public void setDesign() {

		jpTwest.setPreferredSize(new Dimension(370, 70));
		jlGhas.setFont(new Font(" ", Font.CENTER_BASELINE, 50));

		jpTeast.add(jbLogin);
		jpTeast.add(jbJoin);
		jpTwest.add(jlGhas);
		jpTop.add(jpTwest, BorderLayout.WEST);
		jpTop.add(jpTeast, BorderLayout.EAST);

		jpCenter.add(jlLogpls);

		jpBottom.add(scroll);

		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpBottom, BorderLayout.SOUTH);
	}

	public void events() {
		// TODO Auto-generated method stub
		// 테이블 이벤트

//		data.get(0).get(2);
//		String num = String.valueOf(i);

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// System.out.println(table.getSelectedRow());
				if(MemberModel.loginMemeber != null) {
					int seletRow = table.getSelectedRow();
					Vector<Object> list = data.get(seletRow);
					new showTableFrame(list);
					
				}


			}

		});

		jbLogin.addActionListener(e -> {

//			if (jbLogin.getText().equals("로그인")) {
//				
//			}
//			if (jbLogin.getText().equals("로그아웃")) {
//				
//			}
//			
//			logRefresh();
////			
//			if(jbLogin.getText().equals("로그인"))
//				new LoginFrame(this);
//			else {
//				System.out.println("로그아웃기능 실행");
//				jbLogin.setText("로그인");
//			}
			
//			dispose();
			
			validate();
			repaint();
		});

		jbJoin.addActionListener(e -> {
			new JoinFrame();
			dispose();
		});
		
		jbLogout.addActionListener(e -> {
			logout();
		});
	}
	
	public void login() {
		// TODO Auto-generated method stub
		// 
	}
	
	public void logout() {
		// TODO Auto-generated method stub
		// f

	}

	public void tableRefresh() {

		dtm.getDataVector().clear();
		dtm.getDataVector().addAll(db.getData("SELECT * FROM `4501`.list;"));

	}

//	public void logRefresh() {
//		
//		
//		jbLogin.setText("로그아웃");
//		
////		jpTeast.removeAll();
//		
//		refresh();
//		
//	}

}
