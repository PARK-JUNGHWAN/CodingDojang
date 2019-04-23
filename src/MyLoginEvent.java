package pjh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginEvent implements ActionListener {
	LoginSystem l;
	public MyLoginEvent(LoginSystem l) {
		this.l = l;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 버튼을 누른 경우, 다시 입력 버튼을 누른 경우
		Object obj = e.getSource();
		if(obj == l.login) { //db 접속후, manager_info 테이블에서 계정과 암호를 찾아서 비교
			String id = l.id_txt.getText();
			String pwd = l.pwd_txt.getText();
			UserIdPwd idPwd = new UserIdPwd();
			idPwd.setId(id); idPwd.setPwd(pwd);
			CRUDProcess crud = new CRUDProcess();
			ManagerInfo info = crud.selectIdAndPwd(idPwd);
			if(info == null) {
				System.out.println("로그인 실패");
				String title = "계정과 암호를 확인하세요.";
				l.setTitle(title);
			} else {
				System.out.println("로그인 성공");
				String title = "환영합니다. "+id+" 님~";
				l.setTitle(title);
			}
			
		}else if(obj == l.cancel) { //계정 텍스트필드와 암호 텍스트필드를 지운다.
			l.id_txt.setText(" ");
			l.id_txt.setText("");
			l.pwd_txt.setText(" ");
			l.pwd_txt.setText("");
		}
	}

}
