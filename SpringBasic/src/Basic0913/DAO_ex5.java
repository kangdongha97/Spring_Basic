package Basic0913;

//ex5 ex4 �� ������������ �ٽ� ����
class UserDao5{
	ConnectionMaker5 c;
	UserDao5(ConnectionMaker5 c){
		this.c = c;
	}
	
	void addUser() {
		//getFuel().use();
		// DB ����
		c.connect();
		// DB ��� insert into
		System.out.println("insert into");
	}
}

interface ConnectionMaker5{
	void connect();
}


class AmazonConnection5 implements ConnectionMaker5{
	@Override
	public void connect() {
		System.out.println("����Ŭ DB ����.");
	}
}

public class DAO_ex5 {
	public static void main(String[] args) {
		UserDao5 userDao = new UserDao5(new AmazonConnection5());
		userDao.addUser();
	}
}
