package kr.or.kosta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// BcryptPasswordEnder를 이용해서 암호화 처리후 테이블 인서트 테스트
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	                   "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberTest {

	@Inject
	private PasswordEncoder passwordEncoder;
	@Inject
	private DataSource dataSource;
	
	// 회원 추가
//	@Test
	public void testInsertMember(){
		String sql = "insert into tbl_member(userid, userpw, username) \n" +
	                 "values(?, ?, ?)";
		
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(2, passwordEncoder.encode("pw"+i));
				if(i<80) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "일반사용자"+i);
					
				}else if(i<90) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(3, "운영자"+i);
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3, "관리자"+i);
				}
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {}
				}
				
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {}
				}
			}
		}
		log.info("테스트를 위한 member 추가 완료!");
	}
	
//	@Test
	public void testInsertAuth(){
		String sql = "insert into tbl_member_auth(userid, auth) \n" +
	                 "values(?, ?)";
		
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				if(i<80) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(2, "ROLE_USER");
					
				}else if(i<90) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(2, "ROLE_MEMBER");
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {}
				}
				
				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {}
				}
			}
		}
		log.info("테스트를 위한 member_auth 추가 완료!");
	}
	
}







