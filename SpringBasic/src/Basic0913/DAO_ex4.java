package Basic0913;

//ex4 DAO data access object ex3�� �����ͺ��̽� crud�� �������� �ϴ� Ŭ���� ����
//���ø� �޼ҵ�, ���丮 �޼ҵ� ���� Ȱ��

abstract class UserDao4{
	void addUser() {
		//getFuel().use();
		// DB ����
		ConnectionMaker4 conn = getConnection();
		conn.connect();
		// DB ��� insert into
		System.out.println("insert into");
		// DB ����
		conn.close();
	}
	void getUser() {
		//getFuel().use();
		// DB ����
		ConnectionMaker4 conn = getConnection();
		conn.connect();
		// DB ��ȸ select from
		System.out.println("select from");
		// DB ����
		conn.close();
	}
	
	void method() {}; // ����ִ� �Լ� > hook �Լ�
	
	abstract ConnectionMaker4 getConnection(); // abstract �̿��� �� �Ŀ� �Լ��� ���� �ϵ��� �ϴ� ���� > ���ø� �޼ҵ� ����
}

class AmazonDao4 extends UserDao4{
	@Override
	ConnectionMaker4 getConnection() { // � ��ü�� �������� �ڽ� Ŭ������ �����ϴ� ����> ���丮 �޼ҵ� ����
		return new AmazonConnection();
	}
}

interface ConnectionMaker4{
	void connect();
	void close();
}


class AmazonConnection implements ConnectionMaker4{
	@Override
	public void connect() {
		System.out.println("����Ŭ DB ����.");
	}
	@Override
	public void close() {
		System.out.println("DB ����");
	}
}

public class DAO_ex4 {
	public static void main(String[] args) {
		UserDao4 userDao = new AmazonDao4();
		userDao.addUser();
		userDao.getUser();
	}

}
