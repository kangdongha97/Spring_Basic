package Basic0913;

//ex3 팩토리 메소드 패턴 ex2 코드를 다른 예시에 적용
abstract class PizzaStore3{
	void orderPizza() {
		//getFuel().use();
		Pizza3 pizza = createPizza(); // 리턴값이 있으니 pizza에 받아서 아래에서 사용
		pizza.make();
		System.out.println("본점 브랜드를 이용해서 판매한다.");
	}
	void method() {}; // 비어있는 함수 > hook 함수
	
	abstract Pizza3 createPizza(); // abstract 이용해 이 후에 함수를 정의 하도록 하는 패턴 > 템플릿 메소드 패턴
}

class SeoulPizzaStore3 extends PizzaStore3{
	@Override
	Pizza3 createPizza() { // 어떤 객체를 생성할지 자식 클래스가 결정하는 패턴> 팩토리 메소드 패턴
		return new SeoulPizza3();
	}
}

interface Pizza3{
	void make();
}


class SeoulPizza3 implements Pizza3{
	@Override
	public void make() {
		System.out.println("서울형 피자를 만든다.");
	}
}

public class Factory_method3 {
	public static void main(String[] args) {
		PizzaStore3 pizzaStore = new SeoulPizzaStore3();
		pizzaStore.orderPizza();
	}

}
