package senior;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class CustomerModel extends AbstractTableModel{
	private Object[][] tableData;
	private int cols,rows;
	private String[] columnName = 
		{"고객번호","고객이름","고객주소","가입일"};
	private List<Customer_info> list;

	CustomerModel(){
		CRUDprocess crud = new CRUDprocess();
		list = crud.selectAllCustomer();//DB조회 결과가 list에 저장됨
		//list에 있는 조회결과를 tableData인 2차원 배열에 넣는다.
		setData();
	}
	private void setData() {
	//list에 있는 조회결과를 2차원 배열(tableData)에 넣는다.
	//컬렉션 프레임워크에 저장된 데이터를 검색하는 방법 -> Iterator
		Iterator it = list.iterator();
		rows = list.size();//데이터의 갯수를 rows에 저장(행의 갯수)
		cols = columnName.length;//제목의 갯수를 cols저장(열의 갯수)
		tableData = new Object[rows][cols];//배열 생성
		int r = 0;
		while(it.hasNext()) {
			Customer_info cs = (Customer_info)it.next();//조회결과를 가져옴
			tableData[r][0] = cs.getCust_id();//고객 번호
			tableData[r][1] = cs.getCust_name();//고객 이름
			tableData[r][2] = cs.getCust_addr();//고객 주소
			tableData[r][3] = cs.getCust_reg_date();//가입일
			r++;
		}
	}
	@Override
	public String getColumnName(int arg0) {
		return columnName[arg0];
	}
	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public int getRowCount() {
		return rows;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return tableData[arg0][arg1];
	}
	
}

public class CustomerInfoJtable extends JFrame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		table.setModel(new CustomerModel());
		//테이블이 사용하는 모델을 CustomerModel로 설정한다.
	}
	JButton select;	JTable table; JPanel centerPanel,southPanel;
	JScrollPane scroll;
	public CustomerInfoJtable(String str) {
		super(str);
		select = new JButton("전체 조회");
		select.addActionListener(this);
		table = new JTable(); 
		centerPanel = new JPanel();
		southPanel = new JPanel();
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);	southPanel.add(select);
		this.add("Center",scroll);	this.add("South",southPanel);
		this.setSize(500, 400);	this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new CustomerInfoJtable("고객정보 조회");
	}
}












