package kr.or.kosta.spring.board.service;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Inject
	private BoardService service;
	
//	@Test
	public void testExist() throws SQLException{
		log.info(service);
		assertNotNull(service);
	}
	
//	@Test
	public void testRegister() throws SQLException{
		BoardVO board = new BoardVO();
		board.setTitle("새글 제목 서비스");
		board.setContent("새 내용 서비스");
		board.setWriter("newbie");
		service.register(board);
		log.info("생성된 번호 : " + board.getBno());
	}
	
	@Test
	public void testGetlist() throws SQLException{
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
//	@Test
	public void testGet() throws SQLException{
		log.info(service.get(5L));
	}
	
//	@Test
	public void testModify() throws SQLException{
		BoardVO board = service.get(5L);
		if(board == null) return;
		board.setTitle("제목수정합니다..서비스");
		log.info("modify result  : " + service.modify(board));
	}
	
//	@Test
	public void testRemove() throws SQLException{
		log.info("remove result : "  + service.remove(6L));
	}

}
