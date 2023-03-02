package spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.mvc.dto.MemberDTO;
import spring.mvc.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	
	public int save(MemberDTO memberDTO) {
		return memberRepository.save(memberDTO);
	}

	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberRepository.login(memberDTO);
		if(loginMember != null) {
			return true;
		}else {
			return false;
		}
		
	}

	public List<MemberDTO> findAll() {
		return memberRepository.findAll();
	}
}
