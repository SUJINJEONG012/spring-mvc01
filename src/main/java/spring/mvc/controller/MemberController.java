package spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
}
