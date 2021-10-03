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
	A m2() { return new B();} // 업 캐스팅
	//B m3() { return new A();} // 자 = 부 다운캐스팅이기때문에 성립x
	B m4() { return new B();}	
}
public class Hello{
	public static void main(String[] args) {
		// 왼쪽은 문법 = 오른쪽은 메모리 확보
		C c = new C();
		A a0 = c.m2();
		A a1 = (A)c.m2();
		A a2 = (B)c.m2();
		// 위 코드는 다 같은 의미이지만 chainning 을 사용할 때는 다름
		a1.f1();
		a2.f1();
		
		((A)c.m2()).f1();
		//((A)c.m2()).f2(); //A클래스 타입으로 캐스팅되었기 때문에 f2 사용x
		((B)c.m2()).f1(); //상속
		((B)c.m2()).f2();
		
	}
}


/*
//ex6 의존적 주입 step6 Bean, 객체생성을 xml에서 설정 하는 방법 Context.xml
//팩토리를 설정파일로 만드는 과정
//자바 코드 내부를 건드리지 않고 설정파일을 이용해 융통성 있게 만듦
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}

class Gas implements Fuel{
	public String getFuel() {
		return "가스";
	}
}

class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
	}
}

class Ship{
	Fuel fuel;
	Ship(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 간다");
	}
}

class Car{
	Fuel fuel;
	Car(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 달린다");
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
//ex5 의존적 주입 step5 Context, Bean 사용
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
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
//Bean 사용
@Configuration
class Factory{
	//Spring 이 객체생성
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
//		Airplane airplane = new Factory().airplane(); // 업캐스팅, 타입이 같을 경우 사용가능
//		airplane.fly();
//		
//		Ship ship = new Factory().ship();
//		Car car = new Factory().car();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Factory.class);
		
		// "makeFuel" > makeFuel 라는 함수를 호출했을 때 생성되는 new Water 객체 를 getBean으로 받음
		// Fuel.class > 함수의 리턴 타입을 Fuel 타입으로 캐스팅해줌
		// 함수의 리턴타입은 기본적으로 object 타입 > 다른타입일 경우를 위해 타입캐스팅
		Fuel fuel = ctx.getBean("makeFuel", Fuel.class);
		// Fuel fuel = (Fuel) ctx.getBean("makeFuel"); 위 코드와 같음
		System.out.println(fuel.getFuel());
		
		
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		// Airplane airplane = new Factory().airplane(); 위 코드와 같음
		// Bean 방식을 사용하면 메인에서 new를 이용한 객체생성을 하는 경우가 없음
		airplane.fly();
		
		ctx.close();
	}

}
*/
/*
//ex4 의존적 주입 step4 
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
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
		Airplane airplane = new Factory().airplane(); // 업캐스팅, 타입이 같을 경우 사용가능
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car = new Factory().car();
	}

}
*/

/*
//ex3 의존적 주입 step3 비행기 뿐만 아니라 배, 자동차 추가 step3
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
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
	
	// new Water 부분이 바뀌면 코드 내부를 건드려야함
	// 내부를 건드리지 않고 클래스를 따로만들어 클래스안의 내용만 수정 할 수 있게
	// >> 리팩토링
	Fuel makeFuel() {
		return new Water();
	}
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane(); // 업캐스팅, 타입이 같을 경우 사용가능
		airplane.fly();
		
		Ship ship = new Factory().ship();
		Car car = new Factory().car();
	}

}
*/

/*
//ex2 의존적 주입 step2 팩토리 클래스에서 객체생성
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
	}
}

class Factory{
	// 객체 생성 코드가 함수로 되어있음
	//방법1
//	Airplane makeAirplane() {
//		Airplane airplane = new Airplane(new Water());
//		return airplane;
//	}
	//방법2
	Airplane airplane() {
		Airplane airplane = new Airplane(new Water());
		return airplane;
	
	}
	
}
public class Hello {

	public static void main(String[] args) {
		System.out.println(1);
		Airplane airplane = new Factory().airplane(); // 업캐스팅, 타입이 같을 경우 사용가능
		airplane.fly();
	}

}
*/

/*
//ex1 의존적 주입 step1
interface Fuel{
	String getFuel();
}
class Water implements Fuel{
	public String getFuel() {
		return "물";
	}
}
class Airplane{
	Fuel fuel;
	Airplane(Fuel fuel) {
		this.fuel = fuel;
	}
	void fly() {
		System.out.println(fuel.getFuel() + " 로 날다");
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