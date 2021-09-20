package Pack01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// ��Ʈ�ѷ����� @������̼��� �̿��� ����
@Controller
public class Tiger {
	// @�����Լ� ���� ���� 
	// ��û�� ���� id�� ���� �����Ŵ
	// t1�� ��û�ϸ� t1�� ���ε� method01�Լ��� �ݵ�
	@RequestMapping("/t1")
	public String method01() {
		System.out.println("�Լ���1");
		return null;
	}
	
	@RequestMapping("/t2")
	public String method02() {
		System.out.println("�Լ���2");
		// ���Ͽ� ������ ��(jsp)�� �̸��� �����ָ� ��
		return "TigerView"; // ��Ʈ�ѷ� �̸��� Tiger�̸� �� �̸��� TigerView ��� ���°��� ����
	}
	
	@ResponseBody
	@RequestMapping("/t3")
	public String method03() {
		System.out.println("�Լ���3");
		return "Tiger Call"; // ȭ����ȯ ���� ���� ȭ�鿡 ���ϰ� ��� (��Ʈ�ѷ� �׽�Ʈ �뵵�� ���)
	}

	//�μ����� �޴� ���
	//value="name" name ���� �Ѿ�� ���� String name ������ �ʱ�ȭ
	@RequestMapping("/t4")
	public String method04(
			@RequestParam(value="name") String name
			) {
		System.out.println("�Լ���4" + name);
		return "TigerView"; // ȭ����ȯ ���� ���� ȭ�鿡 ���ϰ� ��� (��Ʈ�ѷ� �׽�Ʈ �뵵�� ���)
	}
	
	@RequestMapping("/t5")
	public String method05(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") int age
			) {
		System.out.println("�Լ���5" + name + age);
		return "TigerView"; // ȭ����ȯ ���� ���� ȭ�鿡 ���ϰ� ��� (��Ʈ�ѷ� �׽�Ʈ �뵵�� ���)
	}
	
	//�μ����� �ٸ����, ��ü �޾ƿ�
	@RequestMapping("/t6")
	public String method06(
			HttpServletRequest request
			) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("�Լ���6" + name + age);
		return "TigerView"; // ȭ����ȯ ���� ���� ȭ�鿡 ���ϰ� ��� (��Ʈ�ѷ� �׽�Ʈ �뵵�� ���)
	}
	
	// ��Ʈ�ѷ����� ��� �μ����� �ϴ� ���
	@RequestMapping("/t7")
	public String method07(Model model) {
		// model ��ü�� �μ�����, TigerView�� ������ �� �𵨰�ü�� ���� ���޵�
		model.addAttribute("name", "�޹���");
		model.addAttribute("age", 100);
		System.out.println("�Լ���7");
		return "TigerView";
	}
	
}
