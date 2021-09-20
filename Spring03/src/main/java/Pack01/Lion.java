package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lion {
	@RequestMapping("/t8")
	public String method08(
			// ù ��° �Ķ���Ͱ� ������ ��, �� ��°�� ���� ��
			Model model,
			HttpServletRequest r
			) {
		String name = r.getParameter("name");
		String age = r.getParameter("age");
		
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println("�Լ���8");
		return "LionView";
	}
	
	@RequestMapping("/t9")
	public ModelAndView method09() {
		//LionView �� �Ѿ ������ ��ü�� ����
		ModelAndView mv = new ModelAndView("LionView");
		mv.addObject("name", "�����");
		mv.addObject("age", "100");
		System.out.println("�Լ���9");
		return mv;
	}
	
	
	@RequestMapping("/t10")
	public ModelAndView method10() {
		//���׿��� ����
		ModelAndView mv = new ModelAndView(
				3 < 2 ? "TigerView" : "LionView"
					);
		mv.addObject("name", "�����");
		mv.addObject("age", 100);
		System.out.println("�Լ���10");
		return mv;
	}
	
//	
//	@RequestMapping("/t12")
//	public ModelAndView method12() {
//		//LionView �� �Ѿ ������ ��ü�� ����
//		ModelAndView mv = new ModelAndView("LionView");
//		
//		System.out.println("�Լ���12");
//		return mv;
//	}
	
	@RequestMapping("/t12")
	public String method12(Model model, Person person) {
		// �Լ� ȣ��Ǹ� person�� ���۹��� �μ����� ��
		// person.getName, Age
		
		// person ��ü�� ppp �̸����� �μ� ����
		//model.addAttribute("ppp", person);
		// �迭����, LinkedList ���� ����
		//System.out.println("-----");
		//System.out.println(person.getName());
		//System.out.println(person.getAge());
		//System.out.println("-----");
		
		LinkedList<String> mm = new LinkedList<String>();
		mm.add("aa");
		mm.add("bb");
		mm.add("cc");
		
		
		model.addAttribute("mmm", mm);
		
		return "LionView";
	}
	
}
