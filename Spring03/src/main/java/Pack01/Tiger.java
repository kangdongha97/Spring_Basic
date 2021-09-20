package Pack01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 컨트롤러임을 @어노테이션을 이용해 선언
@Controller
public class Tiger {
	// @매핑함수 임을 선언 
	// 요청에 대한 id를 보내 연결시킴
	// t1을 요청하면 t1에 매핑된 method01함수가 콜됨
	@RequestMapping("/t1")
	public String method01() {
		System.out.println("함수콜1");
		return null;
	}
	
	@RequestMapping("/t2")
	public String method02() {
		System.out.println("함수콜2");
		// 리턴에 연결할 뷰(jsp)의 이름을 적어주면 됨
		return "TigerView"; // 컨트롤러 이름이 Tiger이면 뷰 이름은 TigerView 라고 짓는건이 관례
	}
	
	@ResponseBody
	@RequestMapping("/t3")
	public String method03() {
		System.out.println("함수콜3");
		return "Tiger Call"; // 화면전환 없이 원래 화면에 리턴값 출력 (컨트롤러 테스트 용도로 사용)
	}

	//인수전달 받는 방법
	//value="name" name 으로 넘어온 값을 String name 변수에 초기화
	@RequestMapping("/t4")
	public String method04(
			@RequestParam(value="name") String name
			) {
		System.out.println("함수콜4" + name);
		return "TigerView"; // 화면전환 없이 원래 화면에 리턴값 출력 (컨트롤러 테스트 용도로 사용)
	}
	
	@RequestMapping("/t5")
	public String method05(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") int age
			) {
		System.out.println("함수콜5" + name + age);
		return "TigerView"; // 화면전환 없이 원래 화면에 리턴값 출력 (컨트롤러 테스트 용도로 사용)
	}
	
	//인수전달 다른방법, 전체 받아옴
	@RequestMapping("/t6")
	public String method06(
			HttpServletRequest request
			) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("함수콜6" + name + age);
		return "TigerView"; // 화면전환 없이 원래 화면에 리턴값 출력 (컨트롤러 테스트 용도로 사용)
	}
	
	// 컨트롤러에서 뷰로 인수전달 하는 방법
	@RequestMapping("/t7")
	public String method07(Model model) {
		// model 객체로 인수전달, TigerView를 리턴할 때 모델객체가 같이 전달됨
		model.addAttribute("name", "앵무새");
		model.addAttribute("age", 100);
		System.out.println("함수콜7");
		return "TigerView";
	}
	
}
