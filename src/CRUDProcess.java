package pjh;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CRUDProcess {
//이 클래스의 목적: MyBatis의 매퍼를 호출
//무슨 일을 하나? 1. Mybatis 환경설정 파일을 읽음  2. 위 1의 작업으로 매퍼를 호출할 객체(SqlSession) 생성
//특이사항: SqlSession은 SqlSessionFactory가 생성한다. 
//		  SqlSessionFactory는 SqlSessionFactoryBuilder가 생성
/// SqlSession 만드는 메서드 ///
	private SqlSession getSession() {
		String path = "pjh/mybatis_config.xml";
		InputStream is = null; //파일의 내용을 읽을 객체
		
		try {
			is = Resources.getResourceAsStream(path);
		} catch(Exception e) {
			System.out.println("환경설정 파일을 읽는 중 예외발생");
		}
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		SqlSessionFactory factory = builder.build(is);
		
		SqlSession session = factory.openSession();
		
		return session;
	}
/// 화면에서 입력한 id와 패스워드를 사용해서 쿼리를 실행하는 메서드 ///
	public ManagerInfo selectIdAndPwd(UserIdPwd idPwd){
		SqlSession s = getSession();
		try {
			ManagerInfo info = s.selectOne("Loginmapper.selectIdPwd", idPwd);
			// selectone은 검색결과가 1건일 때만 사용하는 메서드, selectlist는 검색결과가 여러 건일때
			return info;
		}finally {
			s.close();
		}
		
	} // db의 manager_info 테이블의 id와 암호를 찾아서 리턴
}
