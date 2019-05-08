package senior;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyLoginEvent implements ActionListener {
	LoginSystem ls; TotalSystem ts;
	public MyLoginEvent(LoginSystem l,
				TotalSystem ts) {
		ls = l; this.ts = ts;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj == ls.login || obj == ls.pwd_txt) {
			//로그인 버튼을 누른거나 암호를 입력하고 엔터를 누른 경우
			//DB에 접속한 후, manager_info테이블에서 계정과 암호를 찾는다.
			//찾은 계정과 암호를 비교한다.
			String id = ls.id_txt.getText();//입력한ID를 id에 저장
			String pwd= ls.pwd_txt.getText();//이력한암호를 pwd에 저장
			UserIdPwd idPwd = new UserIdPwd();
			idPwd.setId(id); idPwd.setPwd(pwd);
			CRUDprocess crud = new CRUDprocess();
			ManagerInfo info= crud.selectIdAndPwd(idPwd);
			if(info == null) {//로그인 실패
//				String title="정보관리 시스템 ver1.0 계정과 암호를 확인하세요";
				//title을 윈도우의 제목으로 출력
//				ls.setTitle(title);
//				ts.setTitle(title);
				//다이얼로그 생성
				JOptionPane.showMessageDialog(ts, 
						"ID와 암호를 확인하세요.");
			}else {//로그인 성공
				String title="정보관리 시스템 ver1.0 환영합니다."+id+"님~";
				//title을 윈도우의 제목으로 출력
//				ls.setTitle(title);
				ts.setTitle(title);
				JOptionPane.showMessageDialog(ts, 
						"로그인 되었습니다.");
				ts.menu_logout.setEnabled(true);//메뉴를 활성화 한다.
				ts.menu_fruits.setEnabled(true);//메뉴를 활성화 한다.
				ts.menu_item.setEnabled(true);//메뉴를 활성화 한다.
				ts.menu_home.setEnabled(true);//홈으로 메뉴를 활성화한다.
				ts.menu_employee.setEnabled(true);//사원관리 메뉴활성화
				ts.menu_customer.setEnabled(true);//고객관리 메뉴 활성화
				ts.menu_chart.setEnabled(true);//막대그래프 메뉴 활성화
				ts.menu_image.setEnabled(true);//이미지 업로드 활성화
				ts.card.show(ts.totalPanel, "background");
			}
			
		}else if(obj == ls.cancel) {//다시 입력 버튼을 누른경우
			//계정 텍스트필드와 암호 텍스트필드를 지운다.
			ls.id_txt.setText(" ");
			ls.id_txt.setText("");//계정 텍스트필드를 지움
			ls.pwd_txt.setText(" ");
			ls.pwd_txt.setText("");//암호 텍스트필드를 지움
		}
	}
}








