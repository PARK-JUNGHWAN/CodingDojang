package senior;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class ItemSystem extends JPanel 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = arg0.getSource();
		if(o == btns[0]) {//삽입버튼을 누른 경우
//			String code = inputs[0].getText();
//			if(code.equals("")) {
//				//상품번호는 반드시 입력해야 합니다.라는 다이얼로그 출력
//				JOptionPane.showMessageDialog(ts, 
//					"상품번호는 반드시 입력해야 합니다.");
//			}else {
//				//해당 상품번호로 이미 존재하는지 검사
//				CRUDprocess crud = new CRUDprocess();
//				ItemInfo itemInfo = crud.selectItemCode(code);
//				if(itemInfo == null) {
//					//삽입작업을 진행
//					String name = inputs[1].getText();//상품이름
//					String price = inputs[2].getText();//상품가격
//					String info = item_desc.getText();//상품설명
//					String origin = "";//원산지용 변수
//					if(madeIn[0].getState()) {//한국산이 선택된 경우
//						origin="한국산";
//					}else if(madeIn[1].getState()) {//외국산이선택된경우
//						origin="외국산";
//					}
//					String image=SaveActionListener.path;//이미지경로
//					ItemInfo item_info = new ItemInfo();
//					item_info.setCode(code);
//					item_info.setName(name);
//					item_info.setPrice(Integer.parseInt(price));
//					//가격은 모델에서 정수이므로, 문자열을 정수로 변환
//					item_info.setInfo(info);
//					item_info.setOrigin(origin);
//					item_info.setImage(image);
//					int result = crud.insertItemInfo(item_info);
//					//DB에 삽입
//					if(result > 0) {
//						JOptionPane.showMessageDialog(ts, 
//								"상품정보가 등록되었습니다.");
//					}else {
//						JOptionPane.showMessageDialog(ts, 
//								"상품정보 등록 중 문제가 발생했습니다.");
//					}
//				}else {
//					//해당 상품번호가 이미 있으므로 경고 다이얼로그 출력
//					JOptionPane.showMessageDialog(ts, 
//							"해당 상품번호는 이미 존재합니다.");
//				}
//			}
		}else if(o == btns[1]) {//삭제버튼을 누른 경우
//			int result = JOptionPane.showConfirmDialog(ts, 
//					"정말로 삭제하시겠습니까?",	"작업 확인",
//					JOptionPane.YES_NO_OPTION);
//			//Yes와 No 버튼이 있는 다이얼로그 생성
//			if(result == JOptionPane.YES_OPTION) {
//				//DB에서 삭제작업을 진행
//				String code = inputs[0].getText();//상품번호 저장
//				if(code.equals("")) {//상품번호가 없는 경우
//					JOptionPane.showMessageDialog(ts, 
//						"상품번호가 없어서 작업을 진행할 수 없습니다.");
//				}else {//DB에서 해당 상품번호를 삭제
//					CRUDprocess crud = new CRUDprocess();
//					int r = crud.deleteItemCode(code);
//					if(r > 0) {
//						JOptionPane.showMessageDialog(ts, 
//							"해당 상품정보가 삭제되었습니다.");
//					}else {
//						JOptionPane.showMessageDialog(ts, 
//							"상품정보 삭제 중 문제가 발생했습니다.");
//					}
//				}
//			}else if(result == JOptionPane.NO_OPTION) {
//				
//			}
		}else if(o == btns[2]) {//변경 버튼을 누른경우
//			int result = JOptionPane.showConfirmDialog(ts, 
//					"정말로 변경하시겠습니까?",	"작업 확인",
//					JOptionPane.YES_NO_OPTION);
//			if(result == JOptionPane.YES_OPTION) {
//				String code = inputs[0].getText();//상품번호 저장
//				if(code.equals("")) {//상품번호가 입력되지 않은 경우
//					JOptionPane.showMessageDialog(ts, 
//						"상품번호가 없어서 작업을 진행할 수 없습니다.");
//				}else {//DB에서 해당 상품의 정보를 변경(update)
//					CRUDprocess crud=new CRUDprocess();
//					String name = inputs[1].getText();//이름
//					String price=inputs[2].getText();//가격
//					String info=item_desc.getText();
//					String origin="";
//					if(madeIn[0].getState()==true) {
//						origin="한국산";
//					}else if(madeIn[1].getState()==true) {
//						origin="외국산";
//					}
//					ItemInfo item_info=new ItemInfo();
//					item_info.setCode(code);
//					item_info.setName(name);
//					item_info.setPrice(Integer.parseInt(price));
//					item_info.setInfo(info);
//					item_info.setOrigin(origin);
//					int r = crud.updateItemInfo(item_info);//DB update
//					if(r > 0) {
//						JOptionPane.showMessageDialog(ts,
//							"상품정보가 변경되었습니다.");
//					}else {
//						JOptionPane.showMessageDialog(ts, 
//							"상품정보 변경 중 문제가 발생했습니다.");
//					}
//				}
//			}else if(result == JOptionPane.NO_OPTION) {
//				
//			}
		}else if(o == btns[3]) {
			//상품번호, 이름, 가격, 원산지가 입력되었는지를 찾는다.
			HashMap<String, Object> map = new HashMap<String, Object>();
			if(! inputs[0].getText().equals("")) {
				map.put("code", inputs[0].getText());
			}
			if(! inputs[1].getText().equals("")) {
				map.put("name", inputs[1].getText());
			}
			if(! inputs[2].getText().equals("")) {
				map.put("price", inputs[2].getText());
			}
			if(madeIn[0].isSelected()) {
				map.put("origin", "한국산");
			}else if(madeIn[1].isSelected()) {
				map.put("origin", "외국산");
			}
			CRUDprocess crud = new CRUDprocess();
			List<ItemInfo> result = crud.selectIteminfoCondition(map);
			System.out.println("검색된 건수: "+result.size());
		}else if(o == btns[4]) {//지우기 버튼을 누른경우
			btns[0].setEnabled(true);
			for(int i=0; i<inputs.length; i++) {
				inputs[i].setText(" ");
				inputs[i].setText("");
			}//세 개의 텍스트 필드에 입력된 값을 지움
			item_desc.setText(" ");
			item_desc.setText("");//상품정보를 지움
		}
	}
	JButton[] btns; JLabel[] titles; JTextField[] inputs;
