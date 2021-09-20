package Basic0913;

//ex3 ���丮 �޼ҵ� ���� ex2 �ڵ带 �ٸ� ���ÿ� ����
abstract class PizzaStore3{
	void orderPizza() {
		//getFuel().use();
		Pizza3 pizza = createPizza(); // ���ϰ��� ������ pizza�� �޾Ƽ� �Ʒ����� ���
		pizza.make();
		System.out.println("���� �귣�带 �̿��ؼ� �Ǹ��Ѵ�.");
	}
	void method() {}; // ����ִ� �Լ� > hook �Լ�
	
	abstract Pizza3 createPizza(); // abstract �̿��� �� �Ŀ� �Լ��� ���� �ϵ��� �ϴ� ���� > ���ø� �޼ҵ� ����
}

class SeoulPizzaStore3 extends PizzaStore3{
	@Override
	Pizza3 createPizza() { // � ��ü�� �������� �ڽ� Ŭ������ �����ϴ� ����> ���丮 �޼ҵ� ����
		return new SeoulPizza3();
	}
}

interface Pizza3{
	void make();
}


class SeoulPizza3 implements Pizza3{
	@Override
	public void make() {
		System.out.println("������ ���ڸ� �����.");
	}
}

public class Factory_method3 {
	public static void main(String[] args) {
		PizzaStore3 pizzaStore = new SeoulPizzaStore3();
		pizzaStore.orderPizza();
	}

}
