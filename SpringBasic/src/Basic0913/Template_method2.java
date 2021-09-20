package Basic0913;

//ex2 �߻�Ŭ���� �̿� > ���ø� �޼ҵ� ����, ����Ŭ�������� ��ü���� ����
abstract class Airplane2{
	void fly() {
		getFuel().use();
		System.out.println("�� ���ư��ϴ�.");
	}
	void method() {}; // ����ִ� �Լ� > hook �Լ�
	
	abstract Fuel2 getFuel(); // abstract �̿��� �� �Ŀ� �Լ��� ���� �ϵ��� �ϴ� ���� > ���ø� �޼ҵ� ����
}

class KoreaAir2 extends Airplane2{
	@Override
	Fuel2 getFuel() { // � ��ü�� �������� �ڽ� Ŭ������ �����ϴ� ����> ���丮 �޼ҵ� ����
		return new Water2();
	}
}

interface Fuel2{
	void use();
}


class Water2 implements Fuel2{
	@Override
	public void use() {
		System.out.println("��");
	}
}

public class Template_method2 {
	public static void main(String[] args) {
		Airplane2 airplane = new KoreaAir2();
		airplane.fly();
	}

}
