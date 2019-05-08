package senior;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

//public class LoginSystem extends Frame {
public class LoginSystem extends Panel {
	Font font; Label id_info, pwd_info; TextField id_txt,pwd_txt;
	Button login,cancel;
	Panel pan_id, pan_pwd, pan_button;
	Panel north; TotalSystem ts;
//	public LoginSystem(String str) {
	public LoginSystem(TotalSystem ts) {
//		super(str);
		this.ts = ts;
		this.setLayout(new BorderLayout());
		font = new Font("굴림체", Font.BOLD, 20);
		id_info = new Label("ID를 입력하세요."); id_info.setFont(font);
		id_txt=new TextField(10); id_txt.setFont(font);
		pwd_info = new Label("암호를 입력하세요.");pwd_info.setFont(font);
		pwd_txt=new TextField(10); pwd_txt.setFont(font);
		pwd_txt.setEchoChar('*');//입력된 문자대신 * 출력
		pwd_txt.addActionListener(new MyLoginEvent(this,ts));
		pan_id = new Panel();//ID입력을 위한 레이블과 텍스트필드를 담을 패널
		pan_id.add(id_info); pan_id.add(id_txt);
		pan_pwd = new Panel();//암호입력을 위한 레이블과 텍스트필드를 담을패널
		pan_pwd.add(pwd_info); pan_pwd.add(pwd_txt);
		login=new Button("로그인"); login.setFont(font);
		login.addActionListener(new MyLoginEvent(this,ts));
		cancel=new Button("다시입력"); cancel.setFont(font);
		cancel.addActionListener(new MyLoginEvent(this,ts));
		pan_button = new Panel();//버튼을 담을 패널생성
		pan_button.add(login); pan_button.add(cancel);
		north = new Panel(); north.setLayout(new GridLayout(2,1));
		north.add(pan_id); north.add(pan_pwd);
//		this.setSize(400, 300);
		this.add("North",north); this.add("South",pan_button);
		this.setBackground(Color.ORANGE);
//		this.addWindowListener(new LoginSystemExit());
//		this.setVisible(true);
	}
	public static void main(String[] args) {
//		new LoginSystem("로그인 ver1.0");
	}
}







