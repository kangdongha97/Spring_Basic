package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;


class A{
	void f1() {
		
	}
	
}
class B extends A{
	void f2() {
		
	}
}
class C{
	A m1() { return new A();}
	A m2() { return new B();} // �� ĳ����
	//B m3() { return new A();} // �� = �� �ٿ�ĳ�����̱⶧���� ����x
	B m4() { return new B();}	
}
public class Hello{
	public static void main(String[] args) {
		// ������ ���� = �������� �޸� Ȯ��
		C c = new C();
		A a0 = c.m2();
		A a1 = (A)c.m2();
		A a2 = (B)c.m2();
		// �� �ڵ�� �� ���� �ǹ������� chainning �� ����� ���� �ٸ�
		a1.f1();
		a2.f1();
		
		((A)c.m2()).f1();
		//((A)c.m2()).f2(); //AŬ���� Ÿ������ ĳ���õǾ��� ������ f2 ���x
		((B)c.m2()).f1(); //���
		((B)c.m2()).f2();
		
	}
}


/*
//ex6 ������ ���� step6 Bean, ��ü������ xml���� ���� �ϴ� ��� Context.xml
//���丮�� �������Ϸ� ����� ����
//�ڹ� �ڵ� ���θ� �ǵ帮�� �ʰ� ���������� �̿��� ���뼺 �ְ� ����
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}

class Gas implements Fuel{
	public String getFuel() {
		return "����";
	}
}

class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Ship{
	Fuel fuel;
	Ship(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Car{
	Fuel fuel;
	Car(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� �޸���");
	}
}

public class Hello {

	public static void main(String[] args) {
		System.out.println(1);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("Context.xml");
		
		Fuel fuel = ctx.getBean("makeWater", Water.class);
		System.out.println(fuel.getFuel());
		
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		airplane.fly();
		
		Ship ship = ctx.getBean("ship", Ship.class);
		ship.fly();
		
		Car car = ctx.getBean("car", Car.class);
		car.fly();
		
		ctx.close();
		
				
	}

}
*/

/*
//ex5 ������ ���� step5 Context, Bean ���
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Ship{
	Fuel fuel;
	Ship(Fuel fuel) {
		this.fuel = fuel;
	}
}

class Car{
	Fuel fuel;
	Car(Fuel fuel) {
		this.fuel = fuel;
	}
}
//Bean ���
@Configuration
class Factory{
	//Spring �� ��ü����
	@Bean
	Fuel makeFuel() {
		return new Water();
	}
	@Bean
	Airplane airplane() {
		return new Airplane(makeFuel());
	}
	@Bean
	Ship ship() {
		return new Ship(makeFuel());
	
	}
	@Bean
	Car car() {
		return new Car(makeFuel());
	
	}
	
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
//		Airplane airplane = new Factory().airplane(); // ��ĳ����, Ÿ���� ���� ��� ��밡��
//		airplane.fly();
//		
//		Ship ship = new Factory().ship();
//		Car car = new Factory().car();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Factory.class);
		
		// "makeFuel" > makeFuel ��� �Լ��� ȣ������ �� �����Ǵ� new Water ��ü �� getBean���� ����
		// Fuel.class > �Լ��� ���� Ÿ���� Fuel Ÿ������ ĳ��������
		// �Լ��� ����Ÿ���� �⺻������ object Ÿ�� > �ٸ�Ÿ���� ��츦 ���� Ÿ��ĳ����
		Fuel fuel = ctx.getBean("makeFuel", Fuel.class);
		// Fuel fuel = (Fuel) ctx.getBean("makeFuel"); �� �ڵ�� ����
		System.out.println(fuel.getFuel());
		
		
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		// Airplane airplane = new Factory().airplane(); �� �ڵ�� ����
		// Bean ����� ����ϸ� ���ο��� new�� �̿��� ��ü������ �ϴ� ��찡 ����
		airplane.fly();
		
		ctx.close();
	}

}
*/
/*
//ex4 ������ ���� step4 
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Ship{
	Fuel fuel;
	Ship(Fuel fuel) {
		this.fuel = fuel;
	}
}

class Car{
	Fuel fuel;
	Car(Fuel fuel) {
		this.fuel = fuel;
	}
}

class Factory{
	Fuel makeFuel() {
		return new Water();
	}
	
	Airplane airplane() {
		return new Airplane(makeFuel());
	
	}
	Ship ship() {
		return new Ship(makeFuel());
	
	}
	Car car() {
		return new Car(makeFuel());
	
	}
	
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane(); // ��ĳ����, Ÿ���� ���� ��� ��밡��
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car = new Factory().car();
	}

}
*/

/*
//ex3 ������ ���� step3 ����� �Ӹ� �ƴ϶� ��, �ڵ��� �߰� step3
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Ship{
	Fuel fuel;
	Ship(Fuel fuel) {
		this.fuel = fuel;
	}
}

class Car{
	Fuel fuel;
	Car(Fuel fuel) {
		this.fuel = fuel;
	}
}

class Factory{
	Airplane airplane() {
		Airplane airplane = new Airplane(makeFuel());
		return airplane;
	
	}
	Ship ship() {
		Ship ship = new Ship(makeFuel());
		return ship;
	
	}
	Car car() {
		Car car = new Car(makeFuel());
		return car;
	
	}
	
	// new Water �κ��� �ٲ�� �ڵ� ���θ� �ǵ������
	// ���θ� �ǵ帮�� �ʰ� Ŭ������ ���θ���� Ŭ�������� ���븸 ���� �� �� �ְ�
	// >> �����丵
	Fuel makeFuel() {
		return new Water();
	}
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane(); // ��ĳ����, Ÿ���� ���� ��� ��밡��
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car = new Factory().car();
	}

}
*/

/*
//ex2 ������ ���� step2 ���丮 Ŭ�������� ��ü����
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

class Factory{
	// ��ü ���� �ڵ尡 �Լ��� �Ǿ�����
	//���1
//	Airplane makeAirplane() {
//		Airplane airplane = new Airplane(new Water());
//		return airplane;
//	}
	//���2
	Airplane airplane() {
		Airplane airplane = new Airplane(new Water());
		return airplane;
	
	}
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane(); // ��ĳ����, Ÿ���� ���� ��� ��밡��
		airplane.fly();
	}

}
*/

/*
//ex1 ������ ���� step1
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "��";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " �� ����");
	}
}

public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		
		Airplane airplane = new Airplane(new Water());
		airplane.fly();
	}

}
*/