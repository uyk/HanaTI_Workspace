package kr.or.kosta.sjrent.qna.service;

import java.util.List;

import kr.or.kosta.sjrent.qna.dao.QnADao;
import kr.or.kosta.sjrent.qna.domain.QnA;

public class QnAServiceImpl implements QnAService {

	QnADao qnaDao;
	
	
	public QnADao getQnaDao() {
		return qnaDao;
	}

	public void setQnaDao(QnADao qnaDao) {
		this.qnaDao = qnaDao;
	}

	@Override
	public void create(QnA qna) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public QnA read(int number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QnA qna) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<QnA> listAll(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnA> listByPage(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countListAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
