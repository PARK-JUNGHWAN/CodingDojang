package pjh;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class LoginSystem extends Frame {
	Font font; 
	Label id_info, pwd_info;
	TextField id_txt, pwd_txt;
	Button login, cancel;
	Panel pan_id, pan_pwd, pan_button;
	Panel north;
	
	public LoginSystem(String str) {
		super(str);
		font = new Font("굴림체", Font.BOLD, 20);
		id_info = new Label("ID를 입력하세요."); id_info.setFont(font);
		id_txt = new TextField(10); id_txt.setFont(font);
		pwd_info = new Label("암호를 입력하세요"); pwd_info.setFont(font);
		pwd_txt = new TextField(10); pwd_txt.setFont(font);
		pwd_txt.setEchoChar('*');
		pan_id = new Panel();
		pan_id.add(id_info); pan_id.add(id_txt);
		pan_pwd = new Panel();
		pan_pwd.add(pwd_info); pan_pwd.add(pwd_txt);
		login = new Button("로그인"); login.setFont(font);
		login.addActionListener(new MyLoginEvent(this));
		cancel = new Button("다시입력"); cancel.setFont(font);
		cancel.addActionListener(new MyLoginEvent(this));
		pan_button = new Panel();
		pan_button.add(login); pan_button.add(cancel);
		north = new Panel(); north.setLayout(new GridLayout(2,1));
		north.add(pan_id); north.add(pan_pwd);
		this.setSize(400,300);
		this.add("North", north);
		this.add("South",pan_button);
		this.setBackground(Color.orange);
		this.addWindowListener(new LoginSystemExit());
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new LoginSystem("로그인 ver 1.0");

	}

}


