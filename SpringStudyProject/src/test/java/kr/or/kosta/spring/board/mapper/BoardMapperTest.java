package kr.or.kosta.spring.board.mapper;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.employee.mapper.EmployeeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	@Inject
	private BoardMapper boardMapper;
	
//	@Test
	public void getListTest() throws SQLException{
		log.info(boardMapper);
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
//	@Test
	public void insertTest() throws SQLException{
		BoardVO board = new BoardVO();
		board.setTitle("새글");
		board.setContent("새 내용");
		board.setWriter("newbie");
		boardMapper.insert(board);
		log.info(board);
	}
	
//	@Test
	public void insertSelectKeyTest() throws SQLException{
		BoardVO board = new BoardVO();
		board.setTitle("새글 SelectKey");
		board.setContent("새 내용 SelectKey");
		board.setWriter("newbie");
		boardMapper.insertSelectKey(board);
		log.info(board);
	}
	
//	@Test
	public void readTest() throws SQLException{
		BoardVO board = boardMapper.read(5L);
		log.info(board);
	}
	
//	@Test
	public void deleteTest() throws SQLException{
		log.info(boardMapper.delete(2L));
	}
	
//	@Test
	public void updateTest() throws SQLException{
		BoardVO board = boardMapper.read(5L);
		log.info(board);
		
		board = new BoardVO();
		board.setBno(5L);
		board.setTitle("수정 제목");
		board.setContent("수정 내용");
		board.setWriter("user00");
		int count = boardMapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void listWithPaging() throws SQLException{
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(5);
		cri.setKeyword("새로");
		cri.setType("TC");
		boardMapper.getListWithPaging(cri).forEach(board -> log.info(board));
	}
}
