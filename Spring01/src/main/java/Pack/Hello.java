package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;

class Animal{
	Animal(){
		System.out.println("������ ��1");
	}
	void m1() {
		System.out.println("��1");
	}
}

class Tiger extends Animal{
	Tiger(){
		System.out.println("������ ��2");
	}
	
	void m2() {
		System.out.println("��2");
	}
}


class Apple{
	Apple(){
		System.out.println(1);
	}
	void f1() {
		System.out.println(2);
	}
}

//Control + space
@Configuration
class AppConfig{
	@Bean
	public Apple apple() {
		return new Apple();
	}
}


public class Hello {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Apple a2 = ctx.getBean("apple", Apple.class);
		a2.f1();
		
		
		
		//Animal t = new Animal();
		//t.m1();
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(
//				"classpath:Context.xml"
//				);
//		
//		System.out.println("ctx ����");
//		Animal t1 = ctx.getBean("tiger", Animal.class); //��ĳ����
//		t1.m1();
//		
//		Tiger t2 = ctx.getBean("tiger", Tiger.class); //Bean ��ü�� t�� ��ü ����
//		t2.m1();
//		
//		ctx.close(); // ctx ��ü�� ���� �� close
//		
	}

}
