package senior;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JtableTest extends JFrame {
	JTable table;
	String[] columnName = {"�й�","�̸�","�ּ�","����ó"};
	String[][] data = {
			{"2001A01","ȫ�浿","����� ���ı�","010-111-2222"},
			{"2001B01","���浿","����� ������","010-2121-3456"},
			{"2001C01","���浿","����� ���α�","010-4523-5678"}
	};
	JPanel panel; JScrollPane scroll;
	public JtableTest(String str) {
		super(str);
		table = new JTable(data, columnName);//������,�� ����
		scroll = new JScrollPane(table);
		panel = new JPanel();		panel.add(scroll);
		this.add("Center",panel);
		this.setSize(350,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {	
		new JtableTest("�������̺� ver1.0");
	}
}






