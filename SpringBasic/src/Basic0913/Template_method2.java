package Basic0913;

//ex2 추상클래스 이용 > 템플릿 메소드 패턴, 하위클래스에서 객체생성 결정
abstract class Airplane2{
	void fly() {
		getFuel().use();
		System.out.println("로 날아갑니다.");
	}
	void method() {}; // 비어있는 함수 > hook 함수
	
	abstract Fuel2 getFuel(); // abstract 이용해 이 후에 함수를 정의 하도록 하는 패턴 > 템플릿 메소드 패턴
}

class KoreaAir2 extends Airplane2{
	@Override
	Fuel2 getFuel() { // 어떤 객체를 생성할지 자식 클래스가 결정하는 패턴> 팩토리 메소드 패턴
		return new Water2();
	}
}

interface Fuel2{
	void use();
}


class Water2 implements Fuel2{
	@Override
	public void use() {
		System.out.println("물");
	}
}

public class Template_method2 {
	public static void main(String[] args) {
		Airplane2 airplane = new KoreaAir2();
		airplane.fly();
	}

}
