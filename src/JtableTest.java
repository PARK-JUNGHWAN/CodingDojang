package senior;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JtableTest extends JFrame {
	JTable table;
	String[] columnName = {"학번","이름","주소","연락처"};
	String[][] data = {
			{"2001A01","홍길동","서울시 송파구","010-111-2222"},
			{"2001B01","마길동","서울시 강남구","010-2121-3456"},
			{"2001C01","오길동","서울시 종로구","010-4523-5678"}
	};
	JPanel panel; JScrollPane scroll;
	public JtableTest(String str) {
		super(str);
		table = new JTable(data, columnName);//데이터,열 제목
		scroll = new JScrollPane(table);
		panel = new JPanel();		panel.add(scroll);
		this.add("Center",panel);
		this.setSize(350,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {	
		new JtableTest("제이테이블 ver1.0");
	}
}






