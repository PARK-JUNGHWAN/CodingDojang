package senior;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SystemBackgroundImage extends Panel {
	final String PATH = "src\\senior\\1.jpg";
	Image img;
	SystemBackgroundImage(){
		img = Toolkit.getDefaultToolkit().getImage(PATH);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),
				this);
	}
}

public class TotalSystem extends Frame 
	implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == item_image) {
			this.card.show(totalPanel, "image");
		}else if(obj == item_chart) {
			this.card.show(totalPanel, "chart");
		}else if(obj == item_customer) {
			this.card.show(totalPanel, "customer");
		}else if(obj == item_employee) {
			this.card.show(totalPanel, "employees");
		}else if(obj == item_home) {
			this.card.show(totalPanel, "background");
		}else if(obj == item_item) {
			this.card.show(totalPanel, "item");
		}else if(obj == item_fruits) {
			this.card.show(totalPanel, "fruits");
		}else if(obj == item_logout) {//로그아웃 메뉴아이템을 클릭한 경우
			//정말로 종료하시겠습니까?라는 다이얼로그를 출력
			//"예"를 선택한 경우에만 로그아웃 처리
			//다이얼로그 처리를 했다치고,
			this.card.show(totalPanel, "login");//로그인 화면으로 전환
			loginSystem.id_txt.setText(" ");
			loginSystem.id_txt.setText("");
			loginSystem.pwd_txt.setText(" ");
			loginSystem.pwd_txt.setText("");
			menu_logout.setEnabled(false);//메뉴를 비활성화
			menu_fruits.setEnabled(false);//메뉴를 비활성화
			menu_item.setEnabled(false);//메뉴를 비활성화
			menu_home.setEnabled(false);//홈으로 메뉴를 비활성화
			menu_employee.setEnabled(false);//사원관리 메뉴 비활성화
			menu_customer.setEnabled(false);//고객관리 메뉴 비활성화
			menu_chart.setEnabled(false);;//막대그래프 메뉴 비활성화
			menu_image.setEnabled(false);//이미지 업로드 비활성화
			this.setTitle("정보관리 시스템 ver1.0");
		}
		
	}
	Font font, menuFont;	CardLayout card;
	Panel totalPanel, fruitsSystem, backgroudImage;
	LoginSystem loginSystem;//로그인 
	ItemSystem itemSystem;//물품관리
	EmployeeSystem employeeSystem;//사원관리
	CustomerSystem customerSystem;//고객관리
	BarchartSystem barchartSystem;//막대그래프
	ImageSystem imageSystem;//이미지 업로드
	MenuBar mb; 
	Menu menu_logout,menu_fruits,menu_item, menu_home,
			menu_employee,menu_customer,menu_chart,menu_image; 
	MenuItem item_logout,item_fruits,item_item, item_home,
			item_employee,item_customer,item_chart,item_image;
	public TotalSystem(String str) {
		super(str);
		font = new Font("굴림체",Font.BOLD, 20);
		menuFont = new Font("굴림체",Font.PLAIN, 14);
		/////메뉴 관련 작업 시작////
		mb = new MenuBar();	
		menu_logout = new Menu("로그아웃");
		menu_fruits = new Menu("과일안내 시스템");
		menu_item = new Menu("물품관리 시스템");
		menu_home = new Menu("홈으로");
		menu_employee = new Menu("사원관리 시스템");
		menu_customer = new Menu("고객관리 시스템");
		menu_chart = new Menu("막대그래프");
		menu_image = new Menu("이미지 시스템");
		menu_logout.setFont(menuFont);
		menu_fruits.setFont(menuFont);
		menu_item.setFont(menuFont);
		menu_home.setFont(menuFont);
		menu_employee.setFont(menuFont);
		menu_customer.setFont(menuFont);
		menu_image.setFont(menuFont);
		item_logout = new MenuItem("로그아웃");
		item_fruits = new MenuItem("시스템 열기");
		item_item = new MenuItem("시스템 열기");
		item_employee = new MenuItem("시스템 열기");
		item_customer = new MenuItem("시스템 열기");
		item_chart = new MenuItem("시스템 열기");
		item_image = new MenuItem("시스템 열기");
		item_home = new MenuItem("이 동");
		item_employee.setFont(menuFont);
		item_item.setFont(menuFont);
		item_fruits.setFont(menuFont);
		item_home.setFont(menuFont);
		item_customer.setFont(menuFont);
		item_chart.setFont(menuFont);
		item_image.setFont(menuFont);
		item_home.addActionListener(this);
		item_fruits.addActionListener(this);
		item_logout.addActionListener(this);
		item_item.addActionListener(this);
		item_employee.addActionListener(this);
		item_customer.addActionListener(this);
		item_chart.addActionListener(this);
		item_image.addActionListener(this);
		item_logout.setFont(menuFont);
		menu_logout.setEnabled(false);//비활성화,로그인 전이므로.
		menu_fruits.setEnabled(false);//비활성화,로그인 전이므로.
		menu_item.setEnabled(false);//비활성화
		menu_home.setEnabled(false);//홈 메뉴를 비활성화
		menu_employee.setEnabled(false);//사원관리 메뉴 비활성화
		menu_customer.setEnabled(false);//고객관리 메뉴 비활성화
		menu_chart.setEnabled(false);//막대그래프 메뉴 비활성화
		menu_image.setEnabled(false);//이미지 업로드 비활성화
		menu_fruits.add(item_fruits);//과일시스템열기를 메뉴에 붙임
		menu_logout.add(item_logout);//메뉴아이템을 메뉴에 붙임
		menu_item.add(item_item);//메뉴아이템을 메뉴에 붙임
		menu_chart.add(item_chart);
		menu_home.add(item_home);
		menu_employee.add(item_employee);
		menu_customer.add(item_customer);
		menu_image.add(item_image);
		mb.add(menu_logout);//메뉴바에 메뉴를 붙임
		mb.add(menu_fruits);//메뉴바에 과일안내시스템 메뉴를 붙임
		mb.add(menu_item);//메뉴바에 물품관리 메뉴를 붙임
		mb.add(menu_employee);
		mb.add(menu_customer);
		mb.add(menu_home);
		mb.add(menu_chart);
		mb.add(menu_image);
		this.setMenuBar(mb);//메뉴바를 윈도우에 붙임
		/////메뉴 관련 작업 끝//////
		card = new CardLayout();
		totalPanel = new Panel(); totalPanel.setLayout(card);
		loginSystem = new LoginSystem(this);//LoginSystem을 패널로변경
		fruitsSystem = new FruitsShopping(this);//FruitsShpping패널생성
		backgroudImage =new SystemBackgroundImage();//배경이미지 패널생성
		itemSystem = new ItemSystem(this);//물품관리 생성
		employeeSystem = new EmployeeSystem(this);//사원관리 생성
		customerSystem = new CustomerSystem(this);//고객관리 생성
		barchartSystem = new BarchartSystem();
		imageSystem = new ImageSystem(this);//이미지 업로드
		totalPanel.add(loginSystem,"login");
		totalPanel.add(backgroudImage,"background");
		totalPanel.add(fruitsSystem,"fruits");
		totalPanel.add(itemSystem,"item");
		totalPanel.add(employeeSystem,"employees");
		totalPanel.add(customerSystem,"customer");
		totalPanel.add(barchartSystem,"chart");
		totalPanel.add(imageSystem,"image");
//		card.show(totalPanel, "fruits");
		//카드레이아웃에서 처음 출력될 패널 설정 
		this.add("Center",totalPanel);
		this.setSize(800,500);
		this.setLocation(300,200);
		this.addWindowListener(new LoginSystemExit());
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new TotalSystem("정보관리 시스템 ver1.0");
	}
}








