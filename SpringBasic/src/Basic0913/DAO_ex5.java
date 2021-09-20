package Basic0913;

//ex5 ex4 를 전략패턴으로 다시 구현
class UserDao5{
	ConnectionMaker5 c;
	UserDao5(ConnectionMaker5 c){
		this.c = c;
	}
	
	void addUser() {
		//getFuel().use();
		// DB 접속
		c.connect();
		// DB 등록 insert into
		System.out.println("insert into");
	}
}

interface ConnectionMaker5{
	void connect();
}


class AmazonConnection5 implements ConnectionMaker5{
	@Override
	public void connect() {
		System.out.println("오라클 DB 연결.");
	}
}

public class DAO_ex5 {
	public static void main(String[] args) {
		UserDao5 userDao = new UserDao5(new AmazonConnection5());
		userDao.addUser();
	}
}
