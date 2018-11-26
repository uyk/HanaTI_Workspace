package kr.or.kosta.spring.common.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.kosta.spring.member.domain.Member;
import lombok.Getter;

/**
 * 커스텀 UserDetails 구현 클래스
 * @author 김기정
 */
@Getter
public class CustomUser extends User/* implements UserDetails */{
	
	private Member member;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(Member member) {
		super(member.getUserid(), member.getUserpw(), member.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = member;
	}
}
