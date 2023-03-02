package spring.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import spring.mvc.dto.MemberDTO;
import spring.mvc.service.MemberService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/save")
	public String saveForm() {
		return "/member/save";
	}
	

	@PostMapping("/save")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		int saveResult = memberService.save(memberDTO);
		
		if (saveResult > 0) {
			return "/member/login";
		} else {
			return "/member/save";
		}

	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		boolean loginResult = memberService.login(memberDTO);
		if(loginResult) {
			session.setAttribute("loginEmail", memberDTO.getMemberEmail());
			return "/index";
		}else {
			return "/member/login";
		}
	}
	
	
	@GetMapping("/")
	public String findAll(Model model) {
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList", memberDTOList);
		return "/member/list";
	}
	
	
	//member?id=1
	@GetMapping
	public String findById(@RequestParam("id") Long id, Model model) {
		MemberDTO memberDTO = memberService.findById(id);
		model.addAttribute("member", memberDTO);
		return "/member/detail";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "redirect:/member/";	
		}
	
	
	//수정화면 요청
	@GetMapping("/update")
	public String updateForm(HttpSession session , Model model) {
		//세션에 저장된 나의 이메일 가져오기
		String loginEmail = (String) session.getAttribute("loginEmail");
		//System.out.println("@@@@@@@ loginEmail ::::::" + loginEmail);
		MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
		model.addAttribute("member", memberDTO);
		//System.out.println("@@@@@@@ memberDTO ::::::" + memberDTO);
		return "/member/update";
	}
	
	
	//수정처리
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		boolean result = memberService.update(memberDTO);
		if(result) {
			//어떤회원이수정을 했는지 알기위해서 아이디값으로
			return "redirect:/member?id=" + memberDTO.getId();
		}else {
			return "index";
		}
	}
	
	
	
	
}
