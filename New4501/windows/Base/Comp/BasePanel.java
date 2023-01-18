package Base.Comp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BasePanel extends JPanel {
	public BasePanel jpCenter;
	public BasePanel jpTop;
	public BasePanel jpRight;
	public BasePanel jpLeft;
	public BasePanel jpBottom;

	public BasePanel() {
		super.setLayout(new BorderLayout());
	}

	public BasePanel setGrid(int r, int c, int hgab, int vgab) {
		super.setLayout(new GridLayout(r, c, hgab, vgab));
		return this;
	}
	public BasePanel setGrid(int r, int c) {
		super.setLayout(new GridLayout(r, c));
		return this;
	}

	public BasePanel setFlow() {
		super.setLayout(new FlowLayout(FlowLayout.RIGHT));
		return this;
	}
	public BasePanel addCild() {
		
		jpCenter = new BasePanel();
		jpTop = new BasePanel();
		jpRight = new BasePanel();
		jpLeft = new BasePanel();
		jpBottom = new BasePanel();
		
		super.add(jpCenter, BorderLayout.CENTER);
		super.add(jpTop, BorderLayout.NORTH);
		super.add(jpRight, BorderLayout.EAST);
		super.add(jpLeft, BorderLayout.WEST);
		super.add(jpBottom, BorderLayout.SOUTH);
		
		return this;
	}

}
