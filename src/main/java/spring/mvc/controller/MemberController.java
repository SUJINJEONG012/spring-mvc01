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
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	//???????????? ??????
	@GetMapping("/update")
	public String updateForm(HttpSession session , Model model) {
		//????????? ????????? ?????? ????????? ????????????
		String loginEmail = (String) session.getAttribute("loginEmail");
		//System.out.println("@@@@@@@ loginEmail ::::::" + loginEmail);
		MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
		model.addAttribute("member", memberDTO);
		//System.out.println("@@@@@@@ memberDTO ::::::" + memberDTO);
		return "/member/update";
	}
	
	
	//????????????
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		boolean result = memberService.update(memberDTO);
		if(result) {
			//???????????????????????? ????????? ??????????????? ??????????????????
			return "redirect:/member?id=" + memberDTO.getId();
		}else {
			return "index";
		}
	}
	
	@PostMapping("/email-check")
	public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
		System.out.println("memberEmail : " + memberEmail );
		String checkResult = memberService.emailCheck(memberEmail);
		return checkResult;
	}
	
	
	
}
