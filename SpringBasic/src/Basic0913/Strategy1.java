package Basic0913;

//ex1 �ܺ��� ���Կ� ���� �����ϴ� ���� ����)
class Airplane1{
	Fuel1 fuel;
	public Airplane1(Fuel1 fuel) {
		this.fuel = fuel;
	}
	
	void fly() {
		fuel.use();
		System.out.println("�� ���ư��ϴ�.");
	}
}

interface Fuel1{
	void use();
}


class Water1 implements Fuel1{
	@Override
	public void use() {
		System.out.println("��");
	}
}

public class Strategy1 {
	public static void main(String[] args) {
		Airplane1 airplane = new Airplane1(new Water1());
		airplane.fly();
	}

}
