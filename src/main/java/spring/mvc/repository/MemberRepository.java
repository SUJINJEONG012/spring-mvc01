package spring.mvc.repository;

import org.springframework.stereotype.Repository;

import spring.mvc.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	public int save(MemberDTO memberDTO) {
		System.out.println("memberDTO" + memberDTO);
		return 0;
	}
}
