package spring.mvc.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import spring.mvc.dto.MemberDTO;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	
	//의존성 주입받기
	private final SqlSessionTemplate sql;
	
	public int save(MemberDTO memberDTO) {
		System.out.println("memberDTO" + memberDTO);
		//memberMapper에 "Member.save" 있는 네임스페이스랑 id랑넣어주면 된다. 
		return sql.insert("Member.save", memberDTO);
	}
	
	public MemberDTO login(MemberDTO memberDTO) {
		return sql.selectOne("Member.login", memberDTO);
	}
}
