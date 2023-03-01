package spring.mvc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
// 회원에 관한 정보를 여기에 정리, 중간전달역할
private Long id;
private String memberEmail;
private String memberPassword;
private String memberName;
private int memberAge;
private String memberMobile;

}
