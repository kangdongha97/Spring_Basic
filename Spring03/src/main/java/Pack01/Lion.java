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
			// 첫 번째 파라미터가 보내는 것, 두 번째가 받은 것
			Model model,
			HttpServletRequest r
			) {
		String name = r.getParameter("name");
		String age = r.getParameter("age");
		
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println("함수콜8");
		return "LionView";
	}
	
	@RequestMapping("/t9")
	public ModelAndView method09() {
		//LionView 로 넘어감 리턴을 객체로 변경
		ModelAndView mv = new ModelAndView("LionView");
		mv.addObject("name", "고양이");
		mv.addObject("age", "100");
		System.out.println("함수콜9");
		return mv;
	}
	
	
	@RequestMapping("/t10")
	public ModelAndView method10() {
		//삼항연산 가능
		ModelAndView mv = new ModelAndView(
				3 < 2 ? "TigerView" : "LionView"
					);
		mv.addObject("name", "고양이");
		mv.addObject("age", 100);
		System.out.println("함수콜10");
		return mv;
	}
	
//	
//	@RequestMapping("/t12")
//	public ModelAndView method12() {
//		//LionView 로 넘어감 리턴을 객체로 변경
//		ModelAndView mv = new ModelAndView("LionView");
//		
//		System.out.println("함수콜12");
//		return mv;
//	}
	
	@RequestMapping("/t12")
	public String method12(Model model, Person person) {
		// 함수 호출되면 person에 전송받은 인수들이 들어감
		// person.getName, Age
		
		// person 객체를 ppp 이름으로 인수 전달
		//model.addAttribute("ppp", person);
		// 배열전송, LinkedList 전송 가능
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
