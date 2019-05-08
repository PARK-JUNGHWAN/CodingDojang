package senior;

public class UserIdPwd {
	private String id;
	private String pwd;
	//은닉된 변수에 데이터를 넣어주는 메서드를 만든다.
	//이런 메서드를 세터(setter)메서드라고 한다.
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
}










