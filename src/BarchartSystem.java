package senior;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GraphPanel extends Panel{
	private int total_jan, total_feb, total_mar;
	private int total_apr, total_may, total_jun;
	final String PATH = "src\\senior\\1.jpg";
	Image img;

	GraphPanel(){
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}
	
	public void setTotal_apr(int total_apr) {
		this.total_apr = total_apr;
	}

	public void setTotal_may(int total_may) {
		this.total_may = total_may;
	}

	public void setTotal_jun(int total_jun) {
		this.total_jun = total_jun;
	}

	public void setTotal_jan(int total_jan) {
		this.total_jan = total_jan;
	}

	public void setTotal_feb(int total_feb) {
		this.total_feb = total_feb;
	}

	public void setTotal_mar(int total_mar) {
		this.total_mar = total_mar;
	}

	@Override
	public void paint(Graphics g) {
//		g.clearRect(0, 0, this.getWidth(), this.getHeight());
//		//그려질 영역을 지운다. (0,0)에서 (패널의 가로길이,패널의 세로길이)
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),
				this);		
		g.setColor(Color.BLACK);//막대그래프의 색지정
		g.drawLine(50, 250, 650, 250);//수평선을 그린다.
		for(int cnt=1; cnt<11; cnt++) {
			g.drawString(cnt*10+"", 25, 255-20*cnt);
			g.drawLine(50, 250-20*cnt, 650, 250-20*cnt);
		}//10점부터100점까지 점수와 수평선을 그린다.(10회 반복)
		g.drawLine(50, 20, 50, 250);//수직선을 그린다.
		g.drawString("1월", 100, 270);
		g.drawString("2월", 200, 270);
		g.drawString("3월", 300, 270);
		g.drawString("4월", 400, 270);
		g.drawString("5월", 500, 270);
		g.drawString("6월", 600, 270);
		g.setColor(Color.RED);//막대그래프의 색지정
		if(total_jan > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(110, 250-total_jan*2, 10, total_jan*2);
		}
		if(total_feb > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(210, 250-total_feb*2, 10, total_feb*2);
		}
		if(total_mar > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(310, 250-total_mar*2, 10, total_mar*2);
		}
		if(total_apr > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(410, 250-total_jan*2, 10, total_jan*2);
		}
		if(total_may > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(510, 250-total_feb*2, 10, total_feb*2);
		}
		if(total_jun > 0) {//값이 있는 경우에만 그래프를 그림
			g.fillRect(610, 250-total_mar*2, 10, total_mar*2);
		}
	}
	
}
public class BarchartSystem extends Panel 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == btn) {//그리기 버튼을 누른경우
			int jan,feb,mar,apr,may,jun = 0;
			CRUDprocess crud = new CRUDprocess();
			Outputs output = crud.selectOutputs();//DB에서 매출정보검색
			jan = output.getJan();//1월의 매출
			feb = output.getFeb();//2월의 매출
			mar = output.getMar();//3월의 매출
			apr = output.getApr();//4월의 매출
			may = output.getMay();//5월의 매출 
			jun = output.getJun();//6월의 매출
//			if(! textFields[0].getText().equals("")) {
//				jan = Integer.parseInt(textFields[0].getText());
//			}
//			if(! textFields[1].getText().equals("")) {
//				feb = Integer.parseInt(textFields[1].getText());
//			}
//			if(! textFields[2].getText().equals("")) {
//				mar = Integer.parseInt(textFields[2].getText());
//			}
			graphPanel.setTotal_jan(jan);
			graphPanel.setTotal_feb(feb);
			graphPanel.setTotal_mar(mar);
			graphPanel.setTotal_apr(apr);
			graphPanel.setTotal_may(may);
			graphPanel.setTotal_jun(jun);
			graphPanel.repaint();//다시그린다.
		}else if(obj == clear) {//지우기 버튼을 누른경우
			graphPanel.setTotal_jan(0);
			graphPanel.setTotal_feb(0);
			graphPanel.setTotal_mar(0);
			graphPanel.setTotal_apr(0);
			graphPanel.setTotal_mar(0);
			graphPanel.setTotal_jun(0);
			graphPanel.repaint();//다시그린다.
		}
	}
	Button btn,clear; Label[] labels; TextField[] textFields;
	Panel[] panels; GraphPanel  graphPanel;
	String[] labels_title= {"1월의 매출","2월의 매출","3월의 매출"};
	void makeTextfield() {
		textFields = new TextField[3];
		for(int i=0; i<textFields.length; i++) {
			textFields[i] = new TextField(5);
		}
	}
	void makeLabel() {
		labels = new Label[3];
		for(int i=0; i<labels.length; i++) {
			labels[i] = new Label(labels_title[i]);
		}
	}
	public BarchartSystem() {
//		super(str);
		this.setLayout(new BorderLayout());
		makeLabel(); makeTextfield();
		btn = new Button("그리기");
		clear = new Button("지우기");
		btn.addActionListener(this);
		clear.addActionListener(this);
		panels = new Panel[2]; panels[0] = new Panel();
		panels[1] = new Panel();
		for(int i=0; i<labels.length; i++) {//3회 반복 
			panels[1].add(labels[i]);//레이블을 두번째 패널에 붙임
			panels[1].add(textFields[i]);//텍스트필드를 패널에 붙임
		}
		panels[1].add(btn);//두번째 패널에 버튼을 붙임
		panels[1].add(clear);//두번째 패널에 지우기버튼을 붙임
		panels[1].setBackground(Color.ORANGE);//배경색 지정
		graphPanel = new GraphPanel();//막대그래프 패널 생성
		this.add("Center",graphPanel);//윈도 가운데에 첫번째패널 붙임
		this.add("South",panels[1]);//윈도 아래에 두번째패널 붙임
//		this.setSize(500, 400);
//		this.addWindowListener(new LoginSystemExit());
//		this.setVisible(true);
	}
	public static void main(String[] args) {
//		new BarchartSystem("막대 그래프 ver1.0");
	}

}