//	Checkbox[] madeIn; CheckboxGroup group;
	JRadioButton[] madeIn; ButtonGroup group;
	JPanel[] panels; JTextArea item_desc;	Font font;
	String[] titles_txt = {"상품번호","상품이름","상품가격","상품설명",
			"상품원산지"};
	String[] titles_btn = {"삽 입","삭 제","변 경","조 회","지우기"};
	void makePanel() {//패널을 6개 생성하는 메서드
		panels = new JPanel[6];
		for(int i=0; i<panels.length; i++) {
			panels[i] = new JPanel();//패널 생성
		}
	}
	void makeButton() {//버튼을 생성하는 메서드
		btns = new JButton[5];//길이5의 배열 생성
		for(int i=0; i<btns.length; i++) {
			btns[i] = new JButton(titles_btn[i]);//버튼 생성
			btns[i].setFont(font);//폰트 적용
			btns[i].addActionListener(this);
		}
	}
	void makeTextField() {//텍스트 필드를 생성하는 메서드
		inputs = new JTextField[3];//크기3의 배열 생성
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new JTextField(15);//길이15의 텍스트필드 생성
			inputs[i].setFont(font);//폰트 적용
		}
	}
	void makeLabel() {//안내메세지(레이블)을 생성하는 메서드
		titles = new JLabel[5];//크기5의 배열생성
		for(int i=0; i<titles.length; i++) {
			titles[i] = new JLabel(titles_txt[i]);//레이블 생성
			titles[i].setFont(font);//폰트 적용
		}
	}
	void makeRadioButton() {//원산지용 라디오버튼을 생성하는 메서드
		group = new ButtonGroup();//라디오버튼을 위한 그룹 생성
		madeIn = new JRadioButton[2];//크기2의 배열 생성
		madeIn[0] = new JRadioButton("한국산",true);//기본선택
		madeIn[1] = new JRadioButton("외국산",false);
		group.add(madeIn[0]); group.add(madeIn[1]);
		madeIn[0].setFont(font); madeIn[1].setFont(font);
	}
	Panel centerPanel;//상품 정보
	public ItemSystem() {
		font = new Font("굴림체",Font.BOLD, 20);
		this.setLayout(new BorderLayout());
//		this.setLayout(new GridLayout(6,1));//6행1열의 그리드레이아웃
		centerPanel = new Panel();
		centerPanel.setLayout(new GridLayout(5,1));
		makeRadioButton();
		makeLabel();
		makeTextField();
		makeButton();
		makePanel();
		item_desc = new JTextArea(2,15);//15행 2열로 텍스트에리어 생성
		panels[0].add(titles[0]);panels[0].add(inputs[0]);
		panels[1].add(titles[1]);panels[1].add(inputs[1]);
		panels[2].add(titles[2]);panels[2].add(inputs[2]);
		panels[3].add(titles[3]);panels[3].add(item_desc);
		panels[4].add(titles[4]);
		panels[4].add(madeIn[0]);panels[4].add(madeIn[1]);
		panels[5].add(btns[0]);panels[5].add(btns[1]);
		panels[5].add(btns[2]);panels[5].add(btns[3]);
		panels[5].add(btns[4]);//지우기 버튼을 패널에 붙임
		for(int i=0; i<(panels.length-1); i++) {
			centerPanel.add(panels[i]);//패널을 윈도우에 붙임
		}
		//화면 가운데에 centerPanel을 붙인다.
		this.add("Center",centerPanel);
		//환면 아래에 panels[5]를 붙인다.(버튼을 가지고 있는 패널)
		this.add("South",panels[5]);
		this.setBackground(Color.ORANGE);
//		this.setSize(400, 500);
//		this.addWindowListener(new LoginSystemExit());
//		this.setVisible(true);
	}
	
	public static void main(String[] args) {
//		new ItemSystem("풀품관리 시스템 ver1.0");
	}
}

class ItemModel extends AbstractTableModel {
	Object tableDate[][]; int rows, cols;
	String[] columnName= {"상품번호","상품이름","상품가격","상품정보","원산지","이미지경로"};
	
	List<ItemInfo> list;
	ItemModel(CRUDprocess crud, Map map){
		list=crud.selectIteminfoCondition(map);
		cols=columnName.length; rows=list.size();
		setData();
	}
	
	private void setData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}







