package Basic0913;

//ex1 외부의 주입에 의해 동작하는 전략 패턴)
class Airplane1{
	Fuel1 fuel;
	public Airplane1(Fuel1 fuel) {
		this.fuel = fuel;
	}
	
	void fly() {
		fuel.use();
		System.out.println("로 날아갑니다.");
	}
}

interface Fuel1{
	void use();
}


class Water1 implements Fuel1{
	@Override
	public void use() {
		System.out.println("물");
	}
}

public class Strategy1 {
	public static void main(String[] args) {
		Airplane1 airplane = new Airplane1(new Water1());
		airplane.fly();
	}

}
