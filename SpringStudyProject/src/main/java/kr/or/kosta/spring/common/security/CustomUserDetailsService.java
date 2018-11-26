package kr.or.kosta.spring.common.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.kosta.spring.common.security.domain.CustomUser;
import kr.or.kosta.spring.member.domain.Member;
import kr.or.kosta.spring.member.mapper.MemberMapper;
import lombok.extern.log4j.Log4j;

/**
 * 커스텀 UserDetailsService 구현 클래스
 * Mybatis 이용하여 테이블의 사용자 정보 직접 제공
 * - 사용자의 아이디 정도가 아닌 이름이나 이메일 같은 추가적인 정보 활용 가능
 * - RDBMS 뿐만 아니라 LDAP이나 기타 Social 인증 정보 활용 가능
 * @author 김기정
 */
@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		log.info("Load User By UserName : " + username);
		Member member =  memberMapper.read(username);
		if(member != null) {
			userDetails = new CustomUser(member);
		}
		return userDetails;
	}
}
