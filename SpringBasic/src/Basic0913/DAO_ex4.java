package Basic0913;

//ex4 DAO data access object ex3을 데이터베이스 crud를 중점으로 하는 클래스 구현
//템플릿 메소드, 팩토리 메소드 패턴 활용

abstract class UserDao4{
	void addUser() {
		//getFuel().use();
		// DB 접속
		ConnectionMaker4 conn = getConnection();
		conn.connect();
		// DB 등록 insert into
		System.out.println("insert into");
		// DB 종료
		conn.close();
	}
	void getUser() {
		//getFuel().use();
		// DB 접속
		ConnectionMaker4 conn = getConnection();
		conn.connect();
		// DB 조회 select from
		System.out.println("select from");
		// DB 종료
		conn.close();
	}
	
	void method() {}; // 비어있는 함수 > hook 함수
	
	abstract ConnectionMaker4 getConnection(); // abstract 이용해 이 후에 함수를 정의 하도록 하는 패턴 > 템플릿 메소드 패턴
}

class AmazonDao4 extends UserDao4{
	@Override
	ConnectionMaker4 getConnection() { // 어떤 객체를 생성할지 자식 클래스가 결정하는 패턴> 팩토리 메소드 패턴
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
		System.out.println("오라클 DB 연결.");
	}
	@Override
	public void close() {
		System.out.println("DB 종료");
	}
}

public class DAO_ex4 {
	public static void main(String[] args) {
		UserDao4 userDao = new AmazonDao4();
		userDao.addUser();
		userDao.getUser();
	}

}
