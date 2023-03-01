package spring.mvc.service;

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
}
